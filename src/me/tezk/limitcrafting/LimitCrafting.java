package me.tezk.limitcrafting;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Set;

/**
 * Created by Tom Micallef on 23/12/2015.
 */
public class LimitCrafting extends JavaPlugin {

    private boolean enabled;
    private String configReloaded;
    private String incorrectSyntax;
    private String message;
    private boolean blockAllItems;
    private List<String> materialList;
    private Boolean enableGroups;
    private Set<String> groupNames;

    @Override
    public void onEnable() {
        updateConfig();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerCraftListener(this), this);
        getCommand("limitcrafting").setExecutor(new LimitCraftingCommand(this));
    }

    public void updateConfig() {
        enabled = getConfig().getBoolean("limitcrafting.enabled");
        configReloaded = getConfig().getString("limitcrafting.config-reloaded");
        incorrectSyntax = getConfig().getString("limitcrafting.incorrect-syntax");
        message = getConfig().getString("limitcrafting.message");
        blockAllItems = getConfig().getBoolean("limitcrafting.block-all-items");
        materialList = getConfig().getStringList("limitcrafting.default-block-list");
        enableGroups = getConfig().getBoolean("limitcrafting.enable-groups");
        groupNames = getConfig().getConfigurationSection("limitcrafting.groups").getKeys(false);
    }

    public boolean isLCEnabled() {
        return enabled;
    }

    public String getConfigReloadedMessage() {
        return configReloaded;
    }

    public String getIncorrectSyntaxMessage() {
        return incorrectSyntax;
    }

    public String getNotPermittedToCraftMessage() {
        return message;
    }

    public boolean isBlockAllItemsEnabled() {
        return blockAllItems;
    }

    public List<String> getDefaultBlockList() {
        return materialList;
    }

    public boolean isGroupsEnabled() {
        return enableGroups;
    }

    public Set<String> getGroupNames() {
        return groupNames;
    }

    public List<String> getGroupMaterials(String groupName) {
        return getConfig().getStringList("limitcrafting.groups." + groupName);
    }



}
