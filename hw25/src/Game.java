import java.util.Random;
import java.util.Scanner;

public class Game {

    public Game() {
    }

    public Move getMove() {
        Move[] moves = Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }

    public Move movePlayer() {
        Scanner scanner = new Scanner(System.in);
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
        return movePlayer();
    }
}
