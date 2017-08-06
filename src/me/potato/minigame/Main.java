package me.potato.minigame;

import me.potato.minigame.commands.Start;
import me.potato.minigame.commands.Vanish;
import me.potato.minigame.listeners.Build;
import me.potato.minigame.listeners.Damage;
import me.potato.minigame.listeners.Join;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    public Gamestates gamestates;
    public Gamestates getGamestate() {
        return gamestates;
    }
    public void setGamestate(Gamestates gamestate) {
        this.gamestates = gamestate;
    }

    public ArrayList<Player> alive = new ArrayList<>();
    public ArrayList<Player> spectating = new ArrayList<>();
    public ArrayList<Player> vanished = new ArrayList<>();

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
        getCommand("start").setExecutor(new Start(this));
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Join(this), this);
        pm.registerEvents(new Build(this), this);
        pm.registerEvents(new Damage(this), this);
    }
}
