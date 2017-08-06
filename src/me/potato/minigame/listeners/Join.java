package me.potato.minigame.listeners;

import me.potato.minigame.Main;
import me.potato.minigame.managers.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    private Main main;
    public Join(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        new PlayerManager(main).handle(p);
    }
}
