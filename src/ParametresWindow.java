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
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(3, 4, 5, 0));

        JPanel setSize = new JPanel(new GridLayout(2, 2, 5, 0));
        setSize.setBackground(Color.LIGHT_GRAY);
        setSize.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Выбрать размер поля", TitledBorder.LEFT, TitledBorder.TOP));
        JPanel setGame = new JPanel(new GridLayout(1, 2, 5, 0));
        setGame.setBackground(Color.LIGHT_GRAY);
        setGame.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Выбрать тип игры", TitledBorder.LEFT, TitledBorder.TOP));
        JPanel okCancel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        okCancel.setBackground(Color.LIGHT_GRAY);
        JPanel okCancel1 = new JPanel(new BorderLayout());
        okCancel1.setBackground(Color.LIGHT_GRAY);
        okCancel1.add(okCancel, BorderLayout.SOUTH);

        JRadioButton box3 = new JRadioButton("Поле 3х3 \n Фишек для победы - 3");
        box3.setBackground(Color.LIGHT_GRAY);
        box3.setEnabled(true);
        JRadioButton box5 = new JRadioButton("Поле 5х5 \n Фишек для победы - 5");
        box5.setBackground(Color.LIGHT_GRAY);
        JRadioButton box8 = new JRadioButton("Поле 8х8 \n Фишек для победы - 5");
        box8.setBackground(Color.LIGHT_GRAY);
        JRadioButton box10 = new JRadioButton("Поле 10х10 \n Фишек для победы - 7");
        box10.setBackground(Color.LIGHT_GRAY);

        ButtonGroup sizeField = new ButtonGroup();
        sizeField.add(box3);
        sizeField.add(box5);
        sizeField.add(box8);
        sizeField.add(box10);

        JRadioButton h_h = new JRadioButton("Человек vs Человек");
        h_h.setBackground(Color.LIGHT_GRAY);
        JRadioButton h_AI = new JRadioButton("Человек vs Компьютер");
        h_AI.setEnabled(true);
        h_AI.setBackground(Color.LIGHT_GRAY);

        ButtonGroup versPlay = new ButtonGroup();
        versPlay.add(h_AI);
        versPlay.add(h_h);

        JRadioButton easy = new JRadioButton("Легко");
        easy.setBackground(Color.LIGHT_GRAY);
        JRadioButton low = new JRadioButton("Средне");
        low.setBackground(Color.LIGHT_GRAY);
        JRadioButton high = new JRadioButton("Тяжело");
        high.setBackground(Color.LIGHT_GRAY);

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

        setSize.add(box3);
        setSize.add(box5);
        setSize.add(box8);
        setSize.add(box10);
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
