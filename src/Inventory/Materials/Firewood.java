package Inventory.Materials;

import Inventory.Inventory;

public class Firewood extends Materials{

    public Firewood() {
        super("FIREWOOD", false);
    }

    public static Inventory createFood(){
        Inventory food = new Food();
        return food;
    }
}
