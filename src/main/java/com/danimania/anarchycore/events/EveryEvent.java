package com.danimania.anarchycore.events;

import com.danimania.anarchycore.utils.IllegalUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class EveryEvent implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerDropItemEvent e){
        cope(e.getPlayer());
    }

    public static void cope(Player p){
        if(!p.isOp()){
            IllegalUtils.checkPlayerIllegals(p.getPlayer());
        }
    }
}
