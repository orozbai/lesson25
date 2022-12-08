import java.util.Random;
import java.util.Scanner;

public class Game {
    private int userScore;
    private int computerScore;
    private int numberOfGames;
    private int tie;
    Scanner scanner = new Scanner(System.in);

    public void gameAction() {
        Move userMove = movePlayer();
        Move computerMove = moveComputer();
        System.out.println("\nВаш ход " + userMove);
        System.out.println("Ход компьютера " + computerMove);

        // узнать победителя
        if (userMove == computerMove) {
            System.out.println("Ничья");
            tie++;
        } else if (userMove == Move.ROCK && computerMove == Move.SCISSORS ||
                userMove == Move.PAPER && computerMove == Move.ROCK ||
                userMove == Move.SCISSORS && computerMove == Move.PAPER) {
            System.out.println("Ты победил");
            userScore++;
        } else {
            System.out.println("Компьютер победил");
            computerScore++;
        }


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

    public boolean playAgain() {
        System.out.println("Сыграть еще раз? (введите y или n)");
        String userInput = scanner.nextLine();
        userInput = userInput.toUpperCase();
        return userInput.charAt(0) == 'Y';
    }
}
