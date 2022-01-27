package dev.iiahmed.strikefriendlyfire;

import dev.iiahmed.strikefriendlyfire.hook.PlaceholderManager;
import dev.iiahmed.strikefriendlyfire.listener.PlayerListener;
import lombok.Getter;
import org.bukkit.Bukkit;
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

}
