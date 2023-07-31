package Player;

import Character.Character;
import Character.Samurai;
import Character.Archer;
import Character.Knight;

import Inventory.Inventory;

import java.util.Scanner;

public class Player {
    private String name;
    //private Inventory inventory;

    public Player(String name/*, Inventory inventory*/){
        this.name = name;
        //this.inventory = inventory;
    }

    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

    public Character[] createCharacter(){
        Character samurai = new Samurai();
        Character archer = new Archer();
        Character knight = new Knight();

        Character[] c = {samurai, archer, knight};

        return c;
    }

    public void printCharacter() {
        Character[] characters = createCharacter();
        String title = "  Character  |  ID  |  Damage  |  Healty  |  Money  |";
        String title2 = "  ----------------------------------------------------";
        System.out.println("\n" + title + "\n" + title2);
        for (Character c :characters ) {
            System.out.print("  " + c.getCharacterName() + " \t  ");
            System.out.print("  " + c.getId() + " \t  ");
            System.out.print("  " + c.getDamage() + " \t\t ");
            System.out.print("  " + c.getHealty() + " \t\t");
            System.out.print("  " + c.getMoney() + "  \n");
        }
    }
    public void selectCharacter() {
        Scanner scan = new Scanner(System.in);

        printCharacter();

        while (true) {
            System.out.print("\n  Character ID : ");
            int selectNumber = scan.nextInt();
            switch (selectNumber){
                case 1:
                    System.out.println("\n  You Are " + createCharacter()[0].getCharacterName() +" anymore");
                    break;
                case 2:
                    System.out.println("\n  You Are " + createCharacter()[1].getCharacterName()+" anymore");
                    break;
                case 3:
                    System.out.println("\n  You Are " + createCharacter()[2].getCharacterName()+" anymore");
                    break;
                default:
                    System.out.println("\n  You made the wrong choice. Try again!");
            }

            if(selectNumber == 1 || selectNumber == 2 || selectNumber == 3){
                break;
            }
        }
    }
}
