package org.bapr5.highcraft.handlers;

import org.bapr5.highcraft.Highcraft;
import org.bapr5.highcraft.db.Database;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinHandler implements Listener {
    public JoinHandler(Highcraft plugin){
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }
    @EventHandler
    public void OnPlayerJoined( PlayerJoinEvent event){
    if(!event.getPlayer().hasPlayedBefore()){
        String player = event.getPlayer().getName();
        Integer XP = 0;
        Database db = new Database();
        Bukkit.getLogger().info("Got new player "+player+", set XP to 0");
        db.SavePlayerXP(player,XP);
    }
    }
}
