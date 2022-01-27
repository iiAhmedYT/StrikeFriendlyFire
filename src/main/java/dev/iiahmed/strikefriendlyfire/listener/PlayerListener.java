package dev.iiahmed.strikefriendlyfire.listener;

import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import ga.strikepractice.fights.Fight;
import ga.strikepractice.party.Party;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void damageEvent(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player player = (Player) event.getEntity();
            StrikePracticeAPI api = StrikePractice.getAPI();
            if(!api.isInFight(player)) return;
            if(api.getParty(player) == null) return;
            Fight fight = api.getFight(player);
            Party party = api.getParty(player);
            if(fight == null) return;
            if(fight.getArena() == null) return;
            if(api.getFight(player).getArena().isFFA()){
                Player damager = (Player) event.getDamager();
                if(party.getPlayers().contains(damager)){
                    event.setCancelled(true);
                }
            }
        }
    }


}
