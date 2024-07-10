package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private List<Player> players;
    private Random random;
    private Dice dice;

    public Arena(){
        players = new ArrayList<>();
        random = new Random();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void setDice(Dice dice){
        this.dice = dice;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void startGame(){
        while(players.size()>1){
            Player firstPlayer = selectRandomPlayer(players);
            Player secondPlayer = selectRandomPlayer(players);
            System.out.println(firstPlayer.getName()+" and "+secondPlayer.getName()+" are playing the next round");
            decidePlayerRole(firstPlayer,secondPlayer);
        }
        Player winnerPlayer = players.get(0);
        System.out.println("Winner of the game is:"+ winnerPlayer.getName());
    }

    private Player selectRandomPlayer(List<Player> players) {
        int index = random.nextInt(players.size());
        Player player = players.get(index);
        players.remove(index);
        return player;
    }

    private void decidePlayerRole(Player firstPlayer, Player secondPlayer){
        Player attackingPlayer = decideAttacker(firstPlayer,secondPlayer);
        Player defendingPlayer = decideDefender(firstPlayer,secondPlayer);
        playGame(attackingPlayer,defendingPlayer);
    }

    private Player decideAttacker(Player firstPlayer, Player secondPlayer){
        return firstPlayer.getHealth() > secondPlayer.getHealth() ? firstPlayer : secondPlayer;
    }

    private Player decideDefender(Player firstPlayer, Player secondPlayer){
        return firstPlayer.getHealth() <= secondPlayer.getHealth() ? firstPlayer : secondPlayer;
    }

    private void playGame(Player attackingPlayer, Player defendingPlayer){

        int attackValue = powerMultiplier(attackingPlayer.getAttack()) ;
        int defenceValue = powerMultiplier(defendingPlayer.getStrength());

        if(!isAttackValid(attackValue,defenceValue)){
          playGame(defendingPlayer,attackingPlayer);
          return;
        }

        int damage = attackValue - defenceValue;
        if(!defendingPlayer.isAlive(defendingPlayer.getHealth() - damage)){
            System.out.println(defendingPlayer.getName()+" has been eliminated");
            addPlayer(attackingPlayer);
            return;
        }

        defendingPlayer.setHealth(defendingPlayer.getHealth()-damage);
        playGame(defendingPlayer,attackingPlayer);
    }

    private int powerMultiplier(int power){
        int multiplierValue = dice.rollDice();
        return power*multiplierValue;
    }

    private boolean isAttackValid(int attackValue,int defenceValue){
        return attackValue > defenceValue;
    }
}
