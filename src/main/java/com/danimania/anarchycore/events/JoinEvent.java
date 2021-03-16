package com.danimania.anarchycore.events;

import com.danimania.anarchycore.commands.ToggleDeathMsgsCommand;
import com.danimania.anarchycore.commands.ToggleJoinMessages;
import com.danimania.anarchycore.utils.Utils;
import javafx.scene.control.Toggle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(Utils.getConfig().getBoolean("join-messages.enabled")){
            e.setJoinMessage("");
            sendJoinMessage(e.getPlayer());
            displayMotdMessage(e.getPlayer());
        }
    }

    public static void sendJoinMessage(Player joined){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(!ToggleJoinMessages.muted.contains(p)){
                Utils.sendRawMessage(p, Utils.getConfig().getString("join-messages.join").replaceAll("<player>", joined.getName()));
            }
        }
    }

    public void sendMotd(Player p){
        Utils.sendMessage(p, Utils.getConfig().getString("welcome-message.message").replaceAll("<player>", p.getName())
                .replaceAll("<connected>", Bukkit.getServer().getOnlinePlayers().size()+"")
                .replaceAll("<maxplayers>", Bukkit.getServer().getMaxPlayers()+""));
    }

    public void displayMotdMessage(Player p){
        int show = Utils.getConfig().getInt("welcome-message.show");
        switch(show){
            case 1:
                if(!p.hasPlayedBefore()){
                    sendMotd(p);
                }
                break;
            case 2:
                sendMotd(p);
                break;
        }
    }
}
