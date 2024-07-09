import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private List<Player> players;
    private Random random;

    Arena(){
        players = new ArrayList<>();
        random = new Random();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

}
