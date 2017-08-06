package me.potato.minigame.listeners;

import me.potato.minigame.Main;
import me.potato.minigame.managers.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;

public class InventoryInteract implements Listener {

    private Main main;
    public InventoryInteract(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onInteract(InventoryInteractEvent event) {
        if (new PlayerManager(main).vanished.contains(event.getWhoClicked())) {
            event.setCancelled(true);
        }
    }
}
