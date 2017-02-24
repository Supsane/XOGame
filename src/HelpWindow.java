import javax.swing.*;
import java.awt.*;

/**
 * Created by Евгений on 18.02.2017.
 */
public class HelpWindow extends JDialog {
    public HelpWindow() {
        setTitle("Справка");
        setModal(true);
        setBounds(0, 0, 250, 400);
        setLocationRelativeTo(null);
        setResizable(false);


        /*=========================================*/

        JPanel mainPanel = new JPanel(new GridLayout(1, 1, 5, 0));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 15));
        mainPanel.setBackground(Color.LIGHT_GRAY);

        /*=========================================*/

        JPanel textWindow2 = new JPanel(new GridLayout(1,1));
        textWindow2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        JPanel textWindow = new JPanel(new GridLayout(23, 1, 5, 0));
        textWindow.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10));
        textWindow.setBackground(Color.LIGHT_GRAY);



        JLabel stringOne = new JLabel("Перед Вами классическая игра");
        JLabel stringOne1 = new JLabel("\"Крестики-Нолики\".");
        JLabel stringOne2 = new JLabel();
        JLabel stringTwo = new JLabel("Меню \"Игра\" содержит в себе");
        JLabel stringTwo2 = new JLabel("кнопку запуска новой игры");
        JLabel stringTwo3 = new JLabel("игры (Ctrl+F2), кнопку вызова");
        JLabel stringTwo4 = new JLabel("окна Параметры (Ctrl+F3),");
        JLabel stringTwo5 = new JLabel("а также кнопку Выхода");
        JLabel stringTwo6 = new JLabel("из игры (Ctrl+F4)");

        stringOne.setHorizontalAlignment(JLabel.LEFT);
        stringOne.setFont(new Font("Verdana", Font.PLAIN, 11));
        stringOne1.setHorizontalAlignment(JLabel.LEFT);
        stringOne1.setFont(new Font("Verdana", Font.PLAIN, 11));
        stringOne2.setHorizontalAlignment(JLabel.LEFT);
        stringOne2.setFont(new Font("Verdana", Font.PLAIN, 11));
        stringTwo.setHorizontalAlignment(JLabel.LEFT);
        stringTwo.setFont(new Font("Verdana", Font.PLAIN, 11));
        stringTwo2.setHorizontalAlignment(JLabel.LEFT);
        stringTwo2.setFont(new Font("Verdana", Font.PLAIN, 11));
        stringTwo3.setHorizontalAlignment(JLabel.LEFT);
        stringTwo3.setFont(new Font("Verdana", Font.PLAIN, 11));
        stringTwo4.setHorizontalAlignment(JLabel.LEFT);
        stringTwo4.setFont(new Font("Verdana", Font.PLAIN, 11));
        stringTwo5.setHorizontalAlignment(JLabel.LEFT);
        stringTwo5.setFont(new Font("Verdana", Font.PLAIN, 11));
        stringTwo6.setHorizontalAlignment(JLabel.LEFT);
        stringTwo6.setFont(new Font("Verdana", Font.PLAIN, 11));


        textWindow.add(stringOne);
        textWindow.add(stringOne1);
        textWindow.add(stringOne2);
        textWindow.add(stringTwo);
        textWindow.add(stringTwo2);
        textWindow.add(stringTwo3);
        textWindow.add(stringTwo4);
        textWindow.add(stringTwo5);
        textWindow.add(stringTwo6);



        textWindow2.add(textWindow);
        mainPanel.add(textWindow2);

        /*=========================================*/

        add(mainPanel);
        setVisible(true);
    }
}
