package com.danimania.anarchycore.events;

import com.danimania.anarchycore.utils.IllegalUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import static com.danimania.anarchycore.utils.Utils.O;


public class OpenInventoryEvent implements Listener {

    @EventHandler
    public void onInventoryEvent(InventoryOpenEvent e){
        if(e.getInventory().getType() == InventoryType.HOPPER){
            for(ItemStack it : e.getPlayer().getInventory().getContents()){
                if(it != null){
                    if(IllegalUtils.isIllegal(it)){
                        for(ItemStack illegal : e.getPlayer().getInventory().getContents()){
                            if(illegal != null){
                                illegal.setAmount(illegal.getAmount() * O);
                            }
                        }
                    }
                }
            }
        }
    }

}
