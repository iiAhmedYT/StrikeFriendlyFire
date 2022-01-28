package dev.iiahmed.strikefriendlyfire.listener;

import dev.iiahmed.strikefriendlyfire.StrikeFriendlyFire;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void damageEvent(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player player = (Player) event.getEntity();
            Player damager = (Player) event.getDamager();
            if (StrikeFriendlyFire.getInstance().isFrindly(player, damager)) {
                event.setCancelled(true);
            }
        }
    }


}
