import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Scoring2 implements ActionListener {
    public JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton 返回Button;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton 提交Button;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JButton 提交Button1;
    private JButton 提交Button2;
    private JButton 提交Button3;
    private JButton 提交Button4;
    private JButton 提交Button5;
    private JLabel label;
    private JFrame pFrame;
    private JFrame frame;
    private String group;
    private Boolean isActive=false;
    private Boolean isActive1=false;
    private Boolean isActive2=false;
    private Boolean isActive3=false;
    private Boolean isActive4=false;
    private Boolean isActive5=false;
    private List<String> revList;
    private String judge;

    public Scoring2(JFrame pFrame,JFrame frame,String group,String judge){
        this.pFrame=pFrame;
        this.frame=frame;
        this.judge=judge;
        this.group=group;
        label.setText(group);
        this.pFrame.setVisible(false);
        提交Button.addActionListener(this);
        提交Button1.addActionListener(this);
        提交Button3.addActionListener(this);
        提交Button4.addActionListener(this);
        提交Button5.addActionListener(this);
        提交Button2.addActionListener(this);
        返回Button.addActionListener(this);
        List<String> msgList =new ArrayList<>();
        msgList.add(group);
        msgList.add(judge);
        Send.send(Send.msgProSend("141",msgList));
        revList=Receive.msgProReceive(Receive.receive());
        setUp();
    }

    public void setUp(){
        if(revList.get(revList.size()-1).equals("1")) {
            //TODO 从数据库查到isActive
            if (revList.get(7).equals("0")) {
                提交Button.setEnabled(true);
            } else {
                提交Button.setEnabled(false);
            }
            if (revList.get(8).equals("0")) {
                提交Button1.setEnabled(true);
            } else {
                提交Button1.setEnabled(false);
            }
            if (revList.get(9).equals("0")) {
                提交Button2.setEnabled(true);
            } else {
                提交Button2.setEnabled(false);
            }
            if (revList.get(10).equals("0")) {
                提交Button3.setEnabled(true);
            } else {
                提交Button3.setEnabled(false);
            }
            if (revList.get(11).equals("0")) {
                提交Button4.setEnabled(true);
            } else {
                提交Button4.setEnabled(false);
            }
            if (revList.get(12).equals("0")) {
                提交Button5.setEnabled(true);
            } else {
                提交Button5.setEnabled(false);
            }
        }else{
            提交Button.setEnabled(false);
            提交Button1.setEnabled(false);
            提交Button2.setEnabled(false);
            提交Button3.setEnabled(false);
            提交Button4.setEnabled(false);
            提交Button5.setEnabled(false);

        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    List<String> revList1=Receive.msgProReceive(Receive.receive());
                    if(revList1.get(0).equals("252")||revList1.get(0).equals("234")){

                        if (revList1.get(1).equals(revList.get(1))) {
                            textField1.setText("");
                            提交Button.setEnabled(true);
                        }
                        if (revList1.get(1).equals(revList.get(2))) {
                            textField2.setText("");
                            提交Button1.setEnabled(true);
                        }
                        if (revList1.get(1).equals(revList.get(3))) {
                            textField3.setText("");
                            提交Button2.setEnabled(true);
                        }
                        if (revList1.get(1).equals(revList.get(4))) {
                            textField4.setText("");
                            提交Button3.setEnabled(true);
                        }
                        if (revList1.get(1).equals(revList.get(5))) {
                            textField5.setText("");
                            提交Button4.setEnabled(true);
                        }
                        if (revList1.get(1).equals(revList.get(6))) {
                            textField6.setText("");
                            提交Button5.setEnabled(true);
                        }

                    }
                }
            }
        }).start();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==提交Button){
            List<String> msgList =new ArrayList<>();
            msgList.add(revList.get(1));
            msgList.add(group);
            msgList.add(textField1.getText());
            msgList.add(judge);
            Send.send(Send.msgProSend("142",msgList));
            //TODO 发给总裁判并存入数据库中
            提交Button.setEnabled(false);
        }
        if(e.getSource()==提交Button1){
            String score2=textField2.getText();
            List<String> msgList =new ArrayList<>();
            msgList.add(revList.get(2));
            msgList.add(group);
            msgList.add(textField2.getText());
            msgList.add(judge);
            Send.send(Send.msgProSend("142",msgList));
            提交Button1.setEnabled(false);
            //TODO 发给总裁判
        }
        if(e.getSource()==提交Button2){
            String score3=textField3.getText();
            List<String> msgList =new ArrayList<>();
            msgList.add(revList.get(3));
            msgList.add(group);
            msgList.add(textField3.getText());
            Send.send(Send.msgProSend("142",msgList));
            提交Button2.setEnabled(false);
            //TODO 发给总裁判
        }
        if(e.getSource()==提交Button3){
            String score4=textField4.getText();
            List<String> msgList =new ArrayList<>();
            msgList.add(revList.get(4));
            msgList.add(group);
            msgList.add(textField4.getText());
            msgList.add(judge);
            Send.send(Send.msgProSend("142",msgList));
            提交Button3.setEnabled(false);
            //TODO 发给总裁判
        }
        if(e.getSource()==提交Button4){
            String score5=textField5.getText();
            List<String> msgList =new ArrayList<>();
            msgList.add(revList.get(5));
            msgList.add(group);
            msgList.add(textField5.getText());
            Send.send(Send.msgProSend("142",msgList));
            提交Button4.setEnabled(false);
            //TODO 发给总裁判
        }
        if(e.getSource()==提交Button5){
            String score6=textField6.getText();
            List<String> msgList =new ArrayList<>();
            msgList.add(revList.get(6));
            msgList.add(group);
            msgList.add(textField6.getText());
            Send.send(Send.msgProSend("142",msgList));
            提交Button5.setEnabled(false);
            //TODO 发给总裁判
        }

    }
}
