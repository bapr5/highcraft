package org.bapr5.highcraft;

import org.bapr5.highcraft.commands.PlayerClasses;
import org.bapr5.highcraft.handlers.JoinHandler;
import org.bapr5.highcraft.handlers.XPhandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Highcraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("HIGHCRAFT initiated!~");
        //   getCommand("menu").setExecutor(new Menu(this));
        getCommand("classes").setExecutor(new PlayerClasses(this));
        new XPhandler(this);
        new JoinHandler(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("HIGHCRAFT shutting down! ///.///");
    }
}
