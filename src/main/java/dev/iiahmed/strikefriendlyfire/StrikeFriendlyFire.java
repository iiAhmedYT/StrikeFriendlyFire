package dev.iiahmed.strikefriendlyfire;

import dev.iiahmed.strikefriendlyfire.hook.PlaceholderManager;
import dev.iiahmed.strikefriendlyfire.listener.PlayerListener;
import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import ga.strikepractice.fights.Fight;
import ga.strikepractice.party.Party;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class StrikeFriendlyFire extends JavaPlugin {

    @Getter private static StrikeFriendlyFire instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        new PlaceholderManager().register();
    }

    public boolean isFriendly(Player one, Player two){
        StrikePracticeAPI api = StrikePractice.getAPI();
        if(!api.isInFight(one) || api.isInFight(two)) return false;
        Fight firstFight = api.getFight(one);
        Fight secondFight= api.getFight(two);
        if(firstFight == null) return false;
        if(!firstFight.equals(secondFight)) return false;
        boolean ffa = firstFight.getArena().isFFA();
        if(!ffa) return false;
        Party party = api.getParty(one);
        if(party == null) return false;
        return party.getPlayers().contains(two);
    }

}
