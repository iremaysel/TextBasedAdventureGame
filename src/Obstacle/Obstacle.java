package Obstacle;
import Character.Character;

import java.util.Random;

public class Obstacle extends Character {
    private int numberOfMonster;

    public Obstacle(int id, int damage, int healty, int money, String characterName, int numberOfMonster){
        super(id, damage, healty, money, characterName);
        this.numberOfMonster = numberOfMonster;
    }

    public int getNumberOfMonster(){
        return numberOfMonster;
    }

    public void setNumberOfMonster(int numberOfMonster){
        if (numberOfMonster < 0){
            numberOfMonster = 0;
        }
        this.numberOfMonster = numberOfMonster;
    }


    public static int numberMonster(int num){
        Random random = new Random();
        int numberMoster = random.nextInt(num) + 1;
        return numberMoster;
    }

    public static Obstacle createObstacle(int obstacleID){
        Obstacle zombie = new Zombie();
        Obstacle vampire = new Vampire();
        Obstacle bear = new Bear();

        Obstacle[] obstacleArr = {zombie, vampire, bear};
        Obstacle choiceObstacle = null;

        for (Obstacle o: obstacleArr) {
            if(o.getId() == obstacleID){
                choiceObstacle = o;
                return choiceObstacle;
            }
        }
        return choiceObstacle;
    }

}
