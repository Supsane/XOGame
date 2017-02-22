import javax.swing.*;

/**
 * Created by chashurin on 22.02.2017.
 */
public class WinWindow extends JDialog {
    public WinWindow () {
        setTitle("Конец игры!!!");
        setModal(true);
        setBounds(0, 0, 300, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        setVisible(true);
    }
}
