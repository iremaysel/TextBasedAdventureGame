import Player.Player;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(0,0,0,0,"test", "deneme");
        int len = player.createCharacter().length;
        player.selectCharacter();
    }
}