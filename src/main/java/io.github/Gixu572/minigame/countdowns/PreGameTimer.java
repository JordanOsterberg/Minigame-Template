package io.github.Gixu572.minigame.countdowns;

import io.github.Gixu572.minigame.Gamestates;
import io.github.Gixu572.minigame.Main;
import io.github.Gixu572.minigame.managers.ChatManager;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class PreGameTimer {

    private Main main;
    public PreGameTimer(Main main) {
        this.main = main;
    }

    public void startCountdown() {
        new BukkitRunnable() {

            int number = 30;

            @Override
            public void run() {
                if (number > 0) {
                    if (number == 30) {
                        main.setGamestate(Gamestates.PREGAME);
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 30 seconds.");
                    }
                    if (number == 20) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 20 seconds.");
                    }
                    if (number == 10) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 10 seconds.");
                    }
                    if (number == 5) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 5 seconds.");
                    }
                    if (number == 4) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 4 seconds.");
                    }
                    if (number == 3) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 3 seconds.");
                    }
                    if (number == 2) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 2 seconds.");
                    }
                    if (number == 1) {
                        Bukkit.broadcastMessage(new ChatManager(main).prefix + "Game starting in 1 second.");
                        // DO PREGAME THINGS, SCATTER, KITS, ETC
                    }
                    number--;
                } else {
                    Bukkit.broadcastMessage(new ChatManager(main).prefix + "The game has now started!");
                    cancel();
                }
            }
        }.runTaskTimer(main,20L, 20L);
    }

}
