import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InputInformation2 implements ActionListener {
    public JPanel panel1;
    private JTextField textField1;
    private JTextField 此项不用填写TextField;
    private JComboBox comboBox1;
    private JCheckBox CheckBox1;
    private JCheckBox CheckBox2;
    private JCheckBox CheckBox3;
    private JCheckBox CheckBox4;
    private JCheckBox CheckBox5;
    private JCheckBox CheckBox6;
    private JCheckBox CheckBox7;
    private JCheckBox CheckBox8;
    private JCheckBox CheckBox9;
    private JCheckBox CheckBox10;
    private JCheckBox CheckBox11;
    private JCheckBox CheckBox12;
    private JButton 提交若有多人则需多次提交Button;
    private JButton 返回Button;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JComboBox comboBox0;
    private JFrame pFrame;
    private JFrame frame;
    public InputInformation2(JFrame pFrame,JFrame frame){
        this.pFrame=pFrame;
        this.frame=frame;
        this.pFrame.setVisible(false);
        提交若有多人则需多次提交Button.addActionListener(this);
        返回Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==提交若有多人则需多次提交Button) {
            String name = textField1.getText();
            String sex = comboBox0.getSelectedItem().toString();
            String ageRange = comboBox1.getSelectedItem().toString();
            List<String> project = new ArrayList<String>();
            project.add(name);
            project.add(ageRange);
            if (CheckBox1.isSelected()) {
                if (sex.equals("女")) {
                    MyDialog myDialog = new MyDialog(this.frame, "性别与项目不符！");
                } else {
                    project.add(CheckBox1.getText() + ageRange);
                }
            }
            if (CheckBox2.isSelected()) {
                if (sex.equals("女")) {
                    MyDialog myDialog = new MyDialog(this.frame, "性别与项目不符！");
                } else {
                    project.add(CheckBox2.getText() + ageRange);
                }
            }
            if (CheckBox3.isSelected()) {
                if (sex.equals("女")) {
                    MyDialog myDialog = new MyDialog(this.frame, "性别与项目不符！");
                } else {
                    project.add(CheckBox3.getText() + ageRange);
                }
            }
            if (CheckBox4.isSelected()) {
                if (sex.equals("女")) {
                    MyDialog myDialog = new MyDialog(this.frame, "性别与项目不符！");
                } else {
                    project.add(CheckBox4.getText() + ageRange);
                }
            }
            if (CheckBox5.isSelected()) {
                if (sex.equals("女")) {
                    MyDialog myDialog = new MyDialog(this.frame, "性别与项目不符！");
                } else {
                    project.add(CheckBox5.getText() + ageRange);
                }
            }
            if (CheckBox6.isSelected()) {
                if (sex.equals("女")) {
                    MyDialog myDialog = new MyDialog(this.frame, "性别与项目不符！");
                } else {
                    project.add(CheckBox6.getText() + ageRange);
                }
            }
            if (CheckBox7.isSelected()) {
                if (sex.equals("女")) {
                    MyDialog myDialog = new MyDialog(this.frame, "性别与项目不符！");
                } else {
                    project.add(CheckBox7.getText() + ageRange);
                }
            }
            if (CheckBox8.isSelected()) {
                if (sex.equals("男")) {
                    MyDialog myDialog = new MyDialog(this.frame, "性别与项目不符！");
                } else {
                    project.add(CheckBox8.getText() + ageRange);
                }
            }
            if (CheckBox9.isSelected()) {
                if (sex.equals("男")) {
                    MyDialog myDialog = new MyDialog(this.frame, "性别与项目不符！");
                } else {
                    project.add(CheckBox9.getText() + ageRange);
                }
            }
            if (CheckBox10.isSelected()) {
                if (sex.equals("男")) {
                    MyDialog myDialog = new MyDialog(this.frame, "性别与项目不符！");
                } else {
                    project.add(CheckBox10.getText() + ageRange);
                }
            }
            if (CheckBox11.isSelected()) {
                if (sex.equals("男")) {
                    MyDialog myDialog = new MyDialog(this.frame, "性别与项目不符！");
                } else {
                    project.add(CheckBox11.getText() + ageRange);
                }
            }
            if (CheckBox12.isSelected()) {
                if (sex.equals("男")) {
                    MyDialog myDialog = new MyDialog(this.frame, "性别与项目不符！");
                } else {
                    project.add(CheckBox12.getText() + ageRange);
                }
            }
            Send.send(Send.msgProSend("121",project));
            MyDialog myDialog=new MyDialog(this.frame,"本次提交成功！");
        }
        else if(e.getSource()==返回Button){
            this.pFrame.setVisible(true);
            this.frame.dispose();
        }

    }
}
