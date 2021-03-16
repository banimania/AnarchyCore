package com.danimania.anarchycore.events;

import com.danimania.anarchycore.commands.ToggleJoinMessages;
import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        if(Utils.getConfig().getBoolean("join-messages.enabled")){
            e.setQuitMessage("");
            sendLeaveMessage(e.getPlayer());
        }
    }

    public static void sendLeaveMessage(Player quit){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(!ToggleJoinMessages.muted.contains(p)){
                Utils.sendRawMessage(p, Utils.getConfig().getString("join-messages.leave").replaceAll("<player>", quit.getName()));
            }
        }
    }
}
