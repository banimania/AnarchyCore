package com.danimania.anarchycore.commands;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(args.length == 0){
            int ping = Utils.getPing(p);
            Utils.sendMessage(p, Utils.getConfig().getString("ping.ping-msg").replaceAll("<ping>", ping+""));
        }else{
            if(Bukkit.getPlayer(args[0]) == null){
                Utils.sendMessage(p, Utils.getConfig().getString("ping.ping-notonline"));
            }else{
                Player p2 = Bukkit.getPlayer(args[0]);
                int ping2 = Utils.getPing(p2);
                Utils.sendMessage(p, Utils.getConfig().getString("ping.ping-other").replaceAll("<ping>", ping2+"").replaceAll("<p>", p2.getName()));
            }
        }
        return true;
        }
    }
