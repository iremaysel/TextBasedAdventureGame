package Character;

import Inventory.DefenseInventory.DefenseInventory;
import Inventory.Materials.Materials;

public class Archer extends Character {

    public Archer() {
        super(2, 7, 18, 20, "Archer",
                Materials.createMaterial(),
                DefenseInventory.createDefenseInventory()
        );
    }
}
