import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static String run() {
        try {
            String str = "";
            Game game = new Game();
            System.out.println("-------START GAME-------");
            System.out.println("Сыграть в сложную версию? введите цифру (1-ДА 2-НЕТ)");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (num == 2) {
                game.gameAction();
            } else if (num == 1) {
                game.hardGameAction();
            } else {
                System.out.println("Не та цифра");
                return run();
            }
            return str;
        } catch (InputMismatchException e) {
            System.out.println("Не корректный ввод");
            return run();
        }
    }
}