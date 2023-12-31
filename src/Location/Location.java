package Location;

import Inventory.Inventory;
import Location.BattleLoc.BattleLoc;
import Location.SafeLoc.ShoppingStore;
import Obstacle.Obstacle;

import java.util.Scanner;

public class Location {
    private String name;
    private int battleID;
    private Inventory inventory;
    private Obstacle obstacle;

    public Location(String name, int battleID, Inventory inventory, Obstacle obstacle){
        this.name = name;
        this.battleID = battleID;
        this.inventory = inventory;
        this.obstacle = obstacle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBattleID() {
        return battleID;
    }

    public void setBattleID(int battleID) {
        this.battleID = battleID;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public static void printLocation(){
        System.out.println("\n  XXXXXXXXXXXXXXXXXXXXXXXXXXXX BATTLE GROUNDS XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        BattleLoc.printBattleLoc();

        System.out.println("\n  *----------------- SHOPPING STORE -----------------*");
        ShoppingStore.printShopping();
    }

    public static Location selectLocation(){
        Scanner scan = new Scanner(System.in);
        Location l = null;
        Location.printLocation();

        System.out.print("\n  Press B for Battlefield and Press S to shop (B/S) : ");
        String location = scan.next();

        if (location.toUpperCase().equals("B")){
            return BattleLoc.selectBattleLoc();
        } else if (location.toUpperCase().equals("S")) {
            return ShoppingStore.selectShoppingLoc();
        } else {
            System.out.println("\n  You made the wrong choice. Try again!");
            selectLocation();
        }

        return l;
    }

}
