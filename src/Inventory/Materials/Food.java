package Inventory.Materials;

import Inventory.Inventory;

public class Food extends Materials {
    public Food() {
        super("FOOD", false);
    }

    public static Inventory createFood(){
        Inventory food = new Food();
        return food;
    }
}
