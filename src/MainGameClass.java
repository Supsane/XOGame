import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by Евгений on 18.02.2017.
 */
public class MainGameClass extends JPanel {
    MainClass main = new MainClass();
    private int[][] map;
    private int initPlayer;
    private String gameOver;
    private Random rnd = new Random();

    public void startGame() {
        map = new int[main.getSIZE()][main.getSIZE()];
        repaint();
    }

    public MainGameClass() {
        setBackground(Color.LIGHT_GRAY);
        initPlayer = 1;
        map = new int[main.getSIZE()][main.getSIZE()];
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    int x = e.getX() / main.getCELL_SIZE();
                    int y = e.getY() / main.getCELL_SIZE();
                    if (initPlayer == 1 && map[x][y] == 0) {
                        map [x][y] = 1;
                        initPlayer = 2;
                        checkFieldFull();
                        checkWin(1);
                        /*===================
                        * тут нужно вставить картинку икса!!!!
                        * ================*/
                    }

                }
            }
        });
    }

    public void checkFieldFull() {
        for (int i = 0; i < main.getSIZE(); i++) {
            for (int j = 0; j < main.getSIZE(); j++) {
                if (map[i][j] == 0) return;
            }
        }
        gameOver = "Ничья!!!";
    /*==============
    * Здесь нужен вызов завершения игры
    * ==============*/
    }

    public boolean checkLine(int cx, int cy, int vx, int vy, int l, int ox) {
        if (cx + l * vx > main.getSIZE() || cy + l * vy > main.getSIZE() || cy + l * vy < -1) return false;
        for (int i = 0; i < l; i++) {
            if (map[cx + i * vx][cy + i * vy] != ox) return false;
        }
        return true;
    }

    public void checkWin(int ox) {
        for (int i = 0; i < main.getSIZE(); i++) {
            for (int j = 0; j < main.getSIZE(); j++) {
                if (checkLine(i, j, 1, 0, main.getDOT_TO_WIN(), ox) || checkLine(i, j, 0, 1, main.getDOT_TO_WIN(), ox) || checkLine(i, j, 1, 1, main.getDOT_TO_WIN(), ox) || checkLine(i, j, 1, -1, main.getDOT_TO_WIN(), ox)) {
                    if (ox == 1) gameOver = "Player 1 WON";
                    if (ox == 2) gameOver = "Player 2 WON";
                    return;
                }
            }
        }
    }

    public boolean isCellEmpty(int x, int y) {
        if (map[x][y] == 0) return true;
        return false;
    }

    public void aiTurnEasy() {
        int x, y;
        do {
            x = rnd.nextInt(main.getSIZE());
            y = rnd.nextInt(main.getSIZE());
        } while (!isCellEmpty(x, y));
        map[x][y] = 2;
        repaint();
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
