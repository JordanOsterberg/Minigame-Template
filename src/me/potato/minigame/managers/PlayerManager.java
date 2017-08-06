package me.potato.minigame.managers;

import me.potato.minigame.Gamestates;
import me.potato.minigame.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PlayerManager {

    private Main main;
    public PlayerManager(Main main) {
        this.main = main;
    }

    public ArrayList<Player> vanished = new ArrayList<>();

    public void toggleVanish(Player player) {
        if (!vanished.contains(player)) {
            vanished.add(player);
            for (Player online : Bukkit.getOnlinePlayers()) {
                online.hidePlayer(player);
            }
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(new ChatManager(main).format("&aYou have been vanished."));
        } else {
            vanished.remove(player);
            for (Player online : Bukkit.getOnlinePlayers()) {
                online.showPlayer(player);
            }
            player.sendMessage(new ChatManager(main).format("&aYou have been unvanished."));
        }
    }

    public void handle(Player player) {
        if (main.getGamestate() == Gamestates.LOBBY) {
            player.setExp(0);
            player.setTotalExperience(0);
            player.setHealth(20);
            player.setFoodLevel(20);
            player.setGameMode(GameMode.SURVIVAL);
            player.setAllowFlight(false);
            player.sendMessage(new ChatManager(main).format("&bWelcome to the minigame!"));
        } else if (main.getGamestate() == Gamestates.INGAME || main.getGamestate() == Gamestates.ENDGAME || main.getGamestate() == Gamestates.PREGAME) {
            toggleVanish(player);
        }
    }
}
