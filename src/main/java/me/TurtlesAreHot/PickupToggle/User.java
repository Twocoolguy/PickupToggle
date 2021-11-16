package me.TurtlesAreHot.PickupToggle;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.*;

public class User {

    public static boolean hasPickup(Player p) {
        // Get the user data file
        File userData = new File(Main.getFolder(), "/userdata/" + p.getUniqueId().toString() + ".yml");
        if(!(userData.exists())) {
            // Since the player never used the pickup toggle command, they have to have pickup on.
            return true;
        }
        // Create config reader
        FileConfiguration userConfig = new YamlConfiguration();
        try {
            userConfig.load(userData);
        } catch(IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            return true;
        }
        // Check the value of the pickup data.
        return userConfig.getBoolean("pickup");

    }

    public static void setPickup(Player p, boolean state) {
        // Get the user data file
        File userData = new File(Main.getFolder(), "/userdata/" + p.getUniqueId().toString() + ".yml");
        if(!(userData.exists())) {
            // In the case that there is no userdata for this person set it.
            try {
                userData.createNewFile();
                PrintWriter pw = new PrintWriter(userData);
                pw.println("pickup: " + state);
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
                p.sendMessage(ChatColor.RED + "An error has occurred.");
                return;
            }
        } else {
            try {
                Writer fw = new FileWriter(userData, false);
                fw.write("pickup: " + state);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
                p.sendMessage(ChatColor.RED + "An error has occurred.");
                return;
            }
        }
        if (state) {
            // In the case that the state is set to true
            p.sendMessage(ChatColor.GREEN + "You have turned on item pickup!");
        } else {
            // In the case that the state is set to false
            p.sendMessage(ChatColor.RED + "You have turned off item pickup!");
        }

    }

}
