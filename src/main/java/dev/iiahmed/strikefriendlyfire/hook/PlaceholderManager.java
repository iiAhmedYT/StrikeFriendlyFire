package dev.iiahmed.strikefriendlyfire.hook;

import dev.iiahmed.strikefriendlyfire.StrikeFriendlyFire;
import ga.strikepractice.StrikePractice;
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
            return "";
        if(identifier.equalsIgnoreCase("friendly")){
            if(StrikeFriendlyFire.getInstance().isFrindly(one, two)){
                return StrikePractice.getInstance().getConfig().getString("team1-prefix");
            }
        }
        return "";
    }
}
