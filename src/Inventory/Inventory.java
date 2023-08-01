package Inventory;

import Inventory.DefenseInventory.Armor.Armor;
import Inventory.DefenseInventory.Weapon.Weapon;
import Inventory.DefenseInventory.DefenseInventory;
import Inventory.Materials.Materials;
import Location.Location;

public class Inventory {
    String name;

    boolean status;

    public Inventory(String name, boolean status){
        this.name = name;
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Silahlar -- weapon
    // Zırhlar -- Armor



}
