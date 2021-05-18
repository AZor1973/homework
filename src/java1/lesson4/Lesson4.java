package java1.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    private static final int SIZE = 5;
    private static final int DOTS_TO_WIN = 4;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char[][] map = new char[SIZE][SIZE];
    private static final Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    //    checkWin проверяет по строкам, столбцам, главным и второстепенным диагоналям
    private static boolean checkWin(char c) {
        if (checkRowColumn(c)) return true;
        if (checkMinorDiag(c)) return true;
        return checkMainDiag(c);
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

    private static boolean checkMainDiag(char c) {
        int countDiag = 0;
        int countRevDiag = 0;
        for (int i = 0; i < SIZE; i++) {
            countDiag = (map[i][i] == c) ? countDiag + 1 : 0;
            countRevDiag = (map[i][map.length - 1 - i] == c) ? countRevDiag + 1 : 0;
            if (countDiag == DOTS_TO_WIN || countRevDiag == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    // Вроде работает
    private static boolean checkMinorDiag(char c) {
        int[] countDiag = new int[(SIZE - DOTS_TO_WIN) * 4]; // кол-во второстепенных диагоналей зависит от SIZE и DOT_TO_WIN
        for (int k = 0, i = 1; k < countDiag.length; k += 4, i++) {
            for (int j = 0; j < SIZE - i; j++) {
                // Выявил зависимость, но упростить не получилось
                countDiag[k] = (map[j][(SIZE - 1) - i - j] == c) ? countDiag[k] + 1 : 0;
                countDiag[k + 1] = (map[j + i][(SIZE - 1) - j] == c) ? countDiag[k + 1] + 1 : 0;
                countDiag[k + 2] = (map[j + i][j] == c) ? countDiag[k + 2] + 1 : 0;
                countDiag[k + 3] = (map[j][j + i] == c) ? countDiag[k + 3] + 1 : 0;
                for (int value : countDiag) {
                    if (value == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    // Контролирует последний выигрышный ход и свой, и соперника
    private static void aiTurn() {
        int x, y;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)) {
                        System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i +
                                1));
                        return;
                    } else {
                        map[i][j] = DOT_X;
                        if (checkWin(DOT_X)) {
                            System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i +
                                    1));
                            map[i][j] = DOT_O;
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
    }

    private static void humanTurn() {
        int x, y;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Введите координаты в формате X Y");
            x = readInt(sc) - 1;
            y = readInt(sc) - 1;
            if (x == -1 || y == -1) {
                System.out.println("Координаты должны быть числом и не 0!");
                sc.nextLine();
            } else if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                System.out.println("Координаты вне поля!");
            } else if (map[y][x] != DOT_EMPTY) {
                System.out.println("Клетка занята!");
            } else {
                break;
            }
        } while (true);
        map[y][x] = DOT_X;
    }

    private static int readInt(Scanner sc) {
        return sc.hasNextInt() ? sc.nextInt() : 0;
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(map[i], DOT_EMPTY);
        }
    }

    private static void printMap() {
        printHeader();
        printBody();
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

    private static void printHeader() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
