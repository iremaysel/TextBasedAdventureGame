package Character;

public class Character {
    private int id;
    private int damage;
    private int healty;
    private int money;

    private String characterName;

    public Character(int id, int damage, int healty, int money, String characterName){
        this.id = id;
        this.damage = damage;
        this.healty = healty;
        this.money = money;
        this.characterName = characterName;
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

    public int getHealty() {
        return healty;
    }
    public void setHealty(int healty) {
        if (healty < 0 ){
            healty = 0;
        }
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharacterName() {
        return characterName;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}
