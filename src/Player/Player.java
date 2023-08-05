package Player;

import Character.Character;
import Inventory.DefenseInventory.DefenseInventory;
import Inventory.Materials.Materials;


public class Player {
    private String name;

    public Player(String name){
        this.name = name;
    }

    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

    public static Character loadDefenseInventory(Character character, DefenseInventory choiceInventory){
        for (DefenseInventory[] defenseInventory: DefenseInventory.createDefenseInventory()){
            for (DefenseInventory characterInventory: defenseInventory) {
                if (characterInventory.getDefenseName().toUpperCase().equals(choiceInventory.getDefenseName().toUpperCase())){

                    DefenseInventory.loadDefenseStatus(character, choiceInventory.getId(), choiceInventory.getDefenseName().toUpperCase());

                    int totalMoney = character.getMoney() - choiceInventory.getMoney();
                    character.setMoney(totalMoney);

                    if (choiceInventory.getDefenseName().toUpperCase().equals("ARMOR")){
                        int totalHealty = character.getHealty() + choiceInventory.getDamage();
                        character.setHealty(totalHealty);
                        break;
                    } else if (choiceInventory.getDefenseName().toUpperCase().equals("WEAPON")) {
                        int totalDamage = character.getDamage() + choiceInventory.getDamage();
                        character.setDamage(totalDamage);
                        break;
                    }

                }
            }
        }
        return character;
    }

    public static void viewCharacter(Character character, String name){

        System.out.println("  **************************************************  ");
        System.out.println("\n  Your : " + name);
        System.out.println("  --------------------------------------------------  ");
        System.out.println("  | Character      : " + character.getCharacterName() +  "  " );
        System.out.println("  | Damage         : " + character.getDamage() +  "  " );
        System.out.println("  | Healty         : " + character.getHealty() +  "  " );
        System.out.println("  | Money          : " + character.getMoney() +  "  " );
        System.out.println("  ++++++++++++++++++++++++++++++++++++++++++++++++++  ");
        Materials.printMaterials(character.getInventories());
        System.out.println();
        DefenseInventory.printDefenseInventory(character.getDefenseInventory());
        System.out.println("\n  **************************************************  ");

    }

}
