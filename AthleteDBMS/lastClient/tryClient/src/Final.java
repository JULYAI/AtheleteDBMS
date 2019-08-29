import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Final implements ActionListener {
    public JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JPanel panel3;
    private JButton 返回Button;
    private JButton 刷新Button;
    private JTable table1;
    private JFrame pFrame;
    private JFrame frame;
    public Final(JFrame pFrame,JFrame frame){
        this.pFrame=pFrame;
        this.frame=frame;
        this.pFrame.setVisible(false);
        返回Button.addActionListener(this);
        刷新Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==刷新Button){
            //TODO 刷新最终成绩
        }
        else if(e.getSource()==返回Button){
            this.frame.dispose();
            this.pFrame.setVisible(true);
        }
    }
}
