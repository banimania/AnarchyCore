package com.danimania.anarchycore.events;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractWithEntityEvent implements Listener {

    @EventHandler
    public void onInteractAtEntity(PlayerInteractAtEntityEvent e){
        Player p = e.getPlayer();
        Entity entity = e.getRightClicked();
        if(Utils.getConfig().getBoolean("salc1-dupe.enabled")){
            if(p.getInventory().getItemInMainHand().getType() == Material.CHEST){
                if(entity instanceof Donkey || entity instanceof Llama){
                    e.setCancelled(true);
                    ChestedHorse donkey = (ChestedHorse) entity;
                    for(ItemStack i : donkey.getInventory().getContents()){
                        if(i != null){
                            if(i.getType() != Material.SADDLE){
                                donkey.getWorld().dropItem(donkey.getLocation(), i);
                            }
                        }
                    }
                    Utils.sendMessage(p, Utils.getConfig().getString("salc1-dupe.message"));
                    donkey.setCarryingChest(false);
                }
            }
        }
    }

}
