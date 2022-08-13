package io.github.Gixu572.minigame.listeners;

import io.github.Gixu572.minigame.Gamestates;
import io.github.Gixu572.minigame.Main;
import io.github.Gixu572.minigame.countdowns.PreGameTimer;
import io.github.Gixu572.minigame.managers.PlayerManager;
import org.bukkit.Bukkit;
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
        event.setJoinMessage("");
        new PlayerManager(main).handle(p);

        if (Bukkit.getOnlinePlayers().size() >= 3) {
            new PreGameTimer(main).startCountdown();
        } else if (main.getGamestate() == Gamestates.PREGAME) {
            return;
        }
    }
}
