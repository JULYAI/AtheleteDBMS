import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Grouping2 implements ActionListener {
    private Frame pFrame;
    public JPanel panel1;
    private JButton 返回Button;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JButton 开始比赛Button;
    private JButton 开始比赛Button1;
    private JButton 开始比赛Button2;
    private JButton 开始比赛Button4;
    private JButton 开始比赛Button3;
    private JButton 开始比赛Button5;
    private JLabel label;
    private Frame frame;
    private boolean isActive=false;
    private boolean isActive1=false;
    private boolean isActive2=false;
    private boolean isActive3=false;
    private boolean isActive4=false;
    private boolean isActive5=false;
    List<String> revList;


    public Grouping2(Frame pFrame,Frame frame,String group){
        this.pFrame=pFrame;
        this.frame=frame;
        this.pFrame.setVisible(false);
        label.setText(group);
        开始比赛Button.addActionListener(this);
        开始比赛Button1.addActionListener(this);
        开始比赛Button2.addActionListener(this);
        开始比赛Button3.addActionListener(this);
        开始比赛Button4.addActionListener(this);
        开始比赛Button5.addActionListener(this);
        返回Button.addActionListener(this);
        List<String> msgList =new ArrayList<>();
        msgList.add(group);
        Send.send(Send.msgProSend("133",msgList));
        revList=Receive.msgProReceive(Receive.receive());
        if(revList.get(0).equals("233")){
            label3.setText(revList.get(1));
            label5.setText(revList.get(2));
            label7.setText(revList.get(3));
            label9.setText(revList.get(4));
            label11.setText(revList.get(5));
            label13.setText(revList.get(6));


        }
        setUp();
    }

    public void setUp(){
        //TODO 查数据库本组队员以及查看比赛状态修改isActice
        if (revList.get(7).equals("-1")){
            开始比赛Button.setEnabled(true);
        }else{
            开始比赛Button.setEnabled(false);
        }
        if (revList.get(8).equals("-1")){
            开始比赛Button1.setEnabled(true);
        }else{
            开始比赛Button1.setEnabled(false);
        }
        if (revList.get(9).equals("-1")){
            开始比赛Button2.setEnabled(true);
        }else{
                开始比赛Button2.setEnabled(false);
        }
        if (revList.get(10).equals("-1")){
            开始比赛Button3.setEnabled(true);
        }else{
                开始比赛Button3.setEnabled(false);
            }
            if (revList.get(11).equals("-1")){
                开始比赛Button4.setEnabled(true);
            }else{
                开始比赛Button4.setEnabled(false);
            }
            if (revList.get(12).equals("-1")){
                开始比赛Button5.setEnabled(true);
            }else{
                开始比赛Button5.setEnabled(false);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==开始比赛Button){
             开始比赛Button.setEnabled(false);
            List<String> msgList =new ArrayList<>();
            msgList.add(revList.get(1));
            msgList.add(label.getText());
            Send.send(Send.msgProSend("134",msgList));
             // 把数据库里面的比赛状态改为0//正在比；
        }
        else if(e.getSource()==开始比赛Button1){
            开始比赛Button1.setEnabled(false);
            List<String> msgList =new ArrayList<>();
            msgList.add(revList.get(2));
            msgList.add(label.getText());
            Send.send(Send.msgProSend("134",msgList));
        }
        else if(e.getSource()==开始比赛Button2){
            开始比赛Button2.setEnabled(false);
            List<String> msgList =new ArrayList<>();
            msgList.add(revList.get(3));
            msgList.add(label.getText());
            Send.send(Send.msgProSend("134",msgList));
        }
        else if(e.getSource()==开始比赛Button3){
            开始比赛Button3.setEnabled(false);
            List<String> msgList =new ArrayList<>();
            msgList.add(revList.get(4));
            msgList.add(label.getText());
            Send.send(Send.msgProSend("134",msgList));
        }
        else if(e.getSource()==开始比赛Button4){
            开始比赛Button4.setEnabled(false);
            List<String> msgList =new ArrayList<>();
            msgList.add(revList.get(5));
            msgList.add(label.getText());
            Send.send(Send.msgProSend("134",msgList));
        }
        else if(e.getSource()==开始比赛Button5){
            开始比赛Button5.setEnabled(false);
            List<String> msgList =new ArrayList<>();
            msgList.add(revList.get(6));
            msgList.add(label.getText());
            Send.send(Send.msgProSend("134",msgList));
        }
        else if(e.getSource()==返回Button){
            this.frame.dispose();
            this.pFrame.setVisible(true);
        }

    }
}
