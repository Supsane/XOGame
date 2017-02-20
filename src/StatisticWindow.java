import javax.swing.*;

/**
 * Created by Евгений on 18.02.2017.
 */
public class StatisticWindow extends JDialog {
    public StatisticWindow() {
        setTitle("Статистика");
        setModal(true);
        setBounds(0, 0, 300, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        setVisible(true);
    }
}
