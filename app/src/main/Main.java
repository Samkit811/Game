package main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        userInput();
    }

    private static void userInput(){
        Scanner scanner = new Scanner(System.in);

        Arena playingArena = new Arena();

        System.out.println("Enter the number of players:");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter name for player " + (i + 1) + ":");
            String name = scanner.nextLine();

            System.out.println("Enter health for player " + (i + 1) + ":");
            int health = scanner.nextInt();

            System.out.println("Enter strength for player " + (i + 1) + ":");
            int strength = scanner.nextInt();

            System.out.println("Enter attack for player " + (i + 1) + ":");
            int attack = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            Player player = new Player(name, health, strength, attack);
            playingArena.addPlayer(player);
        }

        System.out.println("Enter the number of dice:");
        int numberOfDice = scanner.nextInt();

        Dice dice = new Dice(numberOfDice);
        playingArena.setDice(dice);

        playingArena.startGame();

        scanner.close();
    }
}