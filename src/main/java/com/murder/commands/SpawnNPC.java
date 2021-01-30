package com.murder.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

public class SpawnNPC {
    World world;
    Location location;
    public SpawnNPC(World world, Location location) {
        this.world = world;
        this.location = location;
    }
    public void spawnMurderVillager(){
        Villager villager = (Villager) world.spawnEntity(location, EntityType.VILLAGER);
        villager.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "> KLIKNIJ PRZYCISK <");
        villager.setAI(false);
    }
}
