package com.danimania.anarchycore;

import com.danimania.anarchycore.commands.*;
import com.danimania.anarchycore.events.*;
import com.danimania.anarchycore.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AnarchyCore extends JavaPlugin {

    public void onEnable() {
        saveDefaultConfig();
        registerCommands();
        registerEvents();
        Bukkit.getLogger().info("AnarchyCore by danimania loaded succesfully");
    }

    public void registerEvents(){
        Bukkit.getServer().getPluginManager().registerEvents(new MoveEvents(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new CommandEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DispenserEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BlockPlaceEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerInteractWithEntityEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PistonEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ChatEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new RespawnEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MotdEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerDealDamageEvent(), this);
    }

    public void registerCommands(){
        if(Utils.getConfig().getBoolean("enabled-commands.help")){
            this.getCommand("help").setExecutor(new HelpCommand());
        }
        if(Utils.getConfig().getBoolean("enabled-commands.bed")){
            this.getCommand("bed").setExecutor(new BedCommand());
        }
        if(Utils.getConfig().getBoolean("enabled-commands.discord")){
            this.getCommand("discord").setExecutor(new DiscordCommand());
        }
        if(Utils.getConfig().getBoolean("enabled-commands.stats")){
            this.getCommand("stats").setExecutor(new InfoCommand());
        }
        if(Utils.getConfig().getBoolean("enabled-commands.joindate")){
            this.getCommand("joindate").setExecutor(new JoindateCommand());
        }
        if(Utils.getConfig().getBoolean("enabled-commands.ping")){
            this.getCommand("ping").setExecutor(new PingCommand());
        }
        if(Utils.getConfig().getBoolean("enabled-commands.toggledeathmsgs")){
            this.getCommand("toggledeathmsgs").setExecutor(new ToggleDeathMsgsCommand());
        }
        if(Utils.getConfig().getBoolean("enabled-commands.togglejoinmsgs")){
            this.getCommand("togglejoinmsgs").setExecutor(new ToggleJoinMessages());
        }
        if(Utils.getConfig().getBoolean("enabled-commands.corereload")){
            this.getCommand("corereload").setExecutor(new CoreReloadCommand());
        }
        if(Utils.getConfig().getBoolean("enabled-commands.kill")){
            this.getCommand("kill").setExecutor(new KillCommand());
        }
        if(Utils.getConfig().getBoolean("enabled-commands.nc")){
            this.getCommand("nc").setExecutor(new NameColorCommand());
        }
    }

    public static AnarchyCore getPlugin(){
        return getPlugin(AnarchyCore.class);
    }
}
