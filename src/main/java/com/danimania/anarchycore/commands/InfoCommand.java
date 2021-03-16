package com.danimania.anarchycore.commands;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        for(String line : Utils.getConfig().getStringList("stats-command")){
            Utils.sendRawMessage(p, line.replaceAll("<online>", Bukkit.getOnlinePlayers().size()+"").replaceAll("<discord>", Utils.getConfig().getString("links.discord")));
        }
        return true;
    }
}
