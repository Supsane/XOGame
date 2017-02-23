import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by chashurin on 22.02.2017.
 */
public class WinWindow extends JDialog {
    MainGameClass mainGameWindow = new MainGameClass();
    public WinWindow() {
        setTitle("Конец игры!!!");
        setModal(true);
        setBounds(0, 0, 300, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel winWindow = new JPanel(new GridLayout(1, 2, 5, 0));
        winWindow.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 15));
        winWindow.setBackground(Color.LIGHT_GRAY);

        JLabel win = new JLabel(mainGameWindow.getGameOver());
        JButton ok = new JButton("Начать новую игру");
        JButton cancel = new JButton("Отмена");

        winWindow.add(win);
        winWindow.add(ok);
        winWindow.add(cancel);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainGameWindow.newGame();
            }
        });

        add(winWindow);
        setVisible(true);
    }
}
