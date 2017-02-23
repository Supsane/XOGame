import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Евгений on 18.02.2017.
 */
public class ParametresWindow extends JDialog  implements Parametres{

    public ParametresWindow() {
        setTitle("Параметры");
        setModal(true);
        setBounds(0, 0, 450, 350);
        setLocationRelativeTo(null);
        setResizable(false);

        /*=========================================*/

        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 5, 0));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 15));
        mainPanel.setBackground(Color.LIGHT_GRAY);

        /*=========================================*/

        JPanel createSize = new JPanel(new GridLayout(2, 2, 5, 0));
        createSize.setBackground(Color.LIGHT_GRAY);
        createSize.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Выбрать размер поля", TitledBorder.LEFT, TitledBorder.TOP));

        JRadioButton box3 = new JRadioButton("3х3. Фишек для победы - 3");
        box3.setBackground(Color.LIGHT_GRAY);
        JRadioButton box5 = new JRadioButton("5х5. Фишек для победы - 4", true);
        box5.setBackground(Color.LIGHT_GRAY);
        JRadioButton box8 = new JRadioButton("8х8. Фишек для победы - 5");
        box8.setBackground(Color.LIGHT_GRAY);
        JRadioButton box10 = new JRadioButton("10х10. Фишек для победы - 7");
        box10.setBackground(Color.LIGHT_GRAY);

        ButtonGroup sizeField = new ButtonGroup();
        sizeField.add(box3);
        sizeField.add(box5);
        sizeField.add(box8);
        sizeField.add(box10);

        createSize.add(box3);
        createSize.add(box5);
        createSize.add(box8);
        createSize.add(box10);

        /*=========================================*/

        JPanel createGame = new JPanel(new GridLayout(4, 2, 5, 0));
        createGame.setBackground(Color.LIGHT_GRAY);
        createGame.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Выбрать тип игры", TitledBorder.LEFT, TitledBorder.TOP));

        JRadioButton h_h = new JRadioButton("Человек vs Человек", true);
        h_h.setBackground(Color.LIGHT_GRAY);
        JRadioButton h_AI = new JRadioButton("Человек vs Компьютер");
        h_AI.setBackground(Color.LIGHT_GRAY);
        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel();
        JRadioButton easy = new JRadioButton("Легко", true);
        easy.setBackground(Color.LIGHT_GRAY);
        JRadioButton low = new JRadioButton("Средне");
        low.setBackground(Color.LIGHT_GRAY);
        JRadioButton high = new JRadioButton("Тяжело");
        high.setBackground(Color.LIGHT_GRAY);
        ButtonGroup versPlay = new ButtonGroup();
        versPlay.add(h_AI);
        versPlay.add(h_h);

        if (h_h.isSelected()) {
            easy.setEnabled(false);
            low.setEnabled(false);
            high.setEnabled(false);
        }

        ButtonGroup levelPlay = new ButtonGroup();
        levelPlay.add(easy);
        levelPlay.add(low);
        levelPlay.add(high);

        createGame.add(h_h);
        createGame.add(h_AI);
        createGame.add(l1);
        createGame.add(easy);
        createGame.add(l2);
        createGame.add(low);
        createGame.add(l3);
        createGame.add(high);

        /*=========================================*/

        JPanel okCancel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        okCancel.setBackground(Color.LIGHT_GRAY);
        JPanel okCancel1 = new JPanel(new BorderLayout());
        okCancel1.setBackground(Color.LIGHT_GRAY);
        okCancel1.add(okCancel, BorderLayout.SOUTH);

        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Отмена");

        okCancel.add(ok);
        okCancel.add(cancel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultCloseOperation(ParametresWindow.DISPOSE_ON_CLOSE);
                removeAll();
                dispose();
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box3.isSelected()) {
                    mainGameClass.setSIZE(3);
                    mainGameClass.setDOT_TO_WIN(3);
                    mainGameClass.setSIZE_FIELD(3);
                    mainGameClass.setSIZE_INDENT(mainGameClass.getSIZE_FIELD());
                    mainGameClass.newGame();
                }
                if (box5.isSelected()) {
                    mainGameClass.setSIZE(5);
                    mainGameClass.setDOT_TO_WIN(4);
                    mainGameClass.setSIZE_FIELD(5);
                    mainGameClass.setSIZE_INDENT(mainGameClass.getSIZE_FIELD());
                    mainGameClass.newGame();
                }
                if (box8.isSelected()) {
                    mainGameClass.setSIZE(8);
                    mainGameClass.setDOT_TO_WIN(5);
                    mainGameClass.setSIZE_FIELD(8);
                    mainGameClass.setSIZE_INDENT(mainGameClass.getSIZE_FIELD());
                    mainGameClass.newGame();
                }
                if (box10.isSelected()) {
                    mainGameClass.setSIZE(10);
                    mainGameClass.setDOT_TO_WIN(7);
                    mainGameClass.setSIZE_FIELD(10);
                    mainGameClass.setSIZE_INDENT(mainGameClass.getSIZE_FIELD());
                    mainGameClass.newGame();
                }
                setDefaultCloseOperation(ParametresWindow.DISPOSE_ON_CLOSE);
                removeAll();
                dispose();
            }
        });

        /*=========================================*/

        mainPanel.add(createSize);
        mainPanel.add(createGame);
        mainPanel.add(okCancel1);

        /*=========================================*/

        add(mainPanel);
        setVisible(true);
    }
}
