package me.potato.minigame.managers;

import me.potato.minigame.Main;
import org.bukkit.ChatColor;

public class ChatManager {

    private Main main;
    public ChatManager(Main main) {
        this.main = main;
    }

    public String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
