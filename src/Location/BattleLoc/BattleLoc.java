package Location.BattleLoc;

import Inventory.Inventory;
import Location.Location;
import Obstacle.Obstacle;

import java.util.Scanner;

public class BattleLoc extends Location {
    public BattleLoc(String name, int battleID, Inventory inventory, Obstacle obstacle) {
        super(name, battleID, inventory, obstacle);
    }

    public static Location[] createLocation(){
        Location cave = new Cave();
        Location forest = new Forest();
        Location river = new River();

        Location[] battleLoc = {cave, forest, river};

        return battleLoc;
    }
    public static void printBattleLoc(){
        Location[] battleLoc = createLocation();

        String title = "  Location  |  BattleID  |  Obstacle  |  Piece  |  Inventory  |";
        String title2 = "  ----------------------------------------------------";
        System.out.println("\n" + title + "\n" + title2);
        for (Location l :battleLoc ) {
            System.out.print("  " + l.getName() + " \t  ");
            System.out.print("  " + l.getBattleID() + " \t  ");
            System.out.print("  " + l.getObstacle().getCharacterName() + " \t  ");
            System.out.print("  " + l.getObstacle().getNumberOfMonster() + " \t\t ");
            System.out.print("  " + l.getInventory().getName() + " \t\t\n");
        }
    }

    public static Location selectBattleLoc(){
        Location[] battleLocs = createLocation();
        Scanner scan = new Scanner(System.in);
        Location choiceReturn = null;

        while (choiceReturn == null) {
            System.out.print("\n  Battle ID : ");
            int selectNumber = scan.nextInt();

            switch (selectNumber){
                case 1:
                    System.out.println("\n  You Have Selected the Cave.\n");
                    break;
                case 2:
                    System.out.println("\n  You Have Selected the Forest.\n");
                    break;
                case 3:
                    System.out.println("\n  You Have Selected the River.\n");
                    break;
                default:
                    System.out.println("\n  You made the wrong choice. Try again!");
            }
            if (selectNumber >= 1 && selectNumber < battleLocs.length+1){
                choiceReturn = battleLocs[selectNumber-1];
                return choiceReturn;
            }
        }
        return choiceReturn;
    }
}
