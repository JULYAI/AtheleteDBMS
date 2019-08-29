import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Scoring4 implements ActionListener {
    public JPanel panel1;
    private JButton 返回Button;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label给分1;
    private JLabel label5;
    private JLabel label给分2;
    private JLabel label7;
    private JLabel label给分3;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel P分;
    private JLabel D分;
    private JButton 确认Button;
    private JButton 打回重审Button;
    private JButton 打回重审Button1;
    private JButton 打回重审Button2;
    private JLabel label11;
    private JLabel label;
    private JFrame pFrame;
    private JFrame frame;
    private String group;
    private String seq;
    private Boolean isActive;
    private Boolean isActive1;
    private Boolean isActive2;
    List<String> revList;
    String mJudge;
    public Scoring4(JFrame pFrame,JFrame frame,String group,String seq,String mJudge){
        this.pFrame=pFrame;
        this.frame=frame;
        this.group=group;
        this.seq=seq;
        this.mJudge=mJudge;
        this.pFrame.setVisible(false);
        确认Button.addActionListener(this);
        打回重审Button.addActionListener(this);
        打回重审Button1.addActionListener(this);
        打回重审Button2.addActionListener(this);
        返回Button.addActionListener(this);
        label给分1.setText("");
        label给分2.setText("");
        label给分3.setText("");
        List<String> msgList =new ArrayList<>();
        msgList.add(mJudge);
        msgList.add(group);
        msgList.add(seq);
        Send.send(Send.msgProSend("151",msgList));

        revList=Receive.msgProReceive(Receive.receive());
        label11.setText(revList.get(1));
        label.setText(group);

        if(revList.get(revList.size()-1).equals("1")) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        //TODO 接收得分
                        List<String> revList1 = Receive.msgProReceive(Receive.receive());
                        if (revList1.get(0).equals("242")) {
                            if (revList1.get(2).equals(revList.get(2))) {
                                label给分1.setText(revList1.get(1));
                                打回重审Button.setEnabled(true);
                            }
                            if (revList1.get(2).equals(revList.get(3))) {
                                label给分2.setText(revList1.get(1));
                                打回重审Button1.setEnabled(true);
                            }
                            if (revList1.get(2).equals(revList.get(4))) {
                                label给分3.setText(revList1.get(1));
                                打回重审Button2.setEnabled(true);
                            }
                        }

                    }
                }
            }).start();

        }else{
            打回重审Button.setEnabled(false);
            打回重审Button1.setEnabled(false);
            打回重审Button2.setEnabled(false);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==打回重审Button){
            //TODO 向裁判发送消息
            List<String> msgList=new ArrayList<>();
            msgList.add(group);
            msgList.add(seq);
            msgList.add(revList.get(2));
            label给分1.setText("");
            Send.send(Send.msgProSend("152",msgList));

        }
        else if(e.getSource()==打回重审Button1){
            //TODO 向裁判发送消息
            List<String> msgList=new ArrayList<>();
            msgList.add(group);
            msgList.add(seq);
            msgList.add(revList.get(3));
            label给分2.setText("");
            Send.send(Send.msgProSend("152",msgList));
            打回重审Button1.setEnabled(false);

        }
        else if(e.getSource()==打回重审Button2){
            //TODO 向裁判发送消息
            List<String> msgList=new ArrayList<>();
            msgList.add(group);
            msgList.add(seq);
            msgList.add(revList.get(4));
            label给分3.setText("");
            Send.send(Send.msgProSend("152",msgList));
            打回重审Button2.setEnabled(false);

        }
        else if(e.getSource()==确认Button){
            //TODO 把比赛状态改为1 存所有分
            List<String> msgList=new ArrayList<>();
            msgList.add(group);
            msgList.add(seq);
            msgList.add(revList.get(2));
            msgList.add(revList.get(3));
            msgList.add(revList.get(4));
            msgList.add(label给分1.getText());
            msgList.add(label给分2.getText());
            msgList.add(label给分3.getText());
            msgList.add(textField1.getText());
            msgList.add(textField2.getText());
            Send.send(Send.msgProSend("153",msgList));
            打回重审Button.setEnabled(false);
            打回重审Button1.setEnabled(false);
            打回重审Button2.setEnabled(false);
            MyDialog myDialog=new MyDialog(this.frame,"已经将所有得分上传！");

        }
        else if(e.getSource()==返回Button){
            this.pFrame.setVisible(true);
            this.frame.dispose();
        }
    }
}
