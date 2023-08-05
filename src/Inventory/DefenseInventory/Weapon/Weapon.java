package Inventory.DefenseInventory.Weapon;

import Inventory.DefenseInventory.DefenseInventory;
import Character.Character;
import java.util.Scanner;

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

    public static DefenseInventory choiceWeapon(int weaponID){
        DefenseInventory[] createWeapon = createWeapon();
        DefenseInventory choiceWeapon = null;
        for (DefenseInventory d : createWeapon){
            if(d.getId() == weaponID) choiceWeapon = d;
        }
        return choiceWeapon;
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

    public static DefenseInventory purchasedWeapon(int weaponID, DefenseInventory choiceInventory, Character character){
        Scanner scan = new Scanner(System.in);
        DefenseInventory weapon = null;

        Weapon.printWeapon();

        while (choiceInventory == null){
            System.out.print("\n  What Weapon do you want to choose?\n  Press 0 to exit | Weapon ID : ");
            weaponID = scan.nextInt();
            if (weaponID > 0 && weaponID <= Weapon.createWeapon().length){
                weapon = Weapon.choiceWeapon(weaponID);
                if(weapon.getMoney() <= character.getMoney()){
                    choiceInventory = weapon;
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
