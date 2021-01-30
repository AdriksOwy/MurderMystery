package com.murder.objects;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

public class spawnNPC {
    public void spawnMurderVillager(World world, Location location){
        Villager villager = (Villager) world.spawnEntity(location, EntityType.VILLAGER);
        villager.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "> KLIKNIJ PRZYCISK <");
        villager.setAI(false);
    }
}
