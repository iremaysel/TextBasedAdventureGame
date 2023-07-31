package Game;

import Player.Player;

import java.util.Scanner;

public class Game {
    // Player
    // Location

    public void start(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\n  Hi. Can you tell me your name to get started?");
        System.out.print("  Character name : ");

        String name = scan.nextLine();
        name = name.equals("") ? "Player 1" : name;
        Player player = new Player(name);
        player.setName(name);

        System.out.print("\n  *********  Welcome "+ player.getName());
        System.out.print(", Please Select Character To Continue  *********\n");

        player.selectCharacter();
    }
}
