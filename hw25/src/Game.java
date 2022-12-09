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

    public String hardGameAction() {
        numberOfGames++;
        String str = "";
        HardMove userMove = hardMovePlayer();
        HardMove computerMove = hardMoveComputer();
        System.out.println("\nВаш ход " + userMove);
        System.out.println("Ход компьютера " + computerMove);

        if (userMove == computerMove) {
            System.out.println("Ничья");
        } else if (userMove == HardMove.ROCK && computerMove == HardMove.SCISSORS ||
                userMove == HardMove.ROCK && computerMove == HardMove.LIZARD ||
                userMove == HardMove.PAPER && computerMove == HardMove.ROCK ||
                userMove == HardMove.PAPER && computerMove == HardMove.CPOK ||
                userMove == HardMove.SCISSORS && computerMove == HardMove.PAPER ||
                userMove == HardMove.SCISSORS && computerMove == HardMove.LIZARD ||
                userMove == HardMove.LIZARD && computerMove == HardMove.CPOK ||
                userMove == HardMove.LIZARD && computerMove == HardMove.PAPER ||
                userMove == HardMove.CPOK && computerMove == HardMove.SCISSORS ||
                userMove == HardMove.CPOK && computerMove == HardMove.ROCK) {
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
        printDashes(61);
        System.out.println("+");

        System.out.printf("| %6s | %6s | %6s | %12s | %14s |\n",
                "ПОБЕДА", "ПОРАЖЕНИЕ", "НИЧЬЯ", "ВСЕГО ИГР", "ПРОЦЕНТ ПОБЕД");

        System.out.print("|");
        printDashes(8);
        System.out.print("+");
        printDashes(11);
        System.out.print("+");
        printDashes(8);
        System.out.print("+");
        printDashes(14);
        System.out.print("+");
        printDashes(16);
        System.out.println("|");

        System.out.printf("| %6d | %9d | %7d| %12d | %13.2f%% |\n",
                wins, losses, ties, numberOfGames, percentageWon * 100);

        System.out.print("+");
        printDashes(61);
        System.out.println("+");
    }


    public Game() {
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }

    public HardMove hardMoveComputer() {
        HardMove[] hardMoves = HardMove.values();
        Random random = new Random();
        int index = random.nextInt(hardMoves.length);
        return hardMoves[index];
    }

    public Move moveComputer() {
        Move[] moves = Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }

    public HardMove hardMovePlayer() {
        String hardPlayerMove;
        System.out.println("Введите: rock, paper, scissors, lizard, cpok, или первую букву r p s l c");
        hardPlayerMove = scanner.nextLine();
        hardPlayerMove = hardPlayerMove.toUpperCase();
        char first = hardPlayerMove.charAt(0);
        if (first == 'P' || first == 'S' || first == 'R' || first == 'L' || first == 'C') {
            switch (first) {
                case 'P':
                    return HardMove.PAPER;
                case 'S':
                    return HardMove.SCISSORS;
                case 'R':
                    return HardMove.ROCK;
                case 'L':
                    return HardMove.LIZARD;
                case 'C':
                    return HardMove.CPOK;
            }
        }
        System.out.println("Некоректный ввод");
        return hardMovePlayer();
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
