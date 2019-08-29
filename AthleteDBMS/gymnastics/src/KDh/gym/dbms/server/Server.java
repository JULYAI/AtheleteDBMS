package KDh.gym.dbms.server;

import KDh.gym.dbms.entity.*;
import KDh.gym.dbms.service.*;
import sun.security.util.Length;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    static int aId_girl = 0;
    static int aid_boy = 1;
    static int mid = 0;
    static int staffId = 0;//这个是填队员（即队医领队那些的）的staffID
    private List<MyChannal> all =new ArrayList<MyChannal>();
    AthleteService athleteService;

    public static void main(String[]args) throws IOException {
            Server server=new Server();
            server.start();
    }

    public void start() throws IOException {
        athleteService = new AthleteServiceImpl();
        ServerSocket server=new ServerSocket(9800);
        while(true){
            Socket client=server.accept();
            System.out.println(client.getPort());
            MyChannal channal=new MyChannal(client);
            all.add(channal);
            new Thread(channal).start();
        }
    }
    class MyChannal implements Runnable{

        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning=true;
        public String id;
        public MyChannal(Socket client){
            try {
                dis=new DataInputStream(client.getInputStream());
                dos=new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                isRunning=false;
                CloseUtil.closeAll(dis,dos);
                all.remove(this);
            }
        }
        private String receive(){
            String msg="";
            try {
                msg=dis.readUTF();
            } catch (IOException e) {
                isRunning=false;
                CloseUtil.closeAll(dis,dos);
                all.remove(this);
            }
            return msg;
        }

        private void send(String msg){
            if(null==msg||msg.equals("")){
                return;
            }
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                isRunning=false;
                CloseUtil.closeAll(dis,dos);
                all.remove(this);
            }
        }
        private void sendOthers(String id1,String firStr,List<String> sendmsg){
            for(MyChannal other:all){
                if(other.id.equals(id1)){
                    other.send(msgProSend(firStr,sendmsg));
                }

            }
        }
        @Override
        public void run() {
            while(isRunning){
                instructionPro(msgProReceive(receive()));
            }
        }

        public void instructionPro(List<String>msgList){

            List<String> sendmsg=new ArrayList<>();
            if(msgList.get(0).equals("11")){
                //TODO 给你账号#密码的数组，默认从msgList.get（1）开始，即msgList.get（1)是账号
                // 返回给我：（注意我所说的返回给我都是指往sendmsg里面添加）
                // 密码真假1/0#用户类型TID#用户名Uname   添加到sendmsg中以下默认
                //DONE!
                String istrue = "0";
                String suid = msgList.get(1);
                String password = msgList.get(2);
                UserService userService = new UserServiceImpl();
                Integer i = new Integer(suid);
                int uid = i.intValue();
                List<String> userinfo = userService.findByUId(uid);
                String tid = userinfo.get(3);
                String uName = userinfo.get(1);
                if (userinfo.get(2).equals(password) ){
                    istrue = "1";
                    this.id=msgList.get(1);
                    System.out.println(this.id);
                }else{
                    istrue = "0";
                }
                sendmsg.add(istrue);
                sendmsg.add(tid);
                sendmsg.add(uName);


                send(msgProSend("21",sendmsg));
            }
            else if(msgList.get(0).equals("121")){
                 //TODO 给你运动员的   姓名#性别#项目名1#项目名2.....(可能有多个项目），请你录入到数据库相应地方
                //DONE!
                Athlete athlete = new Athlete();
                athlete.setAName(msgList.get(1));
                athlete.setASex(msgList.get(2));
                if (msgList.get(2).equals("男") ){
                    athlete.setAID(aid_boy);
                    aid_boy = aid_boy + 2;
                }
                else{
                    athlete.setAID(aId_girl);
                    aId_girl = aId_girl +2;
                }
                AthleteService athleteService = new AthleteServiceImpl();
                athleteService.addAthlete(athlete);
                for(int i = 3;i<msgList.size();i++){
                    String pName = msgList.get(i);
                    ProjectService projectService = new ProjectServiceImpl();
                    projectService.findBypName(pName);
                    List<String> projectInfo = projectService.findBypName(pName);
                    String s_pid = projectInfo.get(0);
                    Integer i_pid = new Integer(s_pid);
                    int pid = i_pid.intValue();
                    Match match = new Match();
                    match.setmId(mid);
                    mid++;
                    match.setaId(athlete.getAID());
                    match.setpId(pid);
                    match.setState(-1);
                    MatchService matchService = new MatchServiceImpl();
                    matchService.addMatch(match);
                }

            }
            else if(msgList.get(0).equals("122")){
                //TODO 给你领队等其他人员的信息 姓名#身份#电话号码，请你录入到数据库中
                //DONE!
                Staff staff = new Staff();
                staff.setsId(staffId);
                staffId++;
                staff.setsName(msgList.get(1));
                staff.setRole(msgList.get(2));
                staff.setTel(msgList.get(3));
                StaffService staffService = new StaffServiceImpl();
                staffService.addStaff(staff);
            }
            else if(msgList.get(0).equals("131")){
                //todo 录入管理员以外的人员的用户名及密码   给你 姓名#类型#账号#密码 请你录入到数据库中
                //DONE!
                User user = new User();
                String s_uid = msgList.get(3);
                String s_type = msgList.get(2);
                Integer i = new Integer(s_uid);
                int uid = i.intValue();
                Integer a = new Integer(s_type);
                int tid = a.intValue();
                user.setuId(uid);
                user.setuName(msgList.get(1));
                user.setPassword(msgList.get(4));
                user.settId(tid);
                user.setisOnline(false);
                UserService userService = new UserServiceImpl();
                userService.addUser(user);
            }
            else if(msgList.get(0).equals("133")){
                //todo 给你组名group 返回给我 组成员1#组成员2#。。。。#组成员6#组成员比赛状态1#...组成员比赛状态6
                //todo 共12个
                //DONE!
                String groupName = msgList.get(1);
                GroupService groupService = new GroupServiceImpl();
                List<String> groupInfo = groupService.findByGName(groupName);
                String s_gid = groupInfo.get(0);
                Integer a = new Integer(s_gid);
                int gid = a.intValue();
                AthleteService athleteService = new AthleteServiceImpl();
                List<String> athleteInfo = athleteService.findByAGroupId(gid);
                for(int i = 1;i < athleteInfo.size();i = i+2){
                    sendmsg.add(athleteInfo.get(i));
                    /*MatchService matchService = new MatchServiceImpl();
                    String s_aid = athleteInfo.get(i-1);
                    Integer aid = new Integer(s_aid);
                    List<String> matchInfo = matchService.findByAId(aid,gid);*/

                }
                for(int j = 1;j< athleteInfo.size();j = j+2){
                    String s_aid = athleteInfo.get(j-1);
                    Integer i_aid = new Integer(s_aid);
                    int aid = i_aid.intValue();
                    MatchService matchService = new MatchServiceImpl();
                    List<String> matchInfo = matchService.findByAId(aid,gid);
                    sendmsg.add(matchInfo.get(4));
                }

                send(msgProSend("233",sendmsg));
            }
            else if(msgList.get(0).equals("134")){
                //todo 注意这里有三个任务
                //todo 1，给你运动员名#组名 返回给我运动员名（注意这里是往sendmsg里面填）
                //DONE!
                //todo 2，把数据库中该运动员的比赛状态改为0
                //DONE!
                List<String> judge=new ArrayList<>();
                //todo 3，往judge的list里面填有哪些人给这个运动员打分,填裁判userid 即裁判1#裁判2#裁判3
                //DONE!
                sendmsg.add(msgList.get(1));
                String aName = msgList.get(1);
                String groupName = msgList.get(2);
                AthleteService athleteService = new AthleteServiceImpl();
                List<String> athleteInfo = athleteService.findByAName(aName);
                GroupService groupService = new GroupServiceImpl();
                List<String> groupInfo = groupService.findByGName(groupName);
                String s_aid = athleteInfo.get(0);
                String s_gid = groupInfo.get(0);
                Integer a = new Integer(s_aid);
                int aid = a.intValue();
                Integer b = new Integer(s_gid);
                int gid = b.intValue();
                MatchService matchService = new MatchServiceImpl();
                List<String> matchInfo = matchService.findByAId(aid,gid);
                String s_mid = matchInfo.get(0);
                Integer c = new Integer(s_mid);
                int mid = c.intValue();
                String s_pid = matchInfo.get(1);
                Integer d = new Integer(s_pid);
                int pid = d.intValue();
                String s_seq = matchInfo.get(3);
                Integer e = new Integer(s_seq);
                int seq = e.intValue();
                Match match = new Match();
                match.setState(0);
                match.setpId(pid);
                match.setaId(aid);
                match.setmId(mid);
                match.setSeq(seq);
                matchService.updateMatch(match);
                ScoreService scoreService = new ScoreServiceImpl();
                List <String> scoreInfo = scoreService.findByaId(aid,pid);
                for(int i = 0;i<scoreInfo.size();i++){
                    String s_judgeId = scoreInfo.get(i);
                    Integer i_judgeId = new Integer(s_judgeId);
                    int judgeId = i_judgeId.intValue();
                    StaffService staffService = new StaffServiceImpl();
                    List<String> staffInfo = staffService.findBySId(judgeId);
                    String judgeName = staffInfo.get(1);
                    UserService userService = new UserServiceImpl();
                    List<String> userInfo = userService.findByUsername(judgeName);
                    judge.add(userInfo.get(0));
                }

                sendOthers(judge.get(0),"234",sendmsg);
                sendOthers(judge.get(1),"234",sendmsg);
                sendOthers(judge.get(2),"234",sendmsg);

            }
            else if(msgList.get(0).equals("141")){
                //todo 给你 组名#裁判名;返回给我 组成员1-6名字 组成员1-6状态 是否是裁判 共13项，名字先写完再写状态
                //DONE!
                String groupName = msgList.get(1);
                String judgeName = msgList.get(2);
                GroupService groupService = new GroupServiceImpl();
                List<String> groupInfo = groupService.findByGName(groupName);
                Integer c = new Integer(groupInfo.get(0));
                int gid = c.intValue();
                AthleteService athleteService = new AthleteServiceImpl();
                List <String> athleteInfo = athleteService.findByAGroupId(gid);
                for(int i = 1;i < athleteInfo.size();i = i+2){
                    sendmsg.add(athleteInfo.get(i));
                }
                for(int j = 0;j <athleteInfo.size(); j = j+2){
                    String s_aid = athleteInfo.get(j);
                    Integer d = new Integer(s_aid);
                    int aid = d.intValue();
                    MatchService matchService = new MatchServiceImpl();
                    List<String> matchInfo = matchService.findByAId(aid,gid);
                    sendmsg.add(matchInfo.get(4));
                }
                String isJudge = "0";
                StaffService staffService = new StaffServiceImpl();
                List<String> staffInfo = staffService.findBySName(judgeName);
                String s_staffId = staffInfo.get(0);
                Integer i_staffId = new Integer(s_staffId);
                int staff_Id = i_staffId.intValue();
                String s_one_of_aId = athleteInfo.get(0);
                Integer i_one_of_aId = new Integer(s_one_of_aId);
                int one_of_aId = i_one_of_aId.intValue();
                MatchService matchService = new MatchServiceImpl();
                String s_pid = (matchService.findByAId(one_of_aId,gid)).get(1);
                Integer i_pid = new Integer(s_pid);
                int pid = i_pid.intValue();
                ScoreService scoreService = new ScoreServiceImpl();
                List<String> scoreInfo = scoreService.findByaId(one_of_aId,pid);
                for(int i = 0;i<scoreInfo.size();i++){
                    String s_t_staff_id = scoreInfo.get(i);
                    Integer i_t_staff_id = new Integer(s_t_staff_id);
                    int t_staff_id = i_t_staff_id.intValue();
                    if(t_staff_id == staff_Id){
                        isJudge = "1";
                        break;
                    }
                }
                sendmsg.add(isJudge);
                send(msgProSend("241",sendmsg));
            }
            else if(msgList.get(0).equals("142")){
                //todo 给你 运动员名#组名#得分#裁判  注意得分指的是这个裁判的给分；返回给我 得分#裁判名
                //DONE!
                //todo 把这个裁判的给分存入数据库 ￥￥￥￥注意所有的存得分都是先查有没有这条记录，有则覆盖，无则添加
                //DONE!
                String id="";
                //todo 把这里的id赋值为该场比赛的主裁判userID
                //DONE!
                String athleteName = msgList.get(1);
                String groupName = msgList.get(2);
                String s_grade = msgList.get(3);
                String judgeName = msgList.get(4);
                StaffService staffService = new StaffServiceImpl();
                List<String> staffInfo = staffService.findBySName(judgeName);
                AthleteService athleteService = new AthleteServiceImpl();
                List<String> athleteInfo = athleteService.findByAName(athleteName);
                GroupService groupService = new GroupServiceImpl();
                List<String> groupInfo = groupService.findByGName(groupName);
                Integer a = new Integer(groupInfo.get(0));
                int gid = a.intValue();
                Integer b = new Integer(athleteInfo.get(0));
                int aid = b.intValue();
                Integer c = new Integer(staffInfo.get(0));
                int staffid = c.intValue();
                Integer d = new Integer(s_grade);
                int grade = d.intValue();
                MatchService matchService = new MatchServiceImpl();
                List<String> matchInfo = matchService.findByAId(aid,gid);
                Integer e = new Integer(matchInfo.get(1));
                int pid = e.intValue();
                sendmsg.add(s_grade);
                sendmsg.add(judgeName);
                ScoreService scoreService = new ScoreServiceImpl();
                List<String> scoreInfo = scoreService.findBypId(pid,aid,staffid);
                String s_scoreid = scoreInfo.get(1);
                Integer i_scoreid = new Integer(s_scoreid);
                int scoreid = i_scoreid.intValue();
                String type = scoreInfo.get(4);
                Score score = new Score();
                score.setaId(aid);
                score.setsId(scoreid);
                score.setpId(pid);
                score.setGrade(grade);
                score.setType(type);
                score.setStaffId(staffid);

                if(scoreService.findBypId(pid,aid,staffid) != null)
                {
                    scoreService.updateScore(score);
                }
                else {
                    scoreService.addScore(score);
                }
                List<String> scoreInfo1 = scoreService.findByType("P",aid,pid);
                String s_staffId1 = scoreInfo1.get(0);
                Integer staffId1 = new Integer(s_staffId1);
                int staffid1 = staffId1.intValue();
                List<String> mainJudge = staffService.findBySId(staffid1);
                String mainJudgeName = mainJudge.get(1);
                UserService userService = new UserServiceImpl();
                List<String> userInfo = userService.findByUsername(mainJudgeName);
                id = userInfo.get(0);

                sendOthers(id,"242",sendmsg);
            }
            else if(msgList.get(0).equals("151")){
                //todo 给你总裁判#group名#seq；返回给我运动员#裁判一#裁判二#裁判三，是不是这个人这个项目中的总裁判
                //DONE!
                String mainJudgeName = msgList.get(1);
                String groupName = msgList.get(2);
                String s_seq = msgList.get(3);
                Integer a = new Integer(s_seq);
                int seq = a.intValue();
                GroupService groupService = new GroupServiceImpl();
                List<String> groupInfo = groupService.findByGName(groupName);
                String s_gid = groupInfo.get(0);
                Integer b = new Integer(s_gid);
                int gid = b.intValue();
                MatchService matchService = new MatchServiceImpl();
                List<String> matchInfo = matchService.findBySeq(seq,gid);
                String athleteId = matchInfo.get(2);
                Integer c = new Integer(athleteId);
                int aid = c.intValue();
                String s_pid = (matchService.findByAId(aid,gid)).get(2);
                Integer i_pid = new Integer(s_pid);
                int pid = i_pid.intValue();
                AthleteService athleteService = new AthleteServiceImpl();
                List<String> athleteInfo = athleteService.findByAId(aid);
                String aName = athleteInfo.get(1);
                sendmsg.add(aName);
                ScoreService scoreService = new ScoreServiceImpl();
                List<String> judge1 = scoreService.findByType("1",aid,pid);
                String s_judge1Id = judge1.get(0);
                Integer i_judge1Id = new Integer(s_judge1Id);
                int judge1Id = i_judge1Id.intValue();
                StaffService staffService = new StaffServiceImpl();
                List<String> staff1Info = staffService.findBySId(judge1Id);
                String staff1Name = staff1Info.get(1);
                sendmsg.add(staff1Name);
                List<String> judge2 = scoreService.findByType("2",aid,pid);
                String s_judge2Id = judge2.get(0);
                Integer i_judge2Id = new Integer(s_judge2Id);
                int judge2Id = i_judge2Id.intValue();
                List<String> staff2Info = staffService.findBySId(judge2Id);
                String staff2Name = staff2Info.get(1);
                sendmsg.add(staff2Name);
                List<String> judge3 = scoreService.findByType("3",aid,pid);
                String s_judge3Id = judge3.get(0);
                Integer i_judge3Id = new Integer(s_judge3Id);
                int judge3Id = i_judge3Id.intValue();
                List<String> staff3Info = staffService.findBySId(judge3Id);
                String staff3Name = staff3Info.get(1);
                sendmsg.add(staff3Name);
                List<String> judgeMain = scoreService.findByType("P",aid,pid);
                String s_judgeMainId = judgeMain.get(0);
                Integer i_judgeMainId = new Integer(s_judgeMainId);
                int judgeMainId = i_judgeMainId.intValue();
                List<String> staffMainInfo = staffService.findBySId(judgeMainId);
                String staffMainName = staffMainInfo.get(1);
                if (staffMainName.equals(mainJudgeName) ){
                    sendmsg.add("1");
                }else{
                    sendmsg.add("0");
                }

                send(msgProSend("251",sendmsg));
            }
            else if(msgList.get(0).equals("152")){
                //todo 给你组名#seq#裁判（这里是告诉你是哪组比赛的哪个裁判） 返回给我运动员名
                //DONE!
                String id="";
                //todo 这里修改为该裁判的userID
                //DONE!
                String groupName = msgList.get(1);
                String s_seq =msgList.get(2);
                String judgeName = msgList.get(3);

                GroupService groupService = new GroupServiceImpl();
                List<String> groupInfo = groupService.findByGName(groupName);
                String s_gid = groupInfo.get(0);
                Integer i_gid = new Integer(s_gid);
                int gid = i_gid.intValue();
                Integer i_seq = new Integer(s_seq);
                int seq = i_seq.intValue();
                MatchService matchService = new MatchServiceImpl();
                List<String> matchInfo = matchService.findBySeq(seq,gid);
                String s_aid = matchInfo.get(2);
                Integer i_aid = new Integer(s_aid);
                int aid = i_aid.intValue();
                AthleteService athleteService = new AthleteServiceImpl();
                List<String> athleteInfo = athleteService.findByAId(aid);
                String aName = athleteInfo.get(1);
                sendmsg.add(aName);
                UserService userService = new UserServiceImpl();
                List<String> userInfo = userService.findByUsername(judgeName);
                id = userInfo.get(0);

                sendOthers(id,"252",sendmsg);
            }
            else if(msgList.get(0).equals("153")){
                //todo 给你组名#seq#裁判1-3#裁判1-3的分#p分#d分
                // 1，你需要把该运动员的比赛状态改为1
                // 并且把上面的所有得分存入数据库 同样是有则改，无则添加
                //DONE!
                String groupName = msgList.get(1);
                String s_seq = msgList.get(2);
                String judge1Name = msgList.get(3);
                String judge2Name = msgList.get(4);
                String judge3Name = msgList.get(5);
                String judge1Score = msgList.get(6);
                String judge2Score = msgList.get(7);
                String judge3Score = msgList.get(8);
                String Pscore = msgList.get(9);
                String Dscore = msgList.get(10);
                GroupService groupService = new GroupServiceImpl();
                List<String> groupInfo = groupService.findByGName(groupName);
                String s_gid = groupInfo.get(0);
                Integer i_gid = new Integer(s_gid);
                int gid = i_gid.intValue();
                Integer i_seq = new Integer(s_seq);
                int seq = i_seq.intValue();
                MatchService matchService = new MatchServiceImpl();
                List<String> matchInfo = matchService.findBySeq(seq,gid);
                String s_mid = matchInfo.get(0);
                Integer i_mId = new Integer(s_mid);
                int mid = i_mId.intValue();
                String s_aId = matchInfo.get(2);
                Integer i_aId = new Integer(s_aId);
                int aid = i_aId.intValue();
                String s_pId = matchInfo.get(1);
                Integer i_pId = new Integer(s_pId);
                int pId = i_pId.intValue();
                Match match = new Match();
                match.setmId(mid);
                match.setpId(pId);
                match.setaId(aid);
                match.setSeq(seq);
                match.setState(1);
                match.setgId(gid);
                matchService.updateMatch(match);

                StaffService staffService = new StaffServiceImpl();
                String s_sid1 = (staffService.findBySName(judge1Name)).get(0);
                Integer i_sid1 = new Integer(s_sid1);
                int staffid1 = i_sid1.intValue();
                String s_sid2 = (staffService.findBySName(judge2Name)).get(0);
                Integer i_sid2 = new Integer(s_sid2);
                int staffid2 = i_sid2.intValue();
                String s_sid3 = (staffService.findBySName(judge3Name)).get(0);
                Integer i_sid3 = new Integer(s_sid3);
                int staffid3 = i_sid3.intValue();
                Integer i_score1 = new Integer(judge1Score);
                int score1 = i_score1.intValue();
                Integer i_score2 = new Integer(judge2Score);
                int score2 = i_score2.intValue();
                Integer i_score3 = new Integer(judge3Score);
                int score3 = i_score3.intValue();
                Integer i_pscore = new Integer(Pscore);
                int pscore = i_pscore.intValue();
                Integer i_dscore = new Integer(Dscore);
                int dscore = i_dscore.intValue();

                ScoreService scoreService = new ScoreServiceImpl();
                List<String> scoreInfo1 = scoreService.findBypId(pId,aid,staffid1);
                String s_scoreid = scoreInfo1.get(1);
                Integer i_scoreid = new Integer(s_scoreid);
                int scoreid = i_scoreid.intValue();
                String type = scoreInfo1.get(4);
                Score score = new Score();
                score.setaId(aid);
                score.setsId(scoreid);
                score.setpId(pId);
                score.setGrade(score1);
                score.setType(type);
                score.setStaffId(staffid1);
                if(scoreService.findBypId(pId,aid,staffId) != null && scoreService.findBypId(pId,aid,staffId).size() >= 0)
                {
                    scoreService.updateScore(score);
                }
                else {
                    scoreService.addScore(score);
                }

                List<String> scoreInfo2 = scoreService.findBypId(pId,aid,staffid2);
                String s_scoreid2 = scoreInfo2.get(1);
                Integer i_scoreid2 = new Integer(s_scoreid2);
                int scoreid2 = i_scoreid2.intValue();
                String type2 = scoreInfo2.get(4);
                score.setaId(aid);
                score.setsId(scoreid2);
                score.setpId(pId);
                score.setGrade(score2);
                score.setType(type2);
                score.setStaffId(staffid2);
                if(scoreService.findBypId(pId,aid,staffid2) != null)
                {
                    scoreService.updateScore(score);
                }
                else {
                    scoreService.addScore(score);
                }

                List<String> scoreInfo3 = scoreService.findBypId(pId,aid,staffid3);
                String s_scoreid3 = scoreInfo3.get(1);
                Integer i_scoreid3 = new Integer(s_scoreid3);
                int scoreid3 = i_scoreid3.intValue();
                String type3 = scoreInfo3.get(4);
                score.setaId(aid);
                score.setsId(scoreid3);
                score.setpId(pId);
                score.setGrade(score3);
                score.setType(type3);
                score.setStaffId(staffid3);
                if(scoreService.findBypId(pId,aid,staffid3) != null)
                {
                    scoreService.updateScore(score);
                }
                else {
                    scoreService.addScore(score);
                }

                String s_staffidMain = (scoreService.findByType("P",aid,pId)).get(0);
                Integer i_staffidMain = new Integer(s_staffidMain);
                int staffidMain = i_staffidMain.intValue();
                List<String> scoreInfo4 = scoreService.findP_DScore(pId,aid,staffidMain,"P");
                String s_scoreid4 = scoreInfo4.get(1);
                Integer i_scoreid4 = new Integer(s_scoreid4);
                int scoreid4 = i_scoreid4.intValue();
                String type4 = scoreInfo4.get(4);
                score.setaId(aid);
                score.setsId(scoreid4);
                score.setpId(pId);
                score.setGrade(pscore);
                score.setType(type4);
                score.setStaffId(staffidMain);
                if(scoreService.findBypId(pId,aid,staffidMain) != null)
                {
                    scoreService.updateScore(score);
                }
                else {
                    scoreService.addScore(score);
                }

                List<String> scoreInfo5 = scoreService.findP_DScore(pId,aid,staffidMain,"D");
                String s_scoreid5 = scoreInfo5.get(1);
                Integer i_scoreid5 = new Integer(s_scoreid5);
                int scoreid5 = i_scoreid5.intValue();
                String type5 = scoreInfo5.get(4);
                score.setaId(aid);
                score.setsId(scoreid5);
                score.setpId(pId);
                score.setGrade(dscore);
                score.setType(type5);
                score.setStaffId(staffidMain);
                if(scoreService.findBypId(pId,aid,staffidMain) != null)
                {
                    scoreService.updateScore(score);
                }
                else {
                    scoreService.addScore(score);
                }

            }

        }

        public List<String> msgProReceive(String msg){
            List<String> msgList= Arrays.asList(msg.split("#"));
            return msgList;
        }

        public String msgProSend(String fisrtInstr,List<String> msgList){
            String processedmsg=fisrtInstr;
            for(int i=0;i<msgList.size();i++){
                processedmsg+="#"+msgList.get(i);
            }
            return processedmsg;
        }
    }

}
