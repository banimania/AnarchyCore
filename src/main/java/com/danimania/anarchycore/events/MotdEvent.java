package com.danimania.anarchycore.events;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.Random;


public class MotdEvent implements Listener {
    @EventHandler
    public void onPing(ServerListPingEvent e){
        if(Utils.getConfig().getBoolean("motd.enabled")){
            int max = Utils.getConfig().getStringList("motd.motd-list").size();
            int rand = new Random().nextInt(max);
            e.setMotd(Utils.getConfig().getStringList("motd.motd-list").get(rand));
        }
    }
}
