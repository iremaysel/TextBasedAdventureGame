package Inventory.DefenseInventory.Armor;

import Inventory.DefenseInventory.DefenseInventory;
import Character.Character;

import java.util.Scanner;

public class Armor extends DefenseInventory {
    public Armor(String name,boolean status, String defenseName, int id, int damage, int money) {
        super(name,  status, "Armor", id, damage, money);
    }

    public static DefenseInventory[] createArmor(){
        DefenseInventory heavy = new Heavy();
        DefenseInventory light = new Light();
        DefenseInventory middle = new Middle();

        DefenseInventory[] armorArr = {light, middle, heavy};

        return armorArr;
    }

    public static DefenseInventory choiceArmor(int armorID){
        DefenseInventory[] crateArmor = createArmor();
        DefenseInventory choiceArmor = null;
        for (DefenseInventory d : crateArmor) {
            if (d.getId() == armorID) choiceArmor = d;
        }
        return choiceArmor;
    }

    public static void printArmor(){
        DefenseInventory[] armor = createArmor();
        String titleArmor = "  ARMOR  |  ID  |  DAMAGE  |  MONEY  |";
        String title2Armor = "  ----------------------------------------------------";
        System.out.println("\n" + titleArmor + "\n" + title2Armor);
        for (DefenseInventory x : armor) {
            System.out.print("  " + x.getName() + " \t ");
            System.out.print(x.getId() + " \t  ");
            System.out.print("  " + x.getDamage() + " \t\t ");
            System.out.print("  " + x.getMoney() + " \t\t\n");
        }
        System.out.println(title2Armor);
    }

    public static DefenseInventory purchasedArmor(int armorID, DefenseInventory choiceInventory, Character character){
        Scanner scan = new Scanner(System.in);
        DefenseInventory armor = null;

        Armor.printArmor();

        while (choiceInventory == null){
            System.out.print("\n  What Armor do you want to choose? \n  Press 0 to exit | Armor ID  : ");
            armorID = scan.nextInt();
            if (armorID > 0 && armorID <= Armor.createArmor().length){
                armor = Armor.choiceArmor(armorID);
                if (armor.getMoney() <= character.getMoney()){
                    choiceInventory = armor;
                } else {
                    System.out.println("\n  You don't have enough money");
                }
            } else {
                System.out.println("\n  You made the wrong choice. Try again!");
            }
        }
        return choiceInventory;
    }
}
