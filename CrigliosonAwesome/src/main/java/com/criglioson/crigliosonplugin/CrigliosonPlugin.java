package com.criglioson.crigliosonplugin;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.lang.*;
import java.util.*;
/* TODO: Ideas
    2 Person Horse
    Custom Potions / Effect:
        Frost Walker Arrow
        **Obsidian Walker**
        Slippery Arrows
        Rage enchant
        Team buffs
        Charm Potion
    Summon team mobs
    Bosses (Hard mode)
    Healthbars (Also hard mode)
    Tame Dolphins

*
* */
public final class CrigliosonPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("The plugin is loaded!");
        getServer().getPluginManager().registerEvents(this, this);

        ItemManager.init();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("The plugin is unloaded!");

    }

    //
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        event.getPlayer().getInventory().addItem(ItemManager.oil);
        if (event.isSneaking()) {
            lavaWalk(event.getPlayer());
        }
    }

    //If only one person is on the horse, a second person can ride it as well
    @EventHandler
    public void joinHorse(PlayerInteractEntityEvent rightClickedHorse){
        if(rightClickedHorse.getRightClicked().getType().equals(EntityType.HORSE)) {
            if (rightClickedHorse.getRightClicked().getPassengers().size() < 2) {
                rightClickedHorse.getRightClicked().addPassenger(rightClickedHorse.getPlayer());
            }
        }
    }

    //Custom Function
    public void lavaWalk(Player player){

        Location sneakLoc = player.getLocation();
        Location tempLoc = new Location(sneakLoc.getWorld(), sneakLoc.getX(), sneakLoc.getY()-1, sneakLoc.getZ());
        int radius = 3;
        Location[] blocksToChange = new Location[(radius * 2) + 1];
        if(tempLoc.getBlock().getType() != Material.AIR) {
            int count = 0;
            tempLoc.setX(tempLoc.getX() - radius);
            tempLoc.setZ(tempLoc.getZ() + radius);
            for (int x = 0; x < radius * 2; x++) {
                tempLoc.setX(tempLoc.getX() + x);
                for (int z = 0; z < radius * 2; z++) {
                    tempLoc.setZ(tempLoc.getZ() + z);
                    if (tempLoc.getBlock().getType() != Material.AIR && tempLoc.getBlock().getType() != Material.OBSIDIAN) {
                        blocksToChange[count] = tempLoc;
                        count++;
                    }
                }
            }
        }
        for (Location block : blocksToChange) {
            block.getBlock().setType(Material.OBSIDIAN);
        }
    }










//            if (tempLoc.getBlock().getType() != Material.AIR) {
//
//                //Straight lines
//
//                // X direction
//                tempLoc.setX(sneakLoc.getBlockX()-radius);
//                for (int i = 0; i < radius*2; i++) {
//                    tempLoc.setX(tempLoc.getX() + i);
//                    if (tempLoc.getBlock().getType() != Material.AIR) {
//                        tempLoc.getBlock().setType(Material.OBSIDIAN);
//                    }
//                }
//                tempLoc.setX(sneakLoc.getBlockX());
//
//                //Y direction
//                tempLoc.setZ(sneakLoc.getBlockZ()-radius);
//                for (int i = 0; i < radius*2; i++) {
//                    tempLoc.setZ(sneakLoc.getBlockZ() + i);
//                    if (tempLoc.getBlock().getType() != Material.AIR) {
//                        tempLoc.getBlock().setType(Material.OBSIDIAN);
//                    }
//                }
//                tempLoc.setZ(sneakLoc.getBlockZ());
//                //Diagonals
//
//                //Positive
//                tempLoc.setX(sneakLoc.getBlockX()-radius);
//                tempLoc.setZ(sneakLoc.getBlockZ()-radius);
//                for (int i = 0; i < (radius*2)-1; i++) {
//                    tempLoc.setZ(sneakLoc.getBlockZ() + i);
//                    tempLoc.setX(sneakLoc.getBlockX() + i);
//                    if (tempLoc.getBlock().getType() != Material.AIR) {
//                        tempLoc.getBlock().setType(Material.OBSIDIAN);
//                    }
//                }
//
//                //Negative
//                tempLoc.setZ(sneakLoc.getBlockZ()-(radius*2));
//                tempLoc.setX(sneakLoc.getBlockX()-(radius*2));
//                for (int i = 0; i < (radius*2)-1; i++) {
//                    tempLoc.setZ(sneakLoc.getBlockZ() - i);
//                    tempLoc.setX(sneakLoc.getBlockX() - i);
//                    if (tempLoc.getBlock().getType() != Material.AIR) {
//                        tempLoc.getBlock().setType(Material.OBSIDIAN);
//                    }
//                }
//
//                //In-between blocks
//
//            }
//        }
//    }
}

/*
HALL OF PAST IDEAS


    // Lightning on bow hitting a block
    @EventHandler
    public void onBlockHit(ProjectileHitEvent didHit){
        if(didHit.getHitBlock() != null){
            Location hitBlock = didHit.getHitBlock().getLocation();
            hitBlock.getWorld().strikeLightning(hitBlock);
        }
    }
}
// set health to half heart on leaving bed
@EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event){
        Player player = event.getPlayer();
        player.setHealth(0.5);
    }

*/

