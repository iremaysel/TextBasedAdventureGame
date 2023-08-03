package Location.BattleLoc;

import Inventory.Inventory;
import Inventory.Materials.Materials;
import Obstacle.Obstacle;

public class River extends BattleLoc {
    public River() {
        super("River",
                3,
                Materials.choiceMaterial("water"),
                Obstacle.createObstacle(3));
    }
}
