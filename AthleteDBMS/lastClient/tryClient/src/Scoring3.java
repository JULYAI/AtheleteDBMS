import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scoring3 implements ActionListener {
    public JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton 确认Button;
    private JButton 退出Button;
    private JComboBox comboBox4;
    private JFrame pFrame;
    private JFrame frame;
    private String mJudge;
    public Scoring3(JFrame pFrame, JFrame frame, String mJudge){
        this.pFrame=pFrame;
        this.frame=frame;
        this.mJudge=mJudge;
        确认Button.addActionListener(this);
        退出Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==确认Button){
            String group=comboBox1.getSelectedItem().toString()+comboBox2.getSelectedItem().toString()+comboBox3.getSelectedItem().toString();
            String seq=comboBox4.getSelectedItem().toString();
            JFrame frame = new JFrame();
            frame.setContentPane(new Scoring4(this.frame,frame,group,seq,mJudge).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500,350);
            frame.setVisible(true);
        }else if(e.getSource()==退出Button){
            System.exit(0);
        }
    }
}
