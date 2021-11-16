package me.TurtlesAreHot.PickupToggle.events;

import me.TurtlesAreHot.PickupToggle.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class onPickup implements Listener {

    @EventHandler
    public void onItemPickUp(EntityPickupItemEvent e) {
        if(e.getEntity() instanceof Player) {
            if(!(User.hasPickup((Player) e.getEntity()))) {
                e.setCancelled(true);
            }
        }
    }
}
