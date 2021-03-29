package com.danimania.anarchycore.events;

import com.danimania.anarchycore.commands.ToggleDeathMsgsCommand;
import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {

    public String deathmessage;

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if(Utils.getConfig().getBoolean("death-messages.enabled")){
            deathmessage = e.getDeathMessage();
            e.setDeathMessage("");
            sendDeathMessage();
        }
    }

    public void sendDeathMessage(){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(!ToggleDeathMsgsCommand.muted.contains(p)){
                Utils.sendRawMessage(p, deathmessage);
            }
        }
    }

}
