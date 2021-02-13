
import java.util.Scanner;

/**
 * Class with Homework 4, number 3
 */

public class Homework4N3 {
    public static final int SIZE = 5;
    public static  final int ZERO = 0;
    public static final int numberOfPlayers = 4;

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        int[][] field = createField();

        drawField(field);

        int player;

        while (true) {
            for (player = 1; player <= numberOfPlayers; player++) {
                if (!checkNextPlayerMove(field, player)) {
                    return;
                }
            }
        }
    }

    public static boolean checkNextPlayerMove(int[][] field, int player) {
        doPlayerMove(field, player);
        drawField(field);
        return isNextMoveAvailable(field, player);
    }

    public static boolean isNextMoveAvailable(int[][] field, int player) {
        if (isDraw(field)) {
            System.out.println("There is draw detected. Finish!");
            return false;
        }
        if (isWin(field, player)) {
            System.out.printf("Congrats!!! Player %d is a winner!%n", player);
            return false;
        }
        return true;
    }

    public static boolean isWin(int[][] field, int player) {
        boolean win1;
        boolean win2;

        for (int i = 0; i < field.length; i++) {
            win1 = true;
            win2 = true;
            for (int j = 0; j < field.length; j++) {
                win1 = win1 && (field[i][j] == player);
                win2 = win2 && (field[j][i] == player);
            }
            if (win1 || win2) {
                return true;
            }
        }

        win1 = true;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (i + j == field.length - 1) {
                    win1 = win1 && (field[i][j] == player);
                }
            }
        }
        if (win1) {
            return win1;
        }

        win1 = true;
        for (int i = 0; i < field.length; i++) {
            win1 = win1 && (field[i][i] == player);
        }
        if (win1) {
            return win1;
        }

        return false;
    }

    public static boolean isDraw(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == ZERO) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void doPlayerMove(int[][] field, int player) {
        Scanner scanner = new Scanner(System.in);
        int x, y;

        do {
            x = checkCoordinateRange(scanner, 'X', player);
            y = checkCoordinateRange(scanner, 'Y', player);
        } while (isCellFree(field, x, y));

        field[x][y] = player;
    }

    public static int checkCoordinateRange(Scanner scanner, char coordName, int player) {
        int val;
        do {
            System.out.printf("Player %d, please input %s-coordinate in range [1-%d]...%n", player, coordName, SIZE);
            val = scanner.nextInt() - 1;
        } while (val < 0 || val >= SIZE);
        return val;
    }

    public static boolean isCellFree(int[][] field, int x, int y) {
        return field[x][y] != ZERO;
    }

    public static int[][] createField() {
        int[][] field = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = ZERO;
            }
        }
        return field;
    }

    public static void drawField(int[][] field) {
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
