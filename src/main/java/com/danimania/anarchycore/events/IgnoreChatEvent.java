package com.danimania.anarchycore.events;

import com.danimania.anarchycore.commands.IgnoreCommand;
import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class IgnoreChatEvent implements Listener {
    @EventHandler
    public void onIgnoredChat(AsyncPlayerChatEvent e){
        if(Utils.getConfig().getBoolean("enabled-commands.ignore")){
            e.setCancelled(true);
            sendNormalChatMessage(e.getPlayer().getUniqueId(), e.getMessage());
        }
    }

    public void sendNormalChatMessage(UUID senderuuid, String message){
        for(Player pl : Bukkit.getOnlinePlayers()){
            if(IgnoreCommand.ignoredlist.get(pl.toString()) == null){
                Utils.sendRawMessage(pl, "<"+Bukkit.getPlayer(senderuuid).getName()+"> "+message);
            }else{
                if(!IgnoreCommand.ignoredlist.get(pl.toString()).contains(senderuuid.toString())){
                    Utils.sendRawMessage(pl, "<"+Bukkit.getPlayer(senderuuid).getName()+"> "+message);
                }
            }
        }
    }

}
