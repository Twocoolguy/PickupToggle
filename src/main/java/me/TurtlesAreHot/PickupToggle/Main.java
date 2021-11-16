package me.TurtlesAreHot.PickupToggle;

import me.TurtlesAreHot.PickupToggle.commands.Pickup;
import me.TurtlesAreHot.PickupToggle.events.onPickup;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {
    private static File dataFolder;

    @Override
    public void onEnable() {
        dataFolder = getDataFolder();
        createUserDataFolder();
        getServer().getPluginManager().registerEvents(new onPickup(), this);
        getCommand("pickup").setExecutor(new Pickup());
    }

    @Override
    public void onDisable() {

    }

    public static File getFolder() { return dataFolder; }

    private void createUserDataFolder() {
        File userdataFolder = new File(getDataFolder(), "/userdata/");
        if(!(userdataFolder.exists())) {
            userdataFolder.mkdirs();
        }
    }

}
