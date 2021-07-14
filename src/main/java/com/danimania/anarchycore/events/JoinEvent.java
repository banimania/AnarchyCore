package com.danimania.anarchycore.events;

import com.danimania.anarchycore.commands.ToggleDeathMsgsCommand;
import com.danimania.anarchycore.commands.ToggleJoinMessages;
import com.danimania.anarchycore.utils.Utils;
import javafx.scene.control.Toggle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

public class JoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(Utils.getConfig().getBoolean("join-messages.enabled")){
            e.setJoinMessage("");
            sendJoinMessage(e.getPlayer());
            displayMotdMessage(e.getPlayer());
        }

        if(!e.getPlayer().hasPlayedBefore()){
            if(Utils.getConfig().getBoolean("random-spawn.enabled")){
                int minX = Utils.getConfig().getInt("random-spawn.minX");
                int minZ = Utils.getConfig().getInt("random-spawn.minZ");
                int maxX = Utils.getConfig().getInt("random-spawn.maxX");
                int maxZ = Utils.getConfig().getInt("random-spawn.maxZ");
                World respawnWorld = Bukkit.getWorld(Utils.getConfig().getString("random-spawn.world-name"));
                int randX = new Random().nextInt(maxX-minX+1)+minX;
                int randZ = new Random().nextInt(maxZ-minZ+1)+minZ;
                int y = respawnWorld.getHighestBlockYAt(randX, randZ);
                e.getPlayer().teleport(new Location(respawnWorld, randX, y, randZ));
            }
        }
    }

    public static void sendJoinMessage(Player joined){
        for(Player p : Bukkit.getOnlinePlayers()){
            if(!ToggleJoinMessages.muted.contains(p)){
                Utils.sendRawMessage(p, Utils.getConfig().getString("join-messages.join").replaceAll("<player>", joined.getName()));
            }
        }
    }

    public void sendMotd(Player p){
        Utils.sendMessage(p, Utils.getConfig().getString("welcome-message.message").replaceAll("<player>", p.getName())
                .replaceAll("<connected>", Bukkit.getServer().getOnlinePlayers().size()+"")
                .replaceAll("<maxplayers>", Bukkit.getServer().getMaxPlayers()+""));
    }

    public void displayMotdMessage(Player p){
        int show = Utils.getConfig().getInt("welcome-message.show");
        switch(show){
            case 1:
                if(!p.hasPlayedBefore()){
                    sendMotd(p);
                }
                break;
            case 2:
                sendMotd(p);
                break;
        }
    }
}
