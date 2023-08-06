package Location.BattleLoc;

import Inventory.Materials.Materials;
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
