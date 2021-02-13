import java.util.Random;
import java.util.Scanner;

/**
 * Class with Homework 4, number 1-2
 */

public class Homework4N2 {
    public static int SIZE = 3;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static  final char DASH = '-';

    public static void main(String[] args) {
        playGame();
    }

    static void playGame() {
        char[][] field = createField();

        drawField(field);

        while (true) {
            if (!checkNextPlayerMove(field)) {
                return;
            }

            if (!checkNextAIMove(field)) {
                return;
            }
        }
    }

    static boolean checkNextAIMove(char[][] field) {
        doAIMove(field);
        drawField(field);
        return isNextMoveAvailable(field, DOT_O, "Sorry, AI is winner!");
    }

    static boolean checkNextPlayerMove(char[][] field) {
        doPlayerMove(field);
        drawField(field);
        return isNextMoveAvailable(field, DOT_X, "Congrats!!! You are winner!");
    }

    static boolean isNextMoveAvailable(char[][] field, char sign, String winMessage) {
        if (isDraw(field)) {
            System.out.println("There is draw detected. Finish!");
            return false;
        }
        if (isWin(field, sign)) {
            System.out.println(winMessage);
            return false;
        }
        return true;
    }

    static boolean isWin(char[][] field, char sign) {
        boolean win1;
        boolean win2;

        for (int i = 0; i < field.length; i++) {
            win1 = true;
            win2 = true;
            for (int j = 0; j < field.length; j++) {
                win1 = win1 && (field[i][j] == sign);
                win2 = win2 && (field[j][i] == sign);
            }
            if (win1 || win2) {
                return true;
            }
        }

        win1 = true;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (i + j == field.length - 1) {
                    win1 = win1 && (field[i][j] == sign);
                }
            }
        }
        if (win1) {
            return win1;
        }

        win1 = true;
        for (int i = 0; i < field.length; i++) {
            win1 = win1 && (field[i][i] == sign);
        }
        if (win1) {
            return win1;
        }

        return false;
    }

    static boolean isDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == DASH) {
                    return false;
                }
            }
        }
        return true;
    }

    static void doAIMove(char[][] field) {
        Random random = new Random();
        int x, y;

        do {
            x = random.nextInt(field.length);
            y = random.nextInt(field.length);
        } while (isCellFree(field, x, y));
        field[x][y] = DOT_O;
    }

    static void doPlayerMove(char[][] field) {
        Scanner scanner = new Scanner(System.in);
        int x, y;

        do {
            x = checkCoordinateRange(scanner, 'X');
            y = checkCoordinateRange(scanner, 'Y');
        } while (isCellFree(field, x, y));

        field[x][y] = DOT_X;
    }

    static int checkCoordinateRange(Scanner scanner, char coordName) {
        int val;
        do {
            System.out.printf("Please input %s-coordinate in range [1-%d]...%n", coordName, SIZE);
            val = scanner.nextInt() - 1;
        } while (val < 0 || val >= SIZE);
        return val;
    }

    static boolean isCellFree(char[][] field, int x, int y) {
        return field[x][y] != DASH;
    }

    static char[][] createField() {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = DASH;
            }
        }
        return field;
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
