package Character;

import Inventory.DefenseInventory.DefenseInventory;
import Inventory.Inventory;
import Inventory.Materials.Materials;

import java.util.Scanner;

public class Character {
    private int id;
    private int damage;
    private int healty;
    private int money;
    private String characterName;
    private Materials[] inventories;

    private DefenseInventory[][] defenseInventory;

    public Character(int id, int damage, int healty, int money, String characterName, Materials[] inventories, DefenseInventory[][] defenseInventory){
        this.id = id;
        this.damage = damage;
        this.healty = healty;
        this.money = money;
        this.characterName = characterName;
        this.inventories = Materials.createMaterial();
        this.defenseInventory = DefenseInventory.createDefenseInventory();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealty() {
        return healty;
    }
    public void setHealty(int healty) {
        if (healty < 0 ){
            healty = 0;
        }
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharacterName() {
        return characterName;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Materials[] getInventories() {
        return inventories;
    }

    public void setInventories(Materials[] inventories) {
        this.inventories = inventories;
    }

    public DefenseInventory[][] getDefenseInventory() {
        return defenseInventory;
    }

    public void setDefenseInventory(DefenseInventory[][] defenseInventory) {
        this.defenseInventory = defenseInventory;
    }

    public static Character choiceCharacter(int characterID){
        Character[] characters = createCharacter();
        Character temp = null;
        for (Character c: characters) {
            if (c.getId() == characterID){
                temp = c;
                break;
            }
        }
        return temp;
    }
    public static Character[] createCharacter(){
        Character samurai = new Samurai();
        Character archer = new Archer();
        Character knight = new Knight();

        Character[] c = {samurai, archer, knight};

        return c;
    }

    public static void printCharacter() {
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
    public static Character selectCharacter() {
        Character[] player = createCharacter();
        Scanner scan = new Scanner(System.in);
        Character choiceCharacter = null;

        printCharacter();

        while (choiceCharacter == null) {
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
            if(selectNumber >= 1 && selectNumber < player.length+1){
                choiceCharacter = player[selectNumber - 1];
                return choiceCharacter;
            }
        }
        return choiceCharacter;
    }
}
