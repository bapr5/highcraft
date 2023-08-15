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
import org.bukkit.event.Listener;
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

    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){
        String invName="[выбирай свой класс]";
        if(!(sender instanceof Player)){
            sender.sendMessage("HIGHCRAFT menu is only available to PLAYERS, not CONSOLES!");
        }
        else {
            Player player = (Player) sender;
            Inventory inv = Bukkit.createInventory(player, 9 * 3, invName);
            inv.setItem(9, getHead( "", "Gnome"));
            inv.setItem(26, getHead( "", "Go to your island!"));
            inv.setItem(25, getHead( "", "Check my profile settings"));
            player.openInventory(inv);
        }
        return true;
    }
    private ItemStack getHead(String player, String name, String ... lore){
        ItemStack head = SkullCreator.itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDJhZDQ5Yzc0YTdjZGY3NTEzOTVmMmVlNjRiNWMyZDhjZjMyNmE0YzA1MzRlNzZlMzhmNzMzZTQ0YTcwODRkOCJ9fX0=");
        ItemMeta headmeta = head.getItemMeta();
        headmeta.setDisplayName(name);
        List<String> lores = new ArrayList<>();
        for(String s: lore)
        {
            lores.add(s);
        }
        headmeta.setLore(lores);
        head.setItemMeta(headmeta);
        /*
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        UUID playerid = UUID.fromString("f121aea189344ade9d6e7a1dfd8dd638");
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(playerid));

        ItemMeta headmeta = head.getItemMeta();
        headmeta.setDisplayName(name);

        List<String> lores = new ArrayList<>();
        for(String s: lore)
        {
            lores.add(s);
        }
        headmeta.setLore(lores);
        headmeta.
eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM4M2QyYjAzZWI2Nzg1NzA5YWRjMDlhZjNlMTQ1ZTgzMjQ1ODRiMDlmZWUwNzk4ZjFlMmYzZDNhOGM3Y2ZhIn19fQ==
                GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", url));


        head.setItemMeta(skullMeta);

         */
        return head;

    }
}
