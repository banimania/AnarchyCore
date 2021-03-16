package com.danimania.anarchycore.commands;

import com.danimania.anarchycore.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class NameColorCommand implements CommandExecutor {

    public static HashMap<Player, String> customname = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission(Utils.getConfig().getString("permissions.nc"))){
            if(args.length == 0){
                Utils.sendMessage(p, Utils.getConfig().getString("nc-command.usage-message"));
            }else{
                String arg = args[0];
                // here goes the monkey code
                if(arg.equalsIgnoreCase("black")){
                    customname.put(p, "&f<&0"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "black"));
                }else if(arg.equalsIgnoreCase("darkblue")){
                    customname.put(p, "&f<&1"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "darkblue"));
                }else if(arg.equalsIgnoreCase("darkgreen")){
                    customname.put(p, "&f<&2"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "darkgreen"));
                }else if(arg.equalsIgnoreCase("darkaqua")){
                    customname.put(p, "&f<&3"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "darkaqua"));
                }else if(arg.equalsIgnoreCase("red")){
                    customname.put(p, "&f<&4"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "red"));
                }else if(arg.equalsIgnoreCase("darkpurple")){
                    customname.put(p, "&f<&5"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "darkpurple"));
                }else if(arg.equalsIgnoreCase("gold")){
                    customname.put(p, "&f<&6"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "gold"));
                }else if(arg.equalsIgnoreCase("gray")){
                    customname.put(p, "&f<&7"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "gray"));
                }else if(arg.equalsIgnoreCase("darkgray")){
                    customname.put(p, "&f<&8"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "darkgray"));
                }else if(arg.equalsIgnoreCase("blue")){
                    customname.put(p, "&f<&9"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "blue"));
                }else if(arg.equalsIgnoreCase("green")){
                    customname.put(p, "&f<&a"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "green"));
                }else if(arg.equalsIgnoreCase("aqua")){
                    customname.put(p, "&f<&b"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "aqua"));
                }else if(arg.equalsIgnoreCase("lightpurple")){
                    customname.put(p, "&f<&d"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "lightpurple"));
                }else if(arg.equalsIgnoreCase("yellow")){
                    customname.put(p, "&f<&e"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "yellow"));
                }else if(arg.equalsIgnoreCase("white")){
                    customname.put(p, "&f<&f"+p.getName()+"&f> ");
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "white"));
                }else if(arg.equalsIgnoreCase("reset")){
                    customname.remove(p);
                    Utils.sendMessage(p, Utils.getConfig().getString("nc-command.reset-message"));
                }else{
                    if(p.hasPermission(Utils.getConfig().getString("permissions.nc-format"))){
                        if(arg.equalsIgnoreCase("bold")){
                            customname.put(p, "&f<&l"+p.getName()+"&f> ");
                            Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "bold"));
                        }else if(arg.equalsIgnoreCase("magic")){
                            customname.put(p, "&f<&k"+p.getName()+"&f> ");
                            Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "magic"));
                        }else if(arg.equalsIgnoreCase("underline")){
                            customname.put(p, "&f<&n"+p.getName()+"&f> ");
                            Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "underline"));
                        }else if(arg.equalsIgnoreCase("strike")){
                            customname.put(p, "&m<&k"+p.getName()+"&f> ");
                            Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "strike"));
                        }else if(arg.equalsIgnoreCase("italic")){
                            customname.put(p, "&o<&k"+p.getName()+"&f> ");
                            Utils.sendMessage(p, Utils.getConfig().getString("nc-command.success-message").replaceAll("<color>", "italic"));
                        }else{
                            Utils.sendMessage(p, Utils.getConfig().getString("nc-command.error-message"));
                        }
                    }else{
                        Utils.sendMessage(p, Utils.getConfig().getString("global.no-permission-message"));
                    }
                }
            }
        }
        return true;
    }


}