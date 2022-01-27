package dev.iiahmed.strikefriendlyfire.hook;

import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import ga.strikepractice.fights.Fight;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.clip.placeholderapi.expansion.Relational;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlaceholderManager extends PlaceholderExpansion implements Relational {
    @Override
    public @NotNull String getIdentifier() {
        return "StrikeFF";
    }

    @Override
    public @NotNull String getAuthor() {
        return "iiAhmedYT";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player one, Player two, String identifier) {
        if(one == null || two == null)
            return null;
        if(identifier.equalsIgnoreCase("friendly")){
            StrikePracticeAPI api = StrikePractice.getAPI();
            Fight firstFight = api.getFight(one);
            Fight secondFight= api.getFight(two);
            if(firstFight != null && firstFight.equals(secondFight)){
                if(firstFight.getArena() != null && firstFight.getArena().isFFA()){
                    if(api.getParty(one) != null && api.getParty(one).getPlayers().contains(two)){
                        return StrikePractice.getInstance().getConfig().getString("team1-prefix");
                    }
                }
            }
        }
        return null;
    }
}
