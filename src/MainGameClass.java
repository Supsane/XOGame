import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Евгений on 18.02.2017.
 */
public class MainGameClass extends JPanel implements Parametres {
    private int SIZE = 3;
    private int DOT_TO_WIN = 3;
    private final int SIZE_WINDOW = 500;
    private final int CELL_SIZE = 40;
    private int SIZE_FIELD = SIZE * CELL_SIZE;
    private int SIZE_INDENT = (SIZE_WINDOW - SIZE_FIELD) / 2;
    private String gameOver;
    private int[][] map;
    private int initPlayer;
    private Random rnd = new Random();
    private BufferedImage imgX;
    private BufferedImage imgO;
    private int opponent = 0;
    private int level = 0;

    public String getGameOver() {
        return gameOver;
    }

    public void setSIZE(int SIZE) {
        this.SIZE = SIZE;
    }

    public void setDOT_TO_WIN(int DOT_TO_WIN) {
        this.DOT_TO_WIN = DOT_TO_WIN;
    }

    public void setSIZE_FIELD(int SIZE) {
        this.SIZE_FIELD = SIZE * 40;
    }

    public void setSIZE_INDENT(int SIZE_FIELD) {
        this.SIZE_INDENT = (SIZE_WINDOW - SIZE_FIELD) / 2;
    }

    public int getSIZE_FIELD() {
        return SIZE_FIELD;
    }

    public void setOpponent(int opponent) {
        this.opponent = opponent;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void newGame() {
        initPlayer = 1;
        map = new int[SIZE][SIZE];
        repaint();
    }

    public MainGameClass() {
        setBackground(Color.LIGHT_GRAY);
        initPlayer = 1;
        map = new int[SIZE][SIZE];
        repaint();
        try {
            imgX = ImageIO.read(new File("src/paint/X.png"));
            imgO = ImageIO.read(new File("src/paint/O.png"));
        } catch (IOException ex) {
            System.exit(0);
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (e.getX() > SIZE_INDENT && e.getX() < (SIZE_WINDOW - SIZE_INDENT) && e.getY() > (SIZE_INDENT - 25) && e.getY() < (SIZE_WINDOW - SIZE_INDENT - 25)) {
                        int x = (e.getX() - SIZE_INDENT) / CELL_SIZE;
                        int y = (e.getY() - SIZE_INDENT + 25) / CELL_SIZE;
                        //Ход человека
                        if (initPlayer == 1 && map[x][y] == 0) {
                            map[x][y] = 1;
                            initPlayer = 2;
                            if (checkWin(1)) {
                                WinWindow winWindow = new WinWindow();
                                return;
                            } else {
                                if (checkFieldFull()) {
                                    gameOver = "Ничья!";
                                    WinWindow winWindow = new WinWindow();
                                }
                            }
                            repaint();
                            if (opponent == 1) return;
                        }
                        //Ход компьютера
                        if (opponent == 0) {
                            if (initPlayer == 2) {
                                if (level == 0) aiTurnEasy();
                                if (level == 1) aiTurnHigh();
                                initPlayer = 1;
                                if (checkWin(2)) {
                                    WinWindow winWindow = new WinWindow();
                                    return;
                                } else {
                                    if (checkFieldFull()) {
                                        gameOver = "Ничья!";
                                        WinWindow winWindow = new WinWindow();
                                    }
                                }
                                repaint();
                            }
                        } else { //Ход второго оппонента
                            if (map[x][y] == 0) {
                                map[x][y] = 2;
                                initPlayer = 1;
                                if (checkWin(2)) {
                                    WinWindow winWindow = new WinWindow();
                                    return;
                                } else {
                                    if (checkFieldFull()) {
                                        gameOver = "Ничья!";
                                        WinWindow winWindow = new WinWindow();
                                    }
                                }
                                repaint();
                            }
                        }
                    }
                }
            }
        });
    }

    public boolean checkFieldFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    public boolean checkLine(int cx, int cy, int vx, int vy, int l, int ox) {
        if (cx + l * vx > SIZE || cy + l * vy > SIZE || cy + l * vy < -1) return false;
        for (int i = 0; i < l; i++) {
            if (map[cx + i * vx][cy + i * vy] != ox) return false;
        }
        return true;
    }

    public boolean checkWin(int ox) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 1, 0, DOT_TO_WIN, ox) || checkLine(i, j, 0, 1, DOT_TO_WIN, ox) || checkLine(i, j, 1, 1, DOT_TO_WIN, ox) || checkLine(i, j, 1, -1, DOT_TO_WIN, ox)) {
                    if (ox == 1) {
                        gameOver = "Поздравляем, Вы победили!";
                        return true;
                    }
                    if (ox == 2) {
                        gameOver = "К сожалению, Вы проиграли!";
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public boolean isCellEmpty(int x, int y) {
        if (map[x][y] == 0) return true;
        return false;
    }

    public void aiTurnEasy() {
        int x, y;
        do {
            x = rnd.nextInt(SIZE);
            y = rnd.nextInt(SIZE);
        } while (!isCellEmpty(x, y));
        map[x][y] = 2;
        repaint();
    }

    public void aiTurnHigh() {
        int x = -1, y = -1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellEmpty(i, j)) {
                    map[i][j] = 2;
                    if (checkWin(1)) {
                        x = i;
                        y = j;
                    }
                    map[i][j] = 0;
                }
            }
        }
        if (x == -1 && y == -1) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellEmpty(i, j)) {
                        map[i][j] = 1;
                        if (checkWin(1)) {
                            x = i;
                            y = j;
                        }
                        map[i][j] = 0;
                    }
                }
            }
        }
        if (x == -1 && y == -1) {
            do {
                x = rnd.nextInt(SIZE);
                y = rnd.nextInt(SIZE);
            } while (!isCellEmpty(x, y));
        }
        map[x][y] = 2;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Отрисовка линий ячеек игрового поля
        g.setColor(Color.black);
        for (int i = 0; i < SIZE + 1; i++) {
            g.drawLine(SIZE_INDENT, SIZE_INDENT + (i * CELL_SIZE) - 25, SIZE_FIELD + SIZE_INDENT, SIZE_INDENT + (i * CELL_SIZE) - 25);
            g.drawLine(SIZE_INDENT + (i * CELL_SIZE), SIZE_INDENT - 25, SIZE_INDENT + (i * CELL_SIZE), SIZE_INDENT + SIZE_FIELD - 25);
        }
        //Заливка ячеек игрового поля
        g.setColor(Color.white);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                g.fillRect(SIZE_INDENT + 1 + (j * CELL_SIZE), SIZE_INDENT + (i * CELL_SIZE) - 24, CELL_SIZE - 1, CELL_SIZE - 1);
            }
        }
        //Вставка изображения крестика или нолика
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] > 0) {
                    int x = SIZE_INDENT + (i * CELL_SIZE) + 5;
                    int y = SIZE_INDENT + (j * CELL_SIZE) - 20;
                    if (map[i][j] == 1) {
                        g.drawImage(imgX, x, y, null);
                    }
                    if (map[i][j] == 2) {
                        g.drawImage(imgO, x, y, null);
                    }
                }
            }
        }
    }
}
