package com.danimania.anarchycore.events;

import com.danimania.anarchycore.commands.IgnoreCommand;
import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class IgnoreChatEvent implements Listener {

    Player sender;
    String msg;

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        sender = e.getPlayer();
        msg = e.getMessage();
        e.setCancelled(true);
        sendMessage();
    }

    public void sendMessage(){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(IgnoreCommand.ignored.get(p) == sender){
                return;
            }else{
                Utils.sendRawMessage(p, "<"+sender.getName()+"> "+msg);
            }
        }
    }

}
