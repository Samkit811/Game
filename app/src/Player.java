public class Player {

    private String name;
    private int health;
    private int strength;
    private int attack;

    public Player(String name, int health, int strength, int attack){
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public int getHealth(){
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
