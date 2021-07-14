package com.danimania.anarchycore.utils;

import io.papermc.paper.inventory.ItemRarity;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class IllegalUtils {

    public static boolean isIllegal(ItemStack i){

        for(Enchantment ench : i.getEnchantments().keySet()){
            if(ench.getMaxLevel() > i.getEnchantmentLevel(ench)){
                return true;
            }
        }

        if(i.getAmount() > i.getMaxStackSize()){
            return true;
        }

        if(i.getMaxItemUseDuration() < i.getDurability()){
            return true;
        }

        if(i.getType().equals(Material.FIREWORK_ROCKET)){
            if(i.getItemMeta() instanceof FireworkMeta){
                FireworkMeta fireworkMeta = (FireworkMeta) i.getItemMeta();
                if(fireworkMeta.getPower()>3 || fireworkMeta.getPower()<1){
                    return true;
                }
            }
        }

        return false;

    }

}
