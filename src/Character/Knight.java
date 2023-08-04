package Character;

import Inventory.DefenseInventory.DefenseInventory;
import Inventory.Materials.Materials;

public class Knight extends Character{

    public Knight() {
        super(3, 8, 24, 5, "Knight",
                Materials.createMaterial()
        );
    }
}
