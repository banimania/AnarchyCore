package com.danimania.anarchycore.commands;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        Utils.sendMessage(p, Utils.getConfig().getString("links.discord-message")+Utils.getConfig().getString("links.discord"));
        return true;
    }
}
