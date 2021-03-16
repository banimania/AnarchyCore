package com.danimania.anarchycore.commands;

import com.danimania.anarchycore.AnarchyCore;
import com.danimania.anarchycore.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        p.setHealth(0);
        return true;
    }
}