package com.danimania.anarchycore.events;

import com.danimania.anarchycore.commands.NameColorCommand;
import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if(NameColorCommand.customname.containsKey(p)){
            e.setCancelled(true);
            for(Player pl : Bukkit.getOnlinePlayers()){
                Utils.sendRawMessage(pl, NameColorCommand.customname.get(p)+e.getMessage());
            }
        }
    }
}
