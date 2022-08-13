package io.github.Gixu572.minigame.listeners;

import io.github.Gixu572.minigame.Gamestates;
import io.github.Gixu572.minigame.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage implements Listener {

    private Main main;
    public Damage(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity().getType() == EntityType.PLAYER) {
            if (main.getGamestate() == Gamestates.PREGAME || main.getGamestate() == Gamestates.PREGAME) {
                event.setCancelled(true);
            }
        }
    }
}
