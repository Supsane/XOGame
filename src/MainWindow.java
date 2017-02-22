import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Евгений on 18.02.2017.
 */
public class MainWindow extends JFrame {
    MainGameClass mainGameWindow = new MainGameClass();

    public MainWindow() {
        setTitle("XOGame");
        setBounds(0, 0, 500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Создаем Меню
        JMenuBar mainMenu = new JMenuBar();

        //Подменю "Игра"
        JMenu play = new JMenu("Игра");
        JMenuItem newGame = new JMenuItem("Новая игра", KeyEvent.VK_F2);
        newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_DOWN_MASK));
        JMenuItem statistic = new JMenuItem("Статистика", KeyEvent.VK_F3);
        statistic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_DOWN_MASK));
        JMenuItem parametres = new JMenuItem("Параметры", KeyEvent.VK_F4);
        parametres.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_DOWN_MASK));
        JMenuItem exit = new JMenuItem("Выход", KeyEvent.VK_F5);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.CTRL_DOWN_MASK));
        play.add(newGame);
        play.add(statistic);
        play.add(parametres);
        play.addSeparator();
        play.add(exit);
        mainMenu.add(play);

        //Подменю "Справка"
        JMenu help = new JMenu("Справка");
        JMenuItem viewHelp = new JMenuItem("Посмотреть справку", KeyEvent.VK_F1);
        viewHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_DOWN_MASK));
        JMenuItem about = new JMenuItem("О программе");
        help.add(viewHelp);
        help.add(about);
        mainMenu.add(help);

        setJMenuBar(mainMenu);

        viewHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HelpWindow();
            }
        });

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InfoWindow();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        statistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatisticWindow();
            }
        });

        parametres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ParametresWindow();
            }
        });

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainGameWindow.newGame();
            }
        });

        add(mainGameWindow);
        setVisible(true);
    }
}
