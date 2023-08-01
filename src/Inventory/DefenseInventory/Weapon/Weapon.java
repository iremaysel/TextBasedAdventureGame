package Inventory.DefenseInventory.Weapon;

import Inventory.DefenseInventory.DefenseInventory;

public class Weapon extends DefenseInventory {
    public Weapon(String name, boolean status, String defenseName, int id, int damage, int money) {
        super(name, status, "Weapon", id, damage, money);
    }

    public static DefenseInventory[] createWeapon(){
        DefenseInventory gun = new Gun();
        DefenseInventory sword = new Sword();
        DefenseInventory rifle = new Rifle();

        DefenseInventory[] armorArr = {gun, sword, rifle};

        return armorArr;
    }

    public static DefenseInventory choiceWeapon(int armorID){
        //Seçilen Armor Listesini Döndürecek
        DefenseInventory[] choiceArmorArr = createWeapon();
        DefenseInventory choiceArmor = choiceArmorArr[armorID];
        return choiceArmor;
    }

    public static void printWeapon(){
        DefenseInventory[] weapon = createWeapon();
        String titleWeapon = "  Weapon  |  ID  |  DAMAGE  |  MONEY  |";
        String title2Weapon = "  ----------------------------------------------------";
        System.out.println("\n" + titleWeapon + "\n" + title2Weapon);
        for (DefenseInventory x : weapon) {
            System.out.print("  " + x.getName() + " \t ");
            System.out.print(x.getId() + " \t  ");
            System.out.print("  " + x.getDamage() + " \t\t ");
            System.out.print("  " + x.getMoney() + " \t\t\n");
        }
        System.out.println(title2Weapon);
    }
}
