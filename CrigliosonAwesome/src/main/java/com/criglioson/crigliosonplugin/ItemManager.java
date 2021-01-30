package com.criglioson.crigliosonplugin;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class ItemManager {
    public static ItemStack oil;
    public static NamespacedKey key;
    public static CrigliosonPlugin plugin;
    public void ItemManager(NamespacedKey incomingKey){

    }
    public static void init(CrigliosonPlugin incomingKey){ // Call this to create all the items on plugin load
        plugin = incomingKey;
        key = new NamespacedKey(incomingKey, incomingKey.getName());
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
        ShapedRecipe vileRecipe = new ShapedRecipe(key, oilVile);
       vileRecipe.shape("*%*","%B%","*%*");
       vileRecipe.setIngredient('*', Material.FEATHER);
       vileRecipe.setIngredient('%', Material.GLOWSTONE_DUST);
       vileRecipe.setIngredient('B', Material.HONEY_BOTTLE);
       plugin.getServer().addRecipe(vileRecipe);
    }
}
