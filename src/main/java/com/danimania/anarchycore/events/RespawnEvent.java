package com.danimania.anarchycore.events;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.Random;

public class RespawnEvent implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        if(Utils.getConfig().getBoolean("random-spawn.enabled")){
            if(!e.isBedSpawn()){
                int minX = Utils.getConfig().getInt("random-spawn.minX");
                int minZ = Utils.getConfig().getInt("random-spawn.minZ");
                int maxX = Utils.getConfig().getInt("random-spawn.maxX");
                int maxZ = Utils.getConfig().getInt("random-spawn.maxZ");
                World respawnWorld = Bukkit.getWorld(Utils.getConfig().getString("random-spawn.world-name"));
                int randX = new Random().nextInt(maxX-minX+1)+minX;
                int randZ = new Random().nextInt(maxZ-minZ+1)+minZ;
                int y = respawnWorld.getHighestBlockYAt(randX, randZ);
                e.setRespawnLocation(new Location(respawnWorld, randX, y, randZ));
            }
        }
    }

}
