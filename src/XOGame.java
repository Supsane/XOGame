import java.util.Random;
import java.util.Scanner;

public class XOGame {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static char[][] map;

    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    // public static final char EMPTY_DOT = '\u2022';
    public static final char EMPTY_DOT = '_';
    public static final char X_DOT = 'X';
    public static final char O_DOT = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWinNew(X_DOT)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWinNew(O_DOT)) {
                System.out.println("Победил AI");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра окончена");
    }


    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x = -1, y = -1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellEmpty(i, j)) {
                    map[j][i] = O_DOT;
                    if (checkWinNew(O_DOT)) {
                        x = i;
                        y = j;
                    }
                    map[j][i] = EMPTY_DOT;
                }

            }
        }
        if (x == -1 && y == -1) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellEmpty(i, j)) {
                        map[j][i] = X_DOT;
                        if (checkWinNew(X_DOT)) {
                            x = i;
                            y = j;
                        }
                        map[j][i] = EMPTY_DOT;
                    }

                }
            }
        }
        if (x == -1 && y == -1) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellEmpty(x, y));
        }
        System.out.printf("AI сделал ход %d; %d\n", x + 1, y + 1);
        map[y][x] = O_DOT;
    }

    public static boolean checkWin(char dot) {
        if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) return true;
        if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) return true;
        if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) return true;

        if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) return true;
        if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) return true;
        if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot) return true;

        if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) return true;
        if (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot) return true;
        return false;
    }

    public static boolean checkWinNew(char dot) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] != dot) continue;
                if (checkLine(i, j, 1, 0, dot)) return true; // пытаемся построить горизонтальные линии
                if (checkLine(i, j, 0, 1, dot)) return true; // пытаемся построить веритикальные линии
                if (checkLine(i, j, 1, 1, dot))
                    return true; // пытаемся построить диагональные линии направленные вправо-вниз
                if (checkLine(i, j, 1, -1, dot))
                    return true; // пытаемся построить диагональные линии направленные вправо-вверх
            }
        }
        return false;
    }

    public static boolean checkLine(int cx, int cy, int vx, int vy, char dot) {
        // отсеиваем заранее невозможные проверки
        if (cx + DOTS_TO_WIN * vx > SIZE || cy + DOTS_TO_WIN * vy > SIZE || cy + DOTS_TO_WIN * vy < -1) return false;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) return false;
        }
        return true;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты (столбец)X (строка)Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            sc.nextLine();
        } while (!isCellEmpty(x, y));
        map[y][x] = X_DOT;
    }

    public static boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) return false;
        if (map[y][x] == EMPTY_DOT) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        System.out.print("   ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%2c ", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
