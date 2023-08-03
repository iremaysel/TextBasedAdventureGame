package Location.SafeLoc;
import Character.Character;

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

        for (Character c: character) {
            if(c.getId() == player.getId()){
                System.out.println("\n  Life loading...");
                player.setHealty(c.getHealty());
            }
        }
    }
}
