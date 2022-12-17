package me.tezk.limitcrafting;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom Micallef on 23/12/2015.
 */
public class PlayerCraftListener implements Listener {

    private final LimitCrafting plugin;
    public PlayerCraftListener(final LimitCrafting pl) {
        this.plugin = pl;
    }

    @EventHandler
    public void onPlayerCraft(CraftItemEvent event) {
        if (event.getWhoClicked().hasPermission("limitcrafting.bypass") || !plugin.isLCEnabled()) return;
        if (plugin.isBlockAllItemsEnabled()) {
            event.setCancelled(true);
            String msg = ChatColor.translateAlternateColorCodes('&', plugin.getNotPermittedToCraftMessage())
                    .replace("%item%", event.getCurrentItem().getType().name().toLowerCase());
            event.getWhoClicked().sendMessage(msg);
            return;
        }

        List<Material> materialList = new ArrayList<>();

        for (String mat : plugin.getDefaultBlockList()) {
            try {
                materialList.add(Material.valueOf(mat));
            } catch (Exception e) {
                plugin.getLogger().info("Material list in configuration contains a value that is not recognised. " +
                        "Make sure you're using values from https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html.");
                return;
            }
        }
        for (Material indMat : materialList) {
            if (event.getCurrentItem().getType() == indMat) {
                String msg = ChatColor.translateAlternateColorCodes('&', plugin.getNotPermittedToCraftMessage())
                        .replace("%item%", event.getCurrentItem().getType().name().toLowerCase());
                event.setCancelled(true);
                event.getWhoClicked().sendMessage(msg);
            }
        }

        if (!(plugin.isGroupsEnabled())) {
            return;
        }
        for (String group : plugin.getGroupNames()) {
            if (event.getWhoClicked().hasPermission("limitcrafting.groups." + group)) {

                List<Material> matGroupList = new ArrayList<>();

                for (String mat : plugin.getGroupMaterials(group)) {
                    try {
                        matGroupList.add(Material.valueOf(mat));
                    } catch (Exception e) {
                        plugin.getLogger().info("Material list in group " + group + " in configuration contains a value that is not recognised. " +
                                "Make sure you're using values from https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html.");
                        return;
                    }
                }
                for (Material inMat : matGroupList) {
                    if (event.getCurrentItem().getType() == inMat) {
                        String msg = ChatColor.translateAlternateColorCodes('&', plugin.getNotPermittedToCraftMessage())
                                .replace("%item%", event.getCurrentItem().getType().name().toLowerCase());
                        event.setCancelled(true);
                        event.getWhoClicked().sendMessage(msg);
                    }
                }
            }
        }
    }
}
