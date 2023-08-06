package Game;

import Inventory.Materials.Materials;
import Location.Location;
import Location.SafeLoc.SafeHome;
import Location.SafeLoc.ShoppingStore;
import Player.Player;
import Character.Character;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void startPlay(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\n  Hi. Can you tell me your name to get started?");
        System.out.print("  Character name : ");

        String name = scan.nextLine();
        name = name.equals("") ? "Player 1" : name;
        Player player = new Player(name);
        player.setName(name);

        System.out.print("\n  *********  Welcome "+ player.getName());
        System.out.print(", Please Select Character To Continue  *********\n");

        int choice = 0;
        Character choiceCharacter = null;
        int decision = 0;
        Location location = null;
        boolean finishGame = false;

        while (decision != 2 && finishGame != true) {
            if (choice == 0) {
                choiceCharacter = Character.selectCharacter();
                choice = 1;
            }

            checkFinishGame(choiceCharacter);

            if (choiceCharacter.getHealty() == 0) {
                System.out.println("  You have run out of lives in the game.");
                choice = 0;
                continue;
            }

            System.out.println("\n  1    -->  Return to Safe Home (Life is Regenerated)");
            System.out.println("\n  2    -->  Finish The Game");
            System.out.println("\n  3    -->  Select Location");
            System.out.println("\n  4    -->  View Character");

            try {
                System.out.print("\n  What would you like to do? : ");
                decision = scan.nextInt();

                switch (decision){
                case 1 :
                    SafeHome.recharge(choiceCharacter);
                    continue;
                case 2 :
                    System.out.println("  You Left The Game");
                    System.out.println("  \n Checking out... ");
                    System.out.println("  \n SEE You AGAIN :) \n");
                    break;
                case 3 :
                    location = Location.selectLocation();
                    if (location.getBattleID() == 0){
                        ShoppingStore.visitTheStore(choiceCharacter);
                        continue;
                    } else {
                        startGame(choiceCharacter, location, name);
                    }
                    break;
                case 4 :
                    Player.viewCharacter(choiceCharacter, name);
                    continue;
                default :
                    System.out.println("\n  You made the wrong choice. Try again!");
                    continue;
            }

            } catch (Exception e) {
                System.out.println("\n  Invalid input! Please enter a valid option.");
                scan.nextLine(); // Clear the input buffer
            }

            if(choiceCharacter.getHealty() == 0 && decision == 3 && location.getBattleID() != 0){
                System.out.println("  Not enough Health ");
                continue;
            }
        }
    }

    public static int randomStart(){
        Random randomStart = new Random();
        return randomStart.nextInt(2);
    }

    public static void scoreResult(int totalMonsterHealty, int characterHealty,
                                   String monsterName, int numberOfMonster,
                                   Location selectBattleLoc, Character selectCharacter,
                                   String name ){
        if (characterHealty <= 0 && totalMonsterHealty <= 0){
            System.out.print("\n  " + selectCharacter.getCharacterName() + " ("+ name +") : " + 0 + "     X     ");
            System.out.println( monsterName +" : " + 0);
            System.out.println("\n  ------------------------------------");
            System.out.println("  ***** THE GAME ENDED IN A DRAW *****");
            System.out.println("  ------------------------------------");
        } else if (characterHealty <= 0) {
            System.out.print("\n  " + selectCharacter.getCharacterName() + " ("+ name +") : " + 0 + "     X     ");
            System.out.println( monsterName +" : " + totalMonsterHealty);
            System.out.println("\n  ------------------------------------");
            System.out.println("  ************** GAME OVER ***********");
            System.out.println("  ------------------------------------");
        } else if ( totalMonsterHealty <= 0 ) {
            System.out.print("\n  " + selectCharacter.getCharacterName() + " ("+ name +") : " + characterHealty + "     X     ");
            System.out.println( monsterName +" : " + 0);
            System.out.println("\n  ------------------------------------");
            System.out.println("  ************** YOU WON *************");
            System.out.println("  ------------------------------------");
            selectCharacter.setMoney(selectBattleLoc.getObstacle().getMoney() * numberOfMonster + selectCharacter.getMoney());
            System.out.println("  \t+Money     :\t " + selectBattleLoc.getObstacle().getMoney() * numberOfMonster);
            if (selectBattleLoc.getInventory().getStatus() == false){
                Materials[] selectMaterial = selectCharacter.getInventories();
                for (Materials m : selectMaterial){
                    if (selectBattleLoc.getInventory().getName().equals(m.getName())){
                        if (m.getStatus() == false){
                            System.out.println("  \t+Material  :\t " + selectBattleLoc.getInventory().getName());
                            m.setStatus(true);
                        }
                    }
                }
            }
            System.out.println("  ------------------------------------\n");
        } else {
            System.out.print("\n  " + selectCharacter.getCharacterName() + " ("+ name +") : " + characterHealty + "     X     ");
            System.out.println( monsterName +" : " + totalMonsterHealty);
        }
    }

    public static void startGame(Character selectCharacter, Location selectBattleLoc, String name){
        int healtyMonster = selectBattleLoc.getObstacle().getHealty();
        int numberOfMonster = selectBattleLoc.getObstacle().getNumberOfMonster();
        int totalMonsterHealty = healtyMonster * numberOfMonster;
        int characterHealty = selectCharacter.getHealty();
        String monsterName = selectBattleLoc.getObstacle().getCharacterName();
        int randomStart = randomStart(); // 0 Player, 1 Monster

        String title = randomStart == 0 ? "  The game will start randomly, it's your turn to play" :
                "  The game will start randomly, the game order is " + monsterName;

        System.out.println(title);
        System.out.print("\n  Number of Monsters : " + numberOfMonster );
        System.out.println("  |  Monster Name : " + monsterName );

        scoreResult(totalMonsterHealty, characterHealty, monsterName,  numberOfMonster, selectBattleLoc, selectCharacter, name);

        if (randomStart == 0){
            // Player
            while (characterHealty >= 0 && totalMonsterHealty > 0) {
                totalMonsterHealty -= selectCharacter.getDamage();
                scoreResult(totalMonsterHealty, characterHealty, monsterName,  numberOfMonster, selectBattleLoc, selectCharacter, name);
                if ( totalMonsterHealty > 0 ) {
                    characterHealty -= selectBattleLoc.getObstacle().getDamage();
                }
                selectCharacter.setHealty(characterHealty);
            }
        } else {
            // Monster
            while (characterHealty > 0) {
                if ( totalMonsterHealty <= 0 ){
                    scoreResult(totalMonsterHealty, characterHealty, monsterName,  numberOfMonster, selectBattleLoc, selectCharacter, name);
                    break;
                }
                characterHealty -= selectBattleLoc.getObstacle().getDamage();
                scoreResult(totalMonsterHealty, characterHealty, monsterName,  numberOfMonster, selectBattleLoc, selectCharacter, name);
                totalMonsterHealty -= selectCharacter.getDamage();
                selectCharacter.setHealty(characterHealty);
            }

        }
    }

    public static Boolean checkFinishGame(Character character){
        int check = Materials.createMaterial().length;
        int total = 0;

        for(Materials materials: character.getInventories()){
            if(materials.getStatus() == true) total += 1;
        }

        if (total == check){
            Player.viewCharacter(character, character.getCharacterName());
            System.out.println("  Congratulations, you finished the game :)");
            return true;
        }

        return false;
    }
}
