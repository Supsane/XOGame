import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Евгений on 18.02.2017.
 */
public class ParametresWindow extends JDialog {

    public ParametresWindow() {
        setTitle("Параметры");
        setModal(true);
        setBounds(0, 0, 450, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(3, 1, 5, 0));

        JPanel setSize = new JPanel(new GridLayout(2, 2, 5, 0));
        setSize.setBackground(Color.CYAN);
        setSize.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Выбрать размер поля", TitledBorder.LEFT, TitledBorder.TOP));
        JPanel setGame = new JPanel(new GridLayout(1, 2, 5, 0));
        setGame.setBackground(Color.RED);
        setGame.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Выбрать тип игры", TitledBorder.LEFT, TitledBorder.TOP));
        JPanel okCancel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        okCancel.setBackground(Color.ORANGE);
        JPanel okCancel1 = new JPanel(new BorderLayout());
        okCancel1.add(okCancel, BorderLayout.SOUTH);

        JRadioButton box3_3_3 = new JRadioButton("Поле 3х3 \n Фишек для победы - 3");
        JRadioButton box5_5_5 = new JRadioButton("Поле 5х5 \n Фишек для победы - 5");
        JRadioButton box8_8_5 = new JRadioButton("Поле 8х8 \n Фишек для победы - 5");
        JRadioButton box10_10_7 = new JRadioButton("Поле 10х10 \n Фишек для победы - 7");

        ButtonGroup sizeField = new ButtonGroup();
        sizeField.add(box3_3_3);
        sizeField.add(box5_5_5);
        sizeField.add(box8_8_5);
        sizeField.add(box10_10_7);

        JRadioButton h_h = new JRadioButton("Человек vs Человек");
        JRadioButton h_AI = new JRadioButton("Человек vs Компьютер");

        ButtonGroup versPlay = new ButtonGroup();
        versPlay.add(h_AI);
        versPlay.add(h_h);

        JRadioButton easy = new JRadioButton("Легко");
        JRadioButton low = new JRadioButton("Средне");
        JRadioButton high = new JRadioButton("Тяжело");

        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Отмена");

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDefaultCloseOperation(ParametresWindow.DISPOSE_ON_CLOSE);
                removeAll();
                dispose();
            }
        });

        setSize.add(box3_3_3);
        setSize.add(box5_5_5);
        setSize.add(box8_8_5);
        setSize.add(box10_10_7);
        setGame.add(h_h);
        setGame.add(h_AI);
        okCancel.add(ok);
        okCancel.add(cancel);

        add(setSize);
        add(setGame);
        add(okCancel1);
        setVisible(true);
    }
}
