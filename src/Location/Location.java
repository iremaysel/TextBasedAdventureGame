package Location;

import Inventory.Inventory;
import Location.BattleLoc.BattleLoc;
import Location.SafeLoc.ShoppingStore;
import Obstacle.Obstacle;

import java.security.PublicKey;
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
        System.out.println("  XXXXXXXXXXXXXXXXXX BATTLE GROUNDS XXXXXXXXXXXXXXXXXX");
        BattleLoc.printBattleLoc();

        System.out.println("\n  *----------------- SHOPPING STORE -----------------*");
        ShoppingStore.printShopping();
    }

    public static void selectLocation(){
        Scanner scan = new Scanner(System.in);

        Location.printLocation();

        System.out.print("\n  Press B for Battlefield and Press S to shop (B/S) : ");
        String location = scan.next();

        if (location.toUpperCase().equals("B")){
            BattleLoc.selectBattleLoc();
        } else if (location.toUpperCase().equals("S")) {
            System.out.println("\n  Devam Edecek..");
        }
    }


    // player : Player
    // name : String
    // location() : void
    // onLocation : boolean

}
