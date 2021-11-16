package me.TurtlesAreHot.PickupToggle.commands;

import me.TurtlesAreHot.PickupToggle.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pickup implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            Bukkit.getLogger().info("Only players can run this command.");
            return false;
        }
        Player p = (Player) sender;
        if(args.length == 0) {
            User.setPickup(p, !(User.hasPickup(p)));
        } else {
            if(args[0].equalsIgnoreCase("on") || args[0].equalsIgnoreCase("true")) {
                User.setPickup(p, true);
            } else if(args[0].equalsIgnoreCase("off") || args[0].equalsIgnoreCase("false")) {
                User.setPickup(p, false);
            } else {
                p.sendMessage(ChatColor.DARK_RED + "Invalid arguments for this command. Either type /pickup on or /pickup off");
            }
        }
        return false;
    }
}
