package com.danimania.anarchycore.commands;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ToggleJoinMessages implements CommandExecutor {

    public static List<Player> muted = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(Utils.getConfig().getBoolean("join-messages.enabled")){
            if(muted.contains(p)){
                muted.remove(p);
                Utils.sendMessage(p, Utils.getConfig().getString("join-messages.unmuted"));
            }else{
                muted.add(p);
                Utils.sendMessage(p, Utils.getConfig().getString("join-messages.muted"));
            }
        }else{
            for(Player player : muted){
                muted.remove(player);
            }
        }
        return true;
    }
}
