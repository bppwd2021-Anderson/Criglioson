package com.criglioson.crigliosonplugin;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class ItemManager {
    public static ItemStack oil;
    public static void init(){ // Call this to create all the items on plugin load
        createOil();
    }
    private static void createOil(){
        // Code for the item itself
        ItemStack oilVile = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta)oilVile.getItemMeta();
        meta.setColor(Color.WHITE);
        meta.setDisplayName("Vile of Oil");
        meta.addCustomEffect(new PotionEffect(PotionEffectType.LEVITATION, 400 , 1), true);
        oilVile.setItemMeta(meta);
        oil = oilVile;
        // Code for the recipe
////    NamespacedKey key = new NamespacedKey(Plugin)
//        ShapedRecipe vileRecipe = new ShapedRecipe(null,oilVile);
//        vileRecipe.shape("*%*","%B%","*%*");
//        vileRecipe.setIngredient('*', Material.FEATHER);
//        vileRecipe.setIngredient('%', Material.GLOWSTONE_DUST);
//        vileRecipe.setIngredient('B', Material.HONEY_BOTTLE);
//        getServer().addRecipe(vileRecipe);
    }
}
