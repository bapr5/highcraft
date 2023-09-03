package org.bapr5.highcraft.handlers;
import org.bapr5.highcraft.Highcraft;
import org.bapr5.highcraft.db.Database;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;



public class XPhandler implements Listener{
    public XPhandler(Highcraft plugin){
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }
    @EventHandler
    public void OnXpGain(PlayerExpChangeEvent event){
        String player = event.getPlayer().getName();
        Integer XP = event.getAmount();
        Database db = new Database();
      //  Bukkit.getLogger().info("got XP "+player+" "+XP.toString());
        db.savePlayerXP(player,XP);
    }
}
