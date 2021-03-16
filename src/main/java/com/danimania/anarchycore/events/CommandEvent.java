package com.danimania.anarchycore.events;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandEvent implements Listener {
    @EventHandler
    public void onCommandPreProcess(PlayerCommandPreprocessEvent e){
        Player p = e.getPlayer();
        if(Utils.getConfig().getBoolean("command-whitelist.enabled")){
            if (!p.hasPermission(Utils.getConfig().getString("permissions.bypass-whitelist"))) {
                String msg = e.getMessage().toLowerCase();
                if (!Utils.getConfig().getStringList("command-whitelist.whitelisted-commands").contains(msg.split(" ")[0].replace("/", ""))) {
                    Utils.sendRawMessage(p, Utils.getConfig().getString("command-whitelist.whitelist-message"));
                    e.setCancelled(true);
                }
            }
        }
    }
}
