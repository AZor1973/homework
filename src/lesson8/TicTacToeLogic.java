package lesson8;


import java.util.Arrays;
import java.util.Random;

public class TicTacToeLogic {
    private static final int SIZE = 5;
    private static final int DOTS_TO_WIN = 4;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    protected static final char[][] map = new char[SIZE][SIZE];
    private static final Random rand = new Random();
    protected static int xOut;
    protected static int yOut;

    //    checkWin проверяет по строкам, столбцам, главным и второстепенным диагоналям
    protected static boolean checkWin(char c) {
        if (checkRowColumn(c)) return true;
        if (checkMinorDiagonal(c)) return true;
        return checkMainDiagonal(c);
    }

    private static boolean checkRowColumn(char c) {
        for (int i = 0; i < SIZE; i++) {
            int countRow = 0;
            int countColumn = 0;
            for (int j = 0; j < SIZE; j++) {
                countRow = (map[i][j] == c) ? countRow + 1 : 0;
                countColumn = (map[j][i] == c) ? countColumn + 1 : 0;
                if (countRow == DOTS_TO_WIN || countColumn == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkMainDiagonal(char c) {
        int countDiagonal = 0;
        int countRevDiagonal = 0;
        for (int i = 0; i < SIZE; i++) {
            countDiagonal = (map[i][i] == c) ? countDiagonal + 1 : 0;
            countRevDiagonal = (map[i][map.length - 1 - i] == c) ? countRevDiagonal + 1 : 0;
            if (countDiagonal == DOTS_TO_WIN || countRevDiagonal == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    // Вроде работает
    private static boolean checkMinorDiagonal(char c) {
        int[] countDiagonal = new int[(SIZE - DOTS_TO_WIN) * 4]; // кол-во второстепенных диагоналей зависит от SIZE и DOT_TO_WIN
        for (int k = 0, i = 1; k < countDiagonal.length; k += 4, i++) {
            for (int j = 0; j < SIZE - i; j++) {
                // Выявил зависимость, но упростить не получилось
                countDiagonal[k] = (map[j][(SIZE - 1) - i - j] == c) ? countDiagonal[k] + 1 : 0;
                countDiagonal[k + 1] = (map[j + i][(SIZE - 1) - j] == c) ? countDiagonal[k + 1] + 1 : 0;
                countDiagonal[k + 2] = (map[j + i][j] == c) ? countDiagonal[k + 2] + 1 : 0;
                countDiagonal[k + 3] = (map[j][j + i] == c) ? countDiagonal[k + 3] + 1 : 0;
                for (int value : countDiagonal) {
                    if (value == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    // Контролирует последний выигрышный ход и свой, и соперника
    protected static void aiTurn() {
        int x, y;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)) {
                        System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i +
                                1));
                        xOut = j;
                        yOut = i;
                        printMap();
                        TicTacToeFrame.command = TicTacToeFrame.PAUSE;
                        return;
                    } else {
                        map[i][j] = DOT_X;
                        if (checkWin(DOT_X)) {
                            System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i +
                                    1));
                            map[i][j] = DOT_O;
                            xOut = j;
                            yOut = i;
                            printMap();
                            TicTacToeFrame.command = TicTacToeFrame.PAUSE;
                            return;
                        } else {
                            map[i][j] = DOT_EMPTY;
                        }
                    }
                }
            }
        }
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (map[y][x] != DOT_EMPTY);
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y +
                1));
        map[y][x] = DOT_O;
        xOut = x;
        yOut = y;
        printMap();
        TicTacToeFrame.command = TicTacToeFrame.PAUSE;
    }


    protected static void humanTurn() {
        int x = TicTacToeFrame.x, y = TicTacToeFrame.y;
        if (map[y][x] == DOT_EMPTY) {
            System.out.println("Человек пошёл.");
            map[y][x] = DOT_X;
            printMap();
            TicTacToeFrame.command = TicTacToeFrame.AI_TURN;
        }
    }

    protected static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(map[i], DOT_EMPTY);
        }
    }

    protected static void printMap() {
        printHeader();
        printBody();
        System.out.println();
    }

    private static void printHeader() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printBody() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int getSize() {
        return SIZE;
    }

    public static char getDotX() {
        return DOT_X;
    }

    public static char getDotO() {
        return DOT_O;
    }

    public static char getDot_EMPTY() {
        return DOT_EMPTY;
    }

}

