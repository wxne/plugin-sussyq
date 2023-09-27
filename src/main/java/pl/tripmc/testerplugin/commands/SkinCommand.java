package pl.tripmc.testerplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.tripmc.testerplugin.controller.SkinController;

public class SkinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 0) {
            Player player = (Player) sender;
            SkinController.isChangeSkin(player);
            return false;
        }
        return false;
    }
}
