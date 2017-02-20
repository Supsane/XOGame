import javax.swing.*;
import java.awt.*;

/**
 * Created by Евгений on 18.02.2017.
 */
public class MainGameClass extends JPanel {
    MainClass main = new MainClass();
    private int[][] map;

    public MainGameClass() {
        setBackground(Color.LIGHT_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black); //Отрисовка линий ячеек игрового поля
        for (int i = 0; i < main.getSIZE() + 1; i++) {
            g.drawLine(main.getSIZE_INDENT(), main.getSIZE_INDENT() + (i * main.getCELL_SIZE()) - 25, main.getSIZE_FIELD() + main.getSIZE_INDENT(), main.getSIZE_INDENT() + (i * main.getCELL_SIZE()) - 25);
            g.drawLine(main.getSIZE_INDENT() + (i * main.getCELL_SIZE()), main.getSIZE_INDENT() - 25, main.getSIZE_INDENT() + (i * main.getCELL_SIZE()), main.getSIZE_INDENT() + main.getSIZE_FIELD() - 25);
        }

        g.setColor(Color.white); //Заливка ячеек игрового поля
        for (int i = 0; i < main.getSIZE(); i++) {
            for (int j = 0; j < main.getSIZE(); j++) {
                g.fillRect(main.getSIZE_INDENT() + 1 + (j * main.getCELL_SIZE()), main.getSIZE_INDENT() + (i * main.getCELL_SIZE()) - 24, main.getCELL_SIZE() - 1, main.getCELL_SIZE() - 1);
            }
        }
    }
}
