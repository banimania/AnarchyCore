package com.danimania.anarchycore.utils;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class IllegalUtils {

    public static void checkPlayerIllegals(Player p){
        for(ItemStack i : p.getInventory().getContents()){
            checkIllegals(i);
        }
    }

    public static void checkIllegals(ItemStack item){

        if(item.getAmount()>item.getMaxStackSize()){
            item.setAmount(item.getMaxStackSize());
        }

        for(Enchantment ench : item.getEnchantments().keySet()){
            if(item.getEnchantmentLevel(ench)>ench.getMaxLevel()){
                item.addEnchantment(ench, ench.getMaxLevel());
            }
        }

        switch(item.getType()){
            case COMMAND:
                item.setAmount(0);
                break;
            case MOB_SPAWNER:
                item.setAmount(0);
                break;
            case BARRIER:
                item.setAmount(0);
                break;
            case BEDROCK:
                item.setAmount(0);
                break;
        }
    }

}
