public class Main {
    public static void main(String[] args) {
        Arena playingArena = new Arena();

        Player player1 = new Player("Alice",100,5,5);
        playingArena.addPlayer(player1);

        Player player2 = new Player("Bob",100,10,10);
        playingArena.addPlayer(player2);

        Player player3 = new Player("Messi",1,10,10);
        playingArena.addPlayer(player3);

        Dice dice = new Dice(1);
        playingArena.setDice(dice);

        playingArena.startGame();
    }
}