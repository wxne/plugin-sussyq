package pl.tripmc.testerplugin;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import pl.tripmc.testerplugin.commands.SkinCommand;
import pl.tripmc.testerplugin.listeners.PlayerMoveListener;

public final class TesterPlugin extends JavaPlugin {

    public static TesterPlugin testerPlugin;

    @Override
    public void onEnable() {
        testerPlugin = this;
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getCommand("skin").setExecutor((CommandExecutor) new SkinCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static TesterPlugin getTesterPlugin() {
        return testerPlugin;
    }
}
