package me.tezk.limitcrafting;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

/**
 * Created by Tom Micallef on 23/12/2015.
 */
public class LimitCraftingCommand implements CommandExecutor {

    private final LimitCrafting plugin;
    public LimitCraftingCommand(final LimitCrafting pl) {
        this.plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("limitcrafting")) {

            if (!(sender.hasPermission("limitcrafting.reload"))) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
                return true;
            }

            if (args.length == 1) {

                if (args[0].equalsIgnoreCase("reload")) {

                    plugin.reloadConfig();
                    plugin.updateConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfigReloadedMessage()));
                    return true;

                } else {
                    String wrongSyntax = ChatColor.translateAlternateColorCodes('&',
                            plugin.getIncorrectSyntaxMessage()).replace("%command%", "/limitcrafting reload");
                    sender.sendMessage(wrongSyntax);
                    return true;
                }

            } else {

                String wrongSyntax = ChatColor.translateAlternateColorCodes('&',
                        plugin.getIncorrectSyntaxMessage()).replace("%command%", "/limitcrafting reload");
                sender.sendMessage(wrongSyntax);
                return true;

            }

        }
        return true;
    }

}
