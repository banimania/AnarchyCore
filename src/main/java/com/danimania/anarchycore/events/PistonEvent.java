package com.danimania.anarchycore.events;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakEvent;

import java.util.Random;

public class PistonEvent implements Listener {
    @EventHandler
    public void onItemPickup(HangingBreakEvent e){
        if(Utils.getConfig().getBoolean("piston-dupe.enabled")){
            if (e.getEntity().getType() == EntityType.ITEM_FRAME) {
                if (e.getCause() == HangingBreakEvent.RemoveCause.PHYSICS) {
                    ItemFrame itemFrame = (ItemFrame) e.getEntity();
                    if (itemFrame.getItem() != null) {
                        if (!(itemFrame.getItem().getType() == Material.AIR)) {
                            if (itemFrame.getWorld().getBlockAt(itemFrame.getLocation()).getRelative(itemFrame.getAttachedFace()).getType() != Material.AIR){
                                int amount = Utils.getConfig().getInt("piston-dupe.amount");
                                for (int i = 0; i < amount; i++) {
                                    itemFrame.getWorld().dropItem(itemFrame.getLocation(), itemFrame.getItem());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
