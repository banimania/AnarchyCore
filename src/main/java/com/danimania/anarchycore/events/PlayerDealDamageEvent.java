package com.danimania.anarchycore.events;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDealDamageEvent implements Listener {

    @EventHandler
    public void onDamageDealt(EntityDamageByEntityEvent e){
        if(Utils.getConfig().getBoolean("32kpatch.enabled")){
            if(e.getDamager() instanceof Player){
                Player p = (Player) e.getDamager();
                if(!p.hasPermission(Utils.getConfig().getString("permissions.bypass-illegals"))){
                    if(e.getDamage()>40){
                        e.setCancelled(true);
                    }
                }
            }
        }

    }

}
