package Inventory.DefenseInventory;

import Inventory.DefenseInventory.Armor.Armor;
import Inventory.DefenseInventory.Weapon.Weapon;
import Inventory.Inventory;

public class DefenseInventory extends Inventory {

    private String defenseName;
    private int id;
    private int damage;
    private int money;


    public DefenseInventory(String name, boolean status, String defenseName, int id, int damage, int money) {
        super(name, status);
        this.defenseName = defenseName;
        this.id = id;
        this.damage = damage;
        this.money = money;
    }

    public String getDefenseName() {
        return defenseName;
    }

    public void setDefenseName(String defenseName) {
        this.defenseName = defenseName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public static DefenseInventory[][] createDefenseInventory(){
        DefenseInventory[] armor = Armor.createArmor();
        DefenseInventory[] weapon = Weapon.createWeapon();

        DefenseInventory[][] defenseInventory = {armor, weapon};

        return  defenseInventory;
    }
}
