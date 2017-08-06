package me.potato.minigame.listeners;

import me.potato.minigame.Gamestates;
import me.potato.minigame.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Food implements Listener {

    private Main main;
    public Food(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (main.getGamestate() == Gamestates.LOBBY || main.getGamestate() == Gamestates.PREGAME) {
            event.setCancelled(true);
        }
    }
}
