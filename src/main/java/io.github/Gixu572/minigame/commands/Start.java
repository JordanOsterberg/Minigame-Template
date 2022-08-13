package io.github.Gixu572.minigame.commands;

import io.github.Gixu572.minigame.Main;
import io.github.Gixu572.minigame.countdowns.PreGameTimer;
import io.github.Gixu572.minigame.managers.ChatManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Start implements CommandExecutor {

    private Main main;
    public Start(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;

        if (!p.hasPermission("game.start")) {
            p.sendMessage(new ChatManager(main).permission);
            return true;
        } else if (cmd.getName().equalsIgnoreCase("start")) {
            new PreGameTimer(main).startCountdown();
            p.sendMessage(new ChatManager(main).prefix + "You have started the game.");
            return true;
        }
        return true;
    }
}
