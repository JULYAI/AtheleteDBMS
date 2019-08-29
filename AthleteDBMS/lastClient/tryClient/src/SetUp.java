import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class SetUp implements ActionListener {
    public JPanel panel1;
    private JButton 设置代表队和裁判Button;
    private JButton 一键分组及编号Button;
    private JButton 返回Button;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JLabel label1;
    private JLabel label2;
    private JButton 查看比赛Button;
    private JButton 查看成绩Button;
    private JFrame pFrame;
    private JFrame frame;


    public SetUp(JFrame pFrame,JFrame frame){

        查看成绩Button.addActionListener(this);
        查看比赛Button.addActionListener(this);
        设置代表队和裁判Button.addActionListener(this);
        一键分组及编号Button.addActionListener(this);
        返回Button.addActionListener(this);
        this.pFrame=pFrame;
        this.frame=frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==查看比赛Button){
            JFrame frame = new JFrame();
            frame.setContentPane(new Grouping(this.frame,frame).panel1);
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
        else if(e.getSource()==设置代表队和裁判Button){
            JFrame frame = new JFrame();
            frame.setContentPane(new distribution(this.frame,frame).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500,350);
            frame.setVisible(true);
        }
        else if (e.getSource()==一键分组及编号Button){
            distribute();
        }
        else if(e.getSource()==返回Button){
            exit(0);
        }
    }

    public void distribute(){

    }
}
