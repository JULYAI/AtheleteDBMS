import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class LoginFrame implements ActionListener {
    public JPanel panel1;
    private JButton 登陆Button;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JFrame frame;
    public LoginFrame(JFrame Frame){
        登陆Button.addActionListener(this);
        this.frame=Frame;
        Socket client= null;
        try {
            client = new Socket("localhost",9800);
            Send send=new Send(client);
            Receive receive=new Receive(client);


        } catch (IOException e1) {
            MyDialog myDialog=new MyDialog(this.frame,"无法连接！");
        }
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String type="0";

        if(e.getSource()==登陆Button){


            List<String> msgList1=new ArrayList<>();
            msgList1.add(textField1.getText());
            msgList1.add(textField2.getText());
            //TODO 检查密码错误还是正确
            Send.send(Send.msgProSend("11",msgList1));
            List<String> revList=Receive.msgProReceive(Receive.receive());
            if(revList.get(1).equals("1")){
                type=revList.get(2);
            }
            if(type.equals("1")){
                JFrame frame = new JFrame();
                frame.setContentPane(new SignUp(this.frame,frame,revList.get(3)).panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(500,350);
                frame.setVisible(true);
            }
            else if(type.equals("2")){
                JFrame frame = new JFrame();
                frame.setContentPane(new SetUp(this.frame,frame).panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(500,350);
                frame.setVisible(true);
            }
            else if(type.equals("3")){
                JFrame frame = new JFrame();
                frame.setContentPane(new Scoring(this.frame,frame,revList.get(3)).panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(500,350);
                frame.setVisible(true);
            }
            else if(type.equals("4")){
                JFrame frame = new JFrame();
                frame.setContentPane(new Scoring3(this.frame,frame,revList.get(3)).panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(500,350);
                frame.setVisible(true);
            }
        }
        if(!type.equals("0")){
            this.frame.dispose();
        } else{
            MyDialog myDialog=new MyDialog(this.frame,"用户名或密码不正确！");
        }
    }
}
