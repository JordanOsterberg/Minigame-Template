package me.potato.minigame.listeners;

import me.potato.minigame.Gamestates;
import me.potato.minigame.Main;
import me.potato.minigame.managers.ChatManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Build implements Listener {

    private Main main;
    public Build(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();
        if (main.getGamestate() == Gamestates.LOBBY || main.getGamestate() == Gamestates.PREGAME) {
            event.setCancelled(true);
            p.sendMessage(new ChatManager(main).prefix + "You cannot build before the game!");
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player p = event.getPlayer();
        if (main.getGamestate() == Gamestates.LOBBY || main.getGamestate() == Gamestates.PREGAME) {
            event.setCancelled(true);
            p.sendMessage(new ChatManager(main).prefix + "You cannot build before the game!");
        }
    }
}
