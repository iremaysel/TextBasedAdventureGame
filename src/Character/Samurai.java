package Character;

import Inventory.DefenseInventory.DefenseInventory;
import Inventory.Materials.Materials;

public class Samurai extends Character{


    public Samurai() {
        super(1, 5, 21, 15, "Samurai",
                Materials.createMaterial()
        );
    }
}
