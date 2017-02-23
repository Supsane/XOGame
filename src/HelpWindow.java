import javax.swing.*;
import java.awt.*;

/**
 * Created by Евгений on 18.02.2017.
 */
public class HelpWindow extends JDialog {
    public HelpWindow() {
        setTitle("Инфо");
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
        JPanel textWindow = new JPanel(new GridLayout(20, 1, 5, 0));
        textWindow.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 10));
        textWindow.setBackground(Color.LIGHT_GRAY);



        JLabel stringOne = new JLabel("w");
        JLabel stringTwo = new JLabel("практических целях на за-");
        JLabel stringFree = new JLabel("нятиях в обучающем");
        JLabel stringFour1 = new JLabel("портале");
        JLabel stringFour2 = new JLabel();
        JLabel stringFour3 = new JLabel();
        JLabel stringFour = new JLabel("GeekBrains");
        JLabel stringFive1 = new JLabel();
        JLabel stringFive2 = new JLabel();
        JLabel stringFive3 = new JLabel();
        JLabel stringFive = new JLabel("Разработчик - Чашурин Евгений");
        JLabel stringSix = new JLabel("Наставник - Фисунов Александр");
        stringOne.setFont(new Font("Verdana", Font.PLAIN, 12));
        stringOne.setHorizontalAlignment(JLabel.LEFT);
        stringTwo.setFont(new Font("Verdana", Font.PLAIN, 12));
        stringTwo.setHorizontalAlignment(JLabel.LEFT);
        stringFree.setFont(new Font("Verdana", Font.PLAIN, 12));
        stringFree.setHorizontalAlignment(JLabel.LEFT);
        stringFour1.setFont(new Font("Verdana", Font.PLAIN, 12));
        stringFour1.setHorizontalAlignment(JLabel.LEFT);
        stringFour.setFont(new Font("Verdana", Font.BOLD, 12));
        stringFour.setHorizontalAlignment(JLabel.CENTER);
        stringFive.setFont(new Font("Verdana", Font.PLAIN, 11));
        stringFive.setHorizontalAlignment(JLabel.LEFT);
        stringSix.setFont(new Font("Verdana", Font.PLAIN, 11));
        stringSix.setHorizontalAlignment(JLabel.LEFT);



        textWindow.add(stringOne);
        textWindow.add(stringTwo);
        textWindow.add(stringFree);
        textWindow.add(stringFour1);
        textWindow.add(stringFour2);
        textWindow.add(stringFour3);
        textWindow.add(stringFour);
        textWindow.add(stringFive1);
        textWindow.add(stringFive2);
        textWindow.add(stringFive3);
        textWindow.add(stringFive);
        textWindow.add(stringSix);



        textWindow2.add(textWindow);
        mainPanel.add(textWindow2);

        /*=========================================*/

        add(mainPanel);
        setVisible(true);
    }
}
