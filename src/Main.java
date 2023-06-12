import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "orange", "grape", "watermelon"};
        Random random = new Random();
        String targetWord = words[random.nextInt(words.length)];

        String currentState = "_".repeat(targetWord.length());
        System.out.println("Current state: " + currentState);

        Scanner scanner = new Scanner(System.in);
        int remainingAttempts = 6;

        while (remainingAttempts > 0) {
            System.out.print("Guess a letter: ");
            String userGuess = scanner.next();

            if (targetWord.contains(userGuess)) {
                StringBuilder newState = new StringBuilder(currentState);
                for (int i = 0; i < targetWord.length(); i++) {
                    if (targetWord.charAt(i) == userGuess.charAt(0)) {
                        newState.setCharAt(i, userGuess.charAt(0));
                    }
                }
                currentState = newState.toString();
                System.out.println("Current state: " + currentState);
            } else {
                remainingAttempts--;
                System.out.println("Incorrect guess. Remaining attempts: " + remainingAttempts);
            }

            if (currentState.equals(targetWord)) {
                System.out.println("Congratulations! You won the game.");
                break;
            }

            if (remainingAttempts == 0) {
                System.out.println("You lost the game. The word was: " + targetWord);
                break;
            }
        }
    }
}
