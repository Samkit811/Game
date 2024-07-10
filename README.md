# Magical Arena Game

## Overview

Magical Arena is a turn-based game where players battle each other until only one remains. Each player is defined by attributes such as health, strength, and attack. Players take turns to attack and defend, with the outcome determined by dice rolls. The game continues until only one player is left standing.

## Features

- Players have `health`, `strength`, and `attack` attributes.
- Players attack and defend in turns.
- Dice rolls determine the effectiveness of attacks and defenses.
- The game ends when a player's health reaches 0.

## Classes

### Player

Represents a player in the arena.

#### Attributes

- `name`: Name of the player.
- `health`: Health points of the player.
- `strength`: Strength points of the player.
- `attack`: Attack points of the player.

#### Methods

- `getHealth()`: Returns the player's health.
- `getAttack()`: Returns the player's attack.
- `getStrength()`: Returns the player's strength.
- `getName()`: Returns the player's name.
- `setHealth(int health)`: Sets the player's health.
- `setAttack(int attack)`: Sets the player's attack.
- `setName(String name)`: Sets the player's name.
- `setStrength(int strength)`: Sets the player's strength.
- `isAlive(int health)`: Returns true if the player's health is greater than 0.

### Dice

Represents the dice used in the game.

#### Attributes

- `numberOfDice`: Number of dice used.

#### Methods

- `rollDice()`: Rolls the dice and returns a random value between 1 and 6 times the number of dice.

### Arena

Represents the arena where the players battle.

#### Attributes

- `players`: List of players in the arena.
- `random`: Random number generator.
- `dice`: Dice used in the game.

#### Methods

- `addPlayer(Player player)`: Adds a player to the arena.
- `setDice(Dice dice)`: Sets the dice to be used in the game.
- `startGame()`: Starts the game and continues until only one player remains.
- `selectRandomPlayer(List<Player> players)`: Selects and removes a random player from the list.
- `decidePlayerRole(Player firstPlayer, Player secondPlayer)`: Decides the roles of attacker and defender based on health.
- `decideAttacker(Player firstPlayer, Player secondPlayer)`: Determines the attacker based on health.
- `decideDefender(Player firstPlayer, Player secondPlayer)`: Determines the defender based on health.
- `playGame(Player attackingPlayer, Player defendingPlayer)`: Simulates a round of attack and defense.
- `powerMultiplier(int power)`: Multiplies the power by a dice roll.
- `isAttackValid(int attackValue, int defenceValue)`: Checks if the attack value is greater than the defense value.

## Running the Game

To run the game, execute the `Main` class. This will start the game with predefined players and initiate the battle in the arena.

```java
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
