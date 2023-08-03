package Location.BattleLoc;

import Inventory.Inventory;
import Inventory.Materials.Food;
import Inventory.Materials.Materials;
import Location.Location;
import Obstacle.Obstacle;

public class Cave extends BattleLoc {
    public Cave() {
        super("Cave",
                1,
                Materials.choiceMaterial("food"),
                Obstacle.createObstacle(1)
        );
    }
}
