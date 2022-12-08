import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);


    public Game() {
    }

    public Move getMove() {
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
