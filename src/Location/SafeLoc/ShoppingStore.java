package Location.SafeLoc;

import Inventory.DefenseInventory.Armor.Armor;
import Inventory.DefenseInventory.DefenseInventory;
import Inventory.DefenseInventory.Weapon.Weapon;
import Inventory.Inventory;
import Inventory.Materials.Materials;
import Location.Location;
import Obstacle.Obstacle;
import Character.Character;
import Player.Player;

import java.util.Scanner;

public class ShoppingStore extends Location {
    private DefenseInventory defenseInventory[][];
    private Inventory materials[];

    public ShoppingStore(){
        super("Shopping Store", 0,
                new Inventory("",false),
                new Obstacle(0,0,0, 0,"", 0));
        this.defenseInventory = DefenseInventory.createDefenseInventory();
        this.materials = Materials.createMaterial();
    };

    public DefenseInventory[][] getDefenseInventory() {
        return defenseInventory;
    }

    public void setDefenseInventory(DefenseInventory[][] defenseInventory) {
        this.defenseInventory = defenseInventory;
    }

    public Inventory[] getMaterials() {
        return materials;
    }

    public void setMaterials(Inventory[] materials) {
        this.materials = materials;
    }

    public static void printShopping(){
        Armor.printArmor();
        Weapon.printWeapon();
    }

    public static Location selectShoppingLoc() {
        Location shoppingLoc = new ShoppingStore();
        return shoppingLoc;
    }

    public static DefenseInventory visitTheStore(Character character){
        Scanner scan = new Scanner(System.in);
        DefenseInventory choiceInventory = null;

        System.out.println("\n  1    -->  Do the shopping");
        System.out.println("\n  2    -->  Get out of the store");

        System.out.print("\n  What would you like to do? : ");
        int choiceshop = scan.nextInt();

        while (choiceInventory == null){
            switch (choiceshop) {
                case 1:
                    Armor.printArmor();
                    Weapon.printWeapon();
                    System.out.println("\n  Character Money : " + character.getMoney());
                    System.out.println("\n  A --> Armor");
                    System.out.println("  W --> Weapon");
                    System.out.println("  Q --> Quit");
                    choiceInventory = ShoppingStore.shopInventory(choiceInventory, character);

                    if (choiceInventory != null)
                        character = Player.loadDefenseInventory(character, choiceInventory);

                    return choiceInventory;
                case 2:
                    System.out.println("\n  You are leaving the store!!");
                    break;
                default:
                    System.out.println("\n  You made the wrong choice. Try again!");
                    break;
            }

            if (choiceshop == 2){
                break;
            }
        }
        return choiceInventory;
    }


    public static DefenseInventory shopInventory(DefenseInventory choiceInventory, Character character){
        Scanner scan = new Scanner(System.in);

        String selectInventoy = "";
        int invontoryID = 0;

        while (choiceInventory == null && !selectInventoy.equals("Q")){
            System.out.print("  Choice : ");
            selectInventoy = scan.next().toUpperCase();
            switch (selectInventoy){
                case "A" :
                    choiceInventory = Armor.purchasedArmor(invontoryID, choiceInventory, character);
                    break;
                case "W" :
                    choiceInventory = Weapon.purchasedWeapon(invontoryID, choiceInventory, character);
                    break;
                case "Q" :
                    System.out.println("\n  Exiting...");
                    break;
                default:
                    System.out.println("\n  You made the wrong choice. Try again!");
            }
        }
        return choiceInventory;
    }

}
