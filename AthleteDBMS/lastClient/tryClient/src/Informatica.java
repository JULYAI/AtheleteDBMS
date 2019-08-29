import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Informatica implements ActionListener {
    public JPanel panel1;
    private JPanel panel5;
    private JLabel label1;
    private JTable table1;
    private JButton 返回Button;
    private JFrame pFrame;
    private JFrame frame;
    public Informatica(JFrame pFrame,JFrame frame){
        this.pFrame=pFrame;
        this.frame=frame;
        返回Button.addActionListener(this);
        this.pFrame.setVisible(false);
        //TODO 显示本队代表队资料
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==返回Button){
            this.frame.dispose();
            this.pFrame.setVisible(true);
        }
    }
}
