package me.potato.minigame.managers;

import me.potato.minigame.Gamestates;
import me.potato.minigame.Main;
import org.bukkit.entity.Player;

public class PlayerManager {

    private Main main;
    public PlayerManager(Main main) {
        this.main = main;
    }

    public void handle(Player player) {
        if (main.getGamestate() == Gamestates.LOBBY) {

        }
    }
}
