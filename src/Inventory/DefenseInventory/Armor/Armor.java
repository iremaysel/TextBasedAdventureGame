package Inventory.DefenseInventory.Armor;

import Inventory.DefenseInventory.DefenseInventory;

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
        //Seçilen Armor Listesini Döndürecek
        DefenseInventory[] choiceArmorArr = createArmor();
        DefenseInventory choiceArmor = choiceArmorArr[armorID];
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
}
