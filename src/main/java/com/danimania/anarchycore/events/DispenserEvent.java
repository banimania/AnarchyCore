package com.danimania.anarchycore.events;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

public class DispenserEvent implements Listener {

    @EventHandler
    public void onDispense(BlockDispenseEvent e){
        if(e.getBlock().getLocation().getY()>250 || e.getBlock().getLocation().getY()<5 || e.getItem().getType() == Material.FLINT_AND_STEEL){
            if(Utils.getConfig().getBoolean("antidispensercrash.enabled")){
                e.setCancelled(true);
                if(Utils.getConfig().getBoolean("antidispensercrash.loginconsole")){
                    Bukkit.getLogger().info(ChatColor.RED+"Someone tried to crash the server at X"+e.getBlock().getLocation().getX()+" Z"+e.getBlock().getLocation().getZ());
                }
            }
        }
    }
}
