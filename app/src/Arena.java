import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private List<Player> players;
    private Random random;
    private Dice dice;

    Arena(){
        players = new ArrayList<>();
        random = new Random();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void setDice(Dice dice){
        this.dice = dice;
    }

    public void startGame(){
        while(players.size()>1){
            int index1 = random.nextInt(players.size());
            Player firstPlayer = players.get(index1);
            players.remove(index1);

            int index2 = random.nextInt(players.size());
            Player secondPlayer = players.get(index2);
            players.remove(index2);

            if(firstPlayer.getHealth() <= secondPlayer.getHealth()){
                playGame(firstPlayer,secondPlayer);
            }
            else{
                playGame(secondPlayer,firstPlayer);
            }
        }
        Player winnerPlayer = players.get(0);
        System.out.println("Winner is:"+ winnerPlayer.getName());
    }

    private void playGame(Player attackingPlayer, Player defendingPlayer){
        int attackMultiplier = dice.rollDice();
        int attackValue = attackingPlayer.getAttack() * attackMultiplier;

        int defenceMultiplier = dice.rollDice();
        int defenceValue = defendingPlayer.getStrength() * defenceMultiplier;

        if(attackValue - defenceValue >= defendingPlayer.getHealth()){
            System.out.println(defendingPlayer.getName()+" is lost");
            addPlayer(attackingPlayer);
        }
        else{
            int remainingHealth = defendingPlayer.getHealth() - (attackValue - defenceValue);
            defendingPlayer.setHealth(remainingHealth);
            playGame(defendingPlayer,attackingPlayer);
        }
    }
}
