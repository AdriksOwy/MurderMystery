package com.murder;

import com.murder.commands.CommandData;
import com.murder.commands.CommandRunner;
import com.murder.commands.CommandRunnerFactory;
import com.murder.events.MurderNPCEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Murder extends JavaPlugin {

    static JavaPlugin plugin;

    public static JavaPlugin getMainPlugin() {

        return plugin;
    }

    @Override
    public void onEnable() {

        plugin = this;
        getServer().getPluginManager().registerEvents(new MurderNPCEvent(), this);
        getLogger().info( ChatColor.AQUA + " [MurderMystery] Plugin is enable! " );
    }

    @Override
    public void onDisable() {

        getLogger().info(ChatColor.RED + " [MurderMystery] Plugin is disable! " );
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        try {
            CommandData data = new CommandData(sender, cmd, label, args);
            CommandRunner command = CommandRunnerFactory.create(data);
            return command.run();
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }
}
