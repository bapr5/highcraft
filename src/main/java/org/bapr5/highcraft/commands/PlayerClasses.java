package org.bapr5.highcraft.commands;

import org.bapr5.highcraft.Highcraft;
import org.bapr5.highcraft.libs.SkullCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
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
import org.bukkit.inventory.meta.SkullMeta;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//import sun.jvm.hotspot.ui.tree.CStringTreeNodeAdapter;

public class PlayerClasses implements CommandExecutor,Listener {
    public PlayerClasses(Highcraft plugin){
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }
    String invName="[pick your class]";
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(!event.getView().getTitle().equals(invName)){
            return;
        }
        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();
        event.setCancelled(true);
      //  Bukkit.getLogger().info("CANCELLING");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){

        if(!(sender instanceof Player)){
            sender.sendMessage("HIGHCRAFT menu is only available to PLAYERS, not CONSOLES!");
        }
        else {
            Player player = (Player) sender;
            Inventory inv = Bukkit.createInventory(player, 9 * 3, invName);
            inv.setItem(9, getHead( "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDJhZDQ5Yzc0YTdjZGY3NTEzOTVmMmVlNjRiNWMyZDhjZjMyNmE0YzA1MzRlNzZlMzhmNzMzZTQ0YTcwODRkOCJ9fX0=", "§rKnight","§rKnight specializes in defensive melee combat.","§oFor every scar I've received, I've given ten back."));
            inv.setItem(10, getHead( "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRjZGFlNjFlYTg2YjEyNjI0N2ZjNWM5MjY4NWI1NzU1ODA5YTVkYTBlMjRmYmEyYjJhMGM2NDdiMDkwOWRhMSJ9fX0=", "§rBarbarian","§rBarbarian specializes in aggressive melee combat.","§oSo I drink and fight and feast and die."));
            inv.setItem(11, getHead( "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODQ1ZDcxZjM3MjU5NDBiMGE0YjQyYTU3ZGU2N2IxYjMyOTI4Y2RiZTA5N2E0OTkwNTM5ODgyMmIyMmQ5Y2ZiNyJ9fX0=", "§rThief","§rThief specializes in stealth operations and agile melee combat.","§oI see the world as a gift meant for me."));
            inv.setItem(12, getHead( "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDk1MzllNDYyZGY1ODQ2ZTgxYWZkOGY5ZDk0NDIzOWJiOWZhM2RkNGM4ODc3OGE2NTY2MmVjZjZmNTZhIn19fQ==", "§rRanger","§rRanger specializes in ranged combat and exploring.","§oNot all paths are found on the forest floor."));
            inv.setItem(13, getHead( "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODJmMWQ1NDNlOWEwOGJhZDVkMzYxMjYyMzdiMTllOGMxZWZiYjNiOGFiODU0YWI0MjIwNGE3YjBkZWQzMzA1MSJ9fX0=", "§rCrafter","§rCrafter specializes in making useful items and unique inventions.","§oMy armor transcends the limitations of mere flesh and bone."));
            inv.setItem(14, getHead( "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM4M2QyYjAzZWI2Nzg1NzA5YWRjMDlhZjNlMTQ1ZTgzMjQ1ODRiMDlmZWUwNzk4ZjFlMmYzZDNhOGM3Y2ZhIn19fQ==", "§rWizard","§rWizard specializes in mastering long forgotten sorcery skills.","§oThe law has its place -- as a footnote in my spellbook."));
            player.openInventory(inv);
        }
        return true;
    }
    private ItemStack getHead(String base64, String name, String ... lore){
        ItemStack head = SkullCreator.itemFromBase64(base64);
        ItemMeta headmeta = head.getItemMeta();
        headmeta.setDisplayName(name);
        List<String> lores = new ArrayList<>();
        for(String s: lore)
        {
            lores.add(s);
        }
        headmeta.setLore(lores);
        head.setItemMeta(headmeta);
        return head;

    }
}
