package io.github.Gixu572.minigame.managers;

import io.github.Gixu572.minigame.Main;
import org.bukkit.ChatColor;

public class ChatManager {

    private Main main;
    public ChatManager(Main main) {
        this.main = main;
    }

    public String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public String permission = format("&cYou do not have permission to access this command.");
    public String prefix = format("&8[&bMiniGame&8] &e");
}
