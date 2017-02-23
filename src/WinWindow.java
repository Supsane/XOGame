import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by chashurin on 22.02.2017.
 */
public class WinWindow extends JDialog implements Parametres {

    public WinWindow() {
        setTitle("Конец игры");
        setModal(true);
        setBounds(0, 0, 310, 200);
        setLocationRelativeTo(null);
        setResizable(false);


        /*=========================================*/

        JPanel mainPanel = new JPanel(new GridLayout(2, 1, 5, 0));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 15));
        mainPanel.setBackground(Color.LIGHT_GRAY);

        /*=========================================*/

        JPanel textWindow = new JPanel(new BorderLayout());
        textWindow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JLabel gameOver = new JLabel(mainGameClass.getGameOver());
        gameOver.setHorizontalAlignment(JLabel.CENTER);
        gameOver.setFont(new Font("Arial", Font.PLAIN, 12));

        textWindow.add(gameOver);
        /*=========================================*/

        JPanel okCancel = new JPanel(new GridLayout(2, 2));
        okCancel.setBackground(Color.LIGHT_GRAY);

        JButton ok = new JButton("Новая игра");
        JButton settings = new JButton("Настроить поле");
        JButton exit = new JButton("Выйти из игры");
        JLabel set1 = new JLabel();

        okCancel.add(ok);
        okCancel.add(settings);
        okCancel.add(set1);
        okCancel.add(exit);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainGameClass.newGame();
                setDefaultCloseOperation(WinWindow.DISPOSE_ON_CLOSE);
                removeAll();
                dispose();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ParametresWindow();
                setDefaultCloseOperation(WinWindow.DISPOSE_ON_CLOSE);
                removeAll();
                dispose();
            }
        });

        /*=========================================*/

        mainPanel.add(textWindow);
        mainPanel.add(okCancel);

        /*=========================================*/

        add(mainPanel);
        setVisible(true);
    }
}