package Location.BattleLoc;

import Inventory.Materials.Materials;
import Obstacle.Obstacle;

public class Forest extends BattleLoc {
    public Forest() {
        super("Forest",
                2,
                Materials.choiceMaterial("FIREWOOD") ,
                Obstacle.createObstacle(2)
        );
    }
}
