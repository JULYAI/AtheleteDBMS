import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scoring implements ActionListener {
    public JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton 确认Button;
    private JButton 退出Button;
    private JComboBox comcoBox3;
    private JLabel label0;
    private JFrame pFrame;
    private JFrame frame;
    String judge;
    public Scoring(JFrame pFrame,JFrame frame,String judge){
        this.pFrame=pFrame;
        this.frame=frame;
        确认Button.addActionListener(this);
        退出Button.addActionListener(this);
        label0.setText(judge);
        this.judge=judge;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String group=comboBox1.getSelectedItem().toString()+comboBox2.getSelectedItem().toString()+comcoBox3.getSelectedItem().toString();
        if(e.getSource()==确认Button){
            JFrame frame = new JFrame();
            frame.setContentPane(new Scoring2(this.frame,frame,group,judge).panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(500,350);
            frame.setVisible(true);
        }
        else if(e.getSource()==退出Button){
            System.exit(0);
        }
    }
}
