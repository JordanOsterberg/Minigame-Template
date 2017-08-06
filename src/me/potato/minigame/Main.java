package me.potato.minigame;

import me.potato.minigame.commands.Vanish;
import me.potato.minigame.listeners.Join;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Gamestates gamestates;
    public Gamestates getGamestate() {
        return gamestates;
    }
    public void setGamestate(Gamestates gamestate) {
        this.gamestates = gamestate;
    }


    @Override
    public void onEnable() {
        registerCommands();
        registerEvents();
        setGamestate(Gamestates.LOBBY);
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("vanish").setExecutor(new Vanish(this));
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Join(this), this);
    }
}
