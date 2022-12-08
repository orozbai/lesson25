import java.util.Scanner;

public class Game {
    public static void rockPaperScissors() {
        Scanner scanner = new Scanner(System.in);
        String playerMove, computerMove;
        int randomInt;

        // ход игрока
        System.out.println("Введите: rock paper или scissors");
        playerMove = scanner.nextLine();

        // ход компьютера
        randomInt = (int) (Math.random() * 3);
        if (randomInt == 0) {
            computerMove = "rock";
        } else if (randomInt == 1) {
            computerMove = "paper";
        } else {
            computerMove = "scissors";
        }
        System.out.println(computerMove);

        // Кто победил?
        if (playerMove.equals(computerMove)) {
            System.out.println("Ничья?");
        } else if (playerMove.equals("rock") && computerMove.equals("scissors")) {
            System.out.println("Ты победил");
        } else if (playerMove.equals("rock") && computerMove.equals("paper")) {
            System.out.println("Компьютер победил");
        } else if (playerMove.equals("paper") && computerMove.equals("rock")) {
            System.out.println("Ты победил");
        } else if (playerMove.equals("paper") && computerMove.equals("scissors")) {
            System.out.println("Компьютер победил");
        } else if (playerMove.equals("scissors") && computerMove.equals("rock")) {
            System.out.println("Компьютер победил");
        } else if (playerMove.equals("scissors") && computerMove.equals("paper")) {
            System.out.println("Ты победил");
        }
    }
}
