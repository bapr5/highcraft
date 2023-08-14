package org.bapr5.highcraft;

import org.bapr5.highcraft.commands.Menu;
import org.bapr5.highcraft.handlers.XPhandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Highcraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("HIGHCRAFT initiated!~");
        getCommand("menu").setExecutor(new Menu(this));
        new XPhandler(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("HIGHCRAFT shutting down! ///.///");
    }
}
