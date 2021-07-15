package com.danimania.anarchycore.events;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockPlaceEvent implements Listener {
    @EventHandler
    public void onPlaceEvent(org.bukkit.event.block.BlockPlaceEvent e){
        if(!e.getPlayer().isOp()){
            if(Utils.getConfig().getBoolean("antiblockplaces.enabled")){
                switch (e.getBlockPlaced().getType()){
                    case BEDROCK:
                        if(Utils.getConfig().getBoolean("antiblockplaces.blocks.bedrock")){
                            e.setCancelled(true);
                            Utils.sendMessage(e.getPlayer(), "&cYou can't place bedrock!");
                            e.getPlayer().getInventory().getItemInMainHand().setAmount(0);
                        }
                        break;
                    case BARRIER:
                        if(Utils.getConfig().getBoolean("antiblockplaces.blocks.barriers")){
                            e.setCancelled(true);
                            Utils.sendMessage(e.getPlayer(), "&cYou can't place barriers!");
                            e.getPlayer().getInventory().getItemInMainHand().setAmount(0);
                        }
                        break;
                }
            }
        }
    }
}
