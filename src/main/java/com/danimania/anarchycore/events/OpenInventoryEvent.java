package com.danimania.anarchycore.events;

import com.danimania.anarchycore.utils.IllegalUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;


public class OpenInventoryEvent implements Listener {

    @EventHandler
    public void onInventoryEvent(InventoryOpenEvent e){
        if(e.getInventory().getType() == InventoryType.HOPPER){
            if(!e.getPlayer().isOp() && !e.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
                for(ItemStack it : e.getPlayer().getInventory().getContents()){
                    if(it != null){
                        if(IllegalUtils.isIllegal(it)){
                            for(ItemStack illegal : e.getPlayer().getInventory().getContents()){
                                if(illegal != null){
                                    e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), illegal);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
