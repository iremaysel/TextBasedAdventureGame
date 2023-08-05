package Location.SafeLoc;
import Character.Character;
import Inventory.DefenseInventory.DefenseInventory;

public class SafeHome {
    private Character character;

    public SafeHome(Character character){
        this.character = character;
    }

    public Character getCharacter(){
        return character;
    }

    public void setCharacter(Character character){
        this.character = character;
    }

    public static void recharge(Character player){
        System.out.println("  You're at Home Safe!");
        Character[] character = Character.createCharacter();
        int totalHealty = 0;
        for (Character c: character) {
            if(c.getId() == player.getId()){
                totalHealty += c.getHealty();
                System.out.println("\n  Life loading...");
                for (DefenseInventory[] defenseInventories : player.getDefenseInventory()){
                    for(DefenseInventory defenseInventory : defenseInventories){
                        if(defenseInventory.getStatus() == true && defenseInventory.getDefenseName().toUpperCase().equals("ARMOR")){
                            totalHealty += defenseInventory.getDamage();
                        }
                    }
                }
            }
        }
        player.setHealty(totalHealty);
    }
}
