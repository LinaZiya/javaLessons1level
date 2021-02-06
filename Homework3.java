import java.util.Random;
import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        guessNumber();
        guessWord();
    }

    public static void guessNumber() {
        int max = 9;
        int min = 0;
        int number = doRandom(min, max);

        System.out.println("Hello! You should guess a number from " + min + " to " + max + ".\nYou have 3 attempts. " +
                "Write a number: ");

        int numberOfAttempts = 3;
        for (int i = 0; i < numberOfAttempts; i++) {
            int answer = Integer.parseInt(enterString());
            if (answer == number) {
                System.out.println("Congratulations, you guessed right!!!");
                break;
            }
            else {
                System.out.println("You didn't guess. You number is " + (answer > number ? "bigger" : "smaller") +
                        " than correct answer.");

                if (i != numberOfAttempts - 1) {
                    System.out.println("Write a number again:");
                }

                if (i == numberOfAttempts - 1) {
                    System.out.println("You've lost. Don't be upset! Correct answer is " + number);
                }
            }
        }
        System.out.println("Do you want to play one more time?(1 - yes; 0 - no)");
        int consent = Integer.parseInt(enterString());
        if (consent == 1) {
            guessNumber();
        }
    }


    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        int number = doRandom(0, words.length - 1);
        String word = words[number];
        System.out.println(word);

        System.out.println("Hello! You should guess a word and you have an unlimited number of attempts! Write a word: ");
        String answer = enterString();
        int k = 15;

        while (!word.equals(answer)) {
            System.out.println("Yiu didn't guess.\nThese are the letters that are in the right place:");
            int minLength = Math.min(word.length(), answer.length());
            for (int i = 0; i < minLength; i++) {
                if (word.charAt(i) == answer.charAt(i)) {
                    System.out.print(word.charAt(i));
                }
                else {
                    System.out.print("#");
                }
            }
            for (int i = 0; i < k - minLength; i++) {
                System.out.print("#");
            }
            System.out.println("\nWrite a word again:");
            answer = enterString();
        }

        System.out.println("Congratulations, you guessed right!!!");
    }


    public static String enterString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public static int doRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
