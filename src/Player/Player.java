package Player;

import Character.Character;
import Character.Samurai;
import Character.Archer;
import Character.Knight;

import Inventory.Inventory;

import java.util.Scanner;

public class Player {
    private String name;
    //private Inventory inventory;

    public Player(String name/*, Inventory inventory*/){
        this.name = name;
        //this.inventory = inventory;
    }

    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

}
