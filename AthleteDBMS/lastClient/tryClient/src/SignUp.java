import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp implements ActionListener {
    public JPanel panel1;
    private JButton 录入运动员Button;
    private JButton 录入领队和队医Button;
    private JButton 上传附件Button;
    private JButton 查看代表队Button;
    private JButton 返回Button;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label2;
    private JButton 查看成绩Button;
    private JLabel label1;
    private JFrame pFrame;
    private JFrame frame;

    public SignUp(JFrame pFrame,JFrame frame,String str){
        录入领队和队医Button.addActionListener(this);
        录入运动员Button.addActionListener(this);
        查看代表队Button.addActionListener(this);
        返回Button.addActionListener(this);
        this.pFrame=pFrame;
        this.frame=frame;
        label1.setText(str);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==录入领队和队医Button){
            JFrame frame = new JFrame();
            frame.setContentPane(new InputInformation1(this.frame,frame).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500,350);
            frame.setVisible(true);
        }
        else if(e.getSource()==录入运动员Button){
            JFrame frame = new JFrame();
            frame.setContentPane(new InputInformation2(this.frame,frame).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500,350);
            frame.setVisible(true);
        }
        else if(e.getSource()==查看成绩Button){
            JFrame frame = new JFrame();
            frame.setContentPane(new Final(this.frame,frame).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500,350);
            frame.setVisible(true);
        }
        else if(e.getSource()==查看代表队Button){
            JFrame frame = new JFrame();
            frame.setContentPane(new Informatica(this.frame,frame).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500,350);
            frame.setVisible(true);
        }
        else if(e.getSource()==返回Button){
            System.exit(0);
        }
    }
}
