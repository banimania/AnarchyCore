package com.danimania.anarchycore.events;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvents implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(Utils.getConfig().getBoolean("antinetherroof.disable-netherroof")){
            if(!p.isOp()){
                if(p.getWorld().getName().equalsIgnoreCase(Utils.getConfig().getString("antinetherroof.nether-worldname"))){
                    if(p.getLocation().getY()>Utils.getConfig().getInt("antinetherroof.max-y-level")){
                        p.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()-5, p.getLocation().getZ()));
                        Utils.sendMessage(p, Utils.getConfig().getString("antinetherroof.disabled-message"));
                    }

                }
            }
        }

        if(Utils.getConfig().getBoolean("antinetherbottom.disable-netherbottom")){
            if(!p.isOp()){
                if(p.getWorld().getName().equalsIgnoreCase(Utils.getConfig().getString("antinetherbottom.nether-worldname"))){
                    if(p.getLocation().getY()<Utils.getConfig().getInt("antinetherbottom.min-y-level")){
                        p.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY()+6, p.getLocation().getZ()));
                        Utils.sendMessage(p, Utils.getConfig().getString("antinetherbottom.disabled-message"));
                    }

                }
            }
        }
    }
}
