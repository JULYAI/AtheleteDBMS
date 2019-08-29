import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Grouping implements ActionListener {
    public JPanel panel1;
    private JButton 返回Button;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label1;
    private JButton 确认Button;
    private JComboBox comboBox1;
    private JComboBox comboBox3;
    private JComboBox comboBox2;
    private JFrame pFrame;
    private JFrame frame;
    public Grouping(JFrame pFrame,JFrame frame){
        this.pFrame=pFrame;
        this.frame=frame;
        this.pFrame.setVisible(false);
        确认Button.addActionListener(this);
        返回Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String group=comboBox1.getSelectedItem().toString()+comboBox2.getSelectedItem().toString()+comboBox3.getSelectedItem().toString();
        if(e.getSource()==确认Button){
            //TODO 判断有没有这个组

            JFrame frame = new JFrame();
            frame.setContentPane(new Grouping2(this.frame,frame,group).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500,350);
            frame.setVisible(true);
        }
        else if(e.getSource()==返回Button){
            this.frame.dispose();
            this.pFrame.setVisible(true);
        }
    }
}
