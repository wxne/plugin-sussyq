package pl.tripmc.testerplugin.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pl.tripmc.testerplugin.controller.SkinController;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (event.getTo().getBlockX() == event.getFrom().getBlockX() && event.getTo().getBlockZ() == event.getFrom().getBlockZ()) {
            return;
        }

        event.getTo().getBlock().setType(Material.STONE_BRICKS);
    }
}
