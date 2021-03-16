package com.danimania.anarchycore.commands;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoindateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        String jd = Utils.getJoindate(p);
        if(args.length == 0){
            Utils.sendMessage(p, Utils.getConfig().getString("joindate.joindate-msg").replaceAll("<jd>", jd));
        }else{
            if(Bukkit.getPlayer(args[0]) == null){
                Utils.sendMessage(p, Utils.getConfig().getString("joindate.joindate-notonline"));
            }else{
                Player p2 = (Player) Bukkit.getPlayer(args[0]);
                String jd2 = Utils.getJoindate(p2);
                Utils.sendMessage(p, Utils.getConfig().getString("joindate.joindate-other").replaceAll("<jd>", jd2).replaceAll("<p>", p2.getName()));
            }
        }
        return true;
    }


}
