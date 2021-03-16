package com.danimania.anarchycore.commands;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(p.getBedSpawnLocation() != null){
            int x = (int) p.getBedSpawnLocation().getX();
            int y = (int) p.getBedSpawnLocation().getY();
            int z = (int) p.getBedSpawnLocation().getZ();
            Utils.sendMessage(p, Utils.getConfig().getString("bed-command.message-bed").replaceAll("<x>", Integer.toString(x)).replaceAll("<y>", Integer.toString(y)).replaceAll("<z>", Integer.toString(z)));
        }else{
            Utils.sendMessage(p, Utils.getConfig().getString("bed-command.message-nobed"));
        }

        return true;
    }
}