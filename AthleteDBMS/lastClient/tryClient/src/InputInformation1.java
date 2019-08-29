import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InputInformation1 implements ActionListener {
    public JPanel panel1;
    private JTextField textField1;
    private JTextField textField3;
    private JButton 提交若有多人则需多次提交Button;
    private JComboBox comboBox1;
    private JButton 返回Button;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel label1;
    private JLabel label2;
    private JLabel label4;
    private JLabel label5;
    private JFrame pFrame;
    private JFrame frame;
    public InputInformation1(JFrame pFrame,JFrame frame){
        this.pFrame=pFrame;
        this.frame=frame;
        this.pFrame.setVisible(false);
        提交若有多人则需多次提交Button.addActionListener(this);
        返回Button.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==提交若有多人则需多次提交Button){
            String name=textField1.getText();
            String tel=textField3.getText();
            //TODO 写进数据库
            List<String> msgList=new ArrayList<>();
            msgList.add(name);
            msgList.add(comboBox1.getSelectedItem().toString());
            msgList.add(tel);
            Send.send(Send.msgProSend("122",msgList));
            textField1.setText("");
            textField3.setText("");
            MyDialog myDialog=new MyDialog(this.frame,"本次提交成功！");
        }
        else if(e.getSource()==返回Button){
            this.pFrame.setVisible(true);
            this.frame.dispose();
        }
    }
}
