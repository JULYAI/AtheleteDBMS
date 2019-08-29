import com.sun.javaws.util.JfxHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class distribution implements ActionListener {
    public JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JPanel panel3;
    private JComboBox comboBox1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton 返回Button;
    private JPanel panel4;
    private JButton 提交若有多人则需多次提交Button;
    private JFrame pFrame;
    private JFrame frame;
    public distribution(JFrame pFrame,JFrame frame){
        this.pFrame=pFrame;
        this.frame=frame;
        返回Button.addActionListener(this);
        提交若有多人则需多次提交Button.addActionListener(this);
        this.pFrame.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==提交若有多人则需多次提交Button){
            String type="";
            String type1=comboBox1.getSelectedItem().toString();
            if(type1.equals("代表队")){
                type="1";
            }
            else if(type1.equals("裁判")){
                type="3";
            }
            else if(type1.equals("主裁判")){
                type="4";
            }
            String name=textField1.getText();
            String userID=textField2.getText();
            String passeord=textField3.getText();
            // 把管理员设置的账号和密码传回去
            List<String> msgList=new ArrayList<>();
            msgList.add(name);
            msgList.add(type);
            msgList.add(userID);
            msgList.add(passeord);
            Send.send(Send.msgProSend("131",msgList));
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            MyDialog myDialog=new MyDialog(this.frame,"本次提交成功！");
        }
        else if(e.getSource()==返回Button){
            this.frame.dispose();
            this.pFrame.setVisible(true);
        }
    }
}
