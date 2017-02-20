import javax.swing.*;

/**
 * Created by Евгений on 18.02.2017.
 */
public class InfoWindow extends JDialog {
    public InfoWindow() {
        setTitle("Инфо");
        setModal(true);
        setBounds(0, 0, 300, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        setVisible(true);
    }
}
