package Character;

import Inventory.DefenseInventory.DefenseInventory;
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

    public Character(int id, int damage, int healty, int money, String characterName, Materials[] inventories){
        this.id = id;
        this.damage = damage;
        this.healty = healty;
        this.money = money;
        this.characterName = characterName;
        this.inventories = Materials.createMaterial();
        this.defenseInventory =DefenseInventory.createDefenseInventory();
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
        this.defenseInventory = DefenseInventory.createDefenseInventory();
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

        for (Character c : characters) {
            System.out.printf("  %-11s|  %-3s |  %-6d |  %-6d  |  %-5d  |\n",
                    c.getCharacterName(), c.getId(), c.getDamage(),
                    c.getHealty(), c.getMoney());
        }
    }
    public static Character selectCharacter() {
        Character[] player = createCharacter();
        Scanner scan = new Scanner(System.in);
        Character choiceCharacter = null;

        printCharacter();

        while (choiceCharacter == null) {
            System.out.print("\n  Character ID : ");
            String selectNumber = scan.next();

            switch (selectNumber){
                case "1":
                    System.out.println("\n  You Are " + createCharacter()[Integer.parseInt(selectNumber)-1].getCharacterName() +" anymore");
                    break;
                case "2":
                    System.out.println("\n  You Are " + createCharacter()[Integer.parseInt(selectNumber)-1].getCharacterName()+" anymore");
                    break;
                case "3":
                    System.out.println("\n  You Are " + createCharacter()[Integer.parseInt(selectNumber)-1].getCharacterName()+" anymore");
                    break;
                default:
                    System.out.println("\n  You made the wrong choice. Try again!");
                    continue;
            }
            int selectNum = Integer.parseInt(selectNumber);
            if(selectNum >= 1 && selectNum < player.length+1){
                choiceCharacter = player[selectNum - 1];
                return choiceCharacter;
            }
        }
        return choiceCharacter;
    }
}
