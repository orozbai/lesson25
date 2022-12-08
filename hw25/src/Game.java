import java.util.Random;
import java.util.Scanner;

public class Game {
    private int userScore;
    private int computerScore;
    private int numberOfGames;
    Scanner scanner = new Scanner(System.in);

    public String gameAction() {
        numberOfGames++;
        String str = "";
        Move userMove = movePlayer();
        Move computerMove = moveComputer();
        System.out.println("\nВаш ход " + userMove);
        System.out.println("Ход компьютера " + computerMove);

        // узнать победителя
        if (userMove == computerMove) {
            System.out.println("Ничья");
        } else if (userMove == Move.ROCK && computerMove == Move.SCISSORS ||
                userMove == Move.PAPER && computerMove == Move.ROCK ||
                userMove == Move.SCISSORS && computerMove == Move.PAPER) {
            System.out.println("Ты победил");
            userScore++;
        } else {
            System.out.println("Компьютер победил");
            computerScore++;
        }
        boolean ans = playAgain();
        if (ans) {
            return gameAction();
        } else {
            printScoreBoard();
        }
        return str;
    }

    public void printScoreBoard() {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;
        double percentageWon = (wins + ((double) ties) / 2) / numberOfGames;

        System.out.print("+");
        printDashes(68);
        System.out.println("+");

        System.out.printf("| %6s | %6s | %6s | %12s | %14s |\n",
                "ПОБЕДА", "ПОРАЖЕНИЕ", "НИЧЬЯ", "ВСЕГО ИГР", "ПРОЦЕНТ ПОБЕД");

        System.out.print("|");
        printDashes(10);
        System.out.print("+");
        printDashes(10);
        System.out.print("+");
        printDashes(10);
        System.out.print("+");
        printDashes(16);
        System.out.print("+");
        printDashes(18);
        System.out.println("|");

        System.out.printf("| %6d | %6d | %6d| %12d | %13.2f%% |\n",
                wins, losses, ties, numberOfGames, percentageWon * 100);

        System.out.print("+");
        printDashes(68);
        System.out.println("+");
    }


    public Game() {
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }

    public Move moveComputer() {
        Move[] moves = Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }

    public Move movePlayer() {
        String playerMove;
        System.out.println("Введите: rock paper или scissors или первую букву r p или s");
        playerMove = scanner.nextLine();
        playerMove = playerMove.toUpperCase();
        char first = playerMove.charAt(0);
        if (first == 'P' || first == 'S' || first == 'R') {
            switch (first) {
                case 'P':
                    return Move.PAPER;
                case 'S':
                    return Move.SCISSORS;
                case 'R':
                    return Move.ROCK;
            }
        }
        System.out.println("Некоректный ввод");
        return movePlayer();
    }

    public void printDashes(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
    }

    public boolean playAgain() {
        System.out.println("Сыграть еще раз? (введите Y если да. иначе любую другую букву)");
        String userInput = scanner.nextLine();
        userInput = userInput.toUpperCase();
        return userInput.charAt(0) == 'Y';
    }
}
