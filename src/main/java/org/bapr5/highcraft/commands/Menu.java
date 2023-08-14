package org.bapr5.highcraft.commands;

import org.bapr5.highcraft.Highcraft;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
//import sun.jvm.hotspot.ui.tree.CStringTreeNodeAdapter;

import java.util.ArrayList;
import java.util.List;

public class Menu implements CommandExecutor,Listener {
    private String invName="[server menu]";
    public Menu(Highcraft plugin){
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(!event.getView().getTitle().equals(invName)){
            return;
        }
        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();
        event.setCancelled(true);
        Bukkit.getLogger().info("CANCELLING");
    }
    @Override
    public boolean onCommand(CommandSender sender,Command command, String label, String [] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("HIGHCRAFT menu is only available to PLAYERS, not CONSOLES!");
        }
        else {
            Player player = (Player) sender;
            Inventory inv = Bukkit.createInventory(player, 9 * 3, invName);
            inv.setItem(11, getItem(new ItemStack(Material.PLAYER_HEAD), "Me", "Check your class settings"));
            inv.setItem(13, getItem(new ItemStack(Material.IRON_PICKAXE), "", "Go to your island!"));
            inv.setItem(15, getItem(new ItemStack(Material.GRASS_BLOCK), "Profile settings", "Check my profile settings"));
            player.openInventory(inv);
        }
        return true;
    }
    private ItemStack getItem(ItemStack item, String name, String ... lore){
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        List<String> lores = new ArrayList<>();
        for(String s: lore)
        {
            lores.add(s);
        }
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }
}
