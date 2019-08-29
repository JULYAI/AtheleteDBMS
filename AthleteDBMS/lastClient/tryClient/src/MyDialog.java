import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyDialog extends Dialog {
    public MyDialog(Frame owner, String text) {
        super(owner);
        Label label=new Label(text);
        add(label);
        setVisible(true);
        setSize(300,150);
        setModal(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();

            }
        });
    }
}
