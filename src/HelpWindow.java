import javax.swing.*;

/**
 * Created by Евгений on 18.02.2017.
 */
public class HelpWindow extends JDialog {
    public HelpWindow() {
        setTitle("Помощь");
        setModal(true);
        setBounds(0, 0, 300, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        setVisible(true);
    }
}
