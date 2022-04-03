package de.nix.dreamvator.features;

import de.nix.dreamvator.Dreamvator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class WallClimb {

    private final Plugin plugin;

    public WallClimb(Plugin plugin) {
        this.plugin = plugin;

        start();
    }

    public void start() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> {
            if(Bukkit.getOnlinePlayers() == null || Bukkit.getOnlinePlayers().isEmpty())
                return;
            Bukkit.getOnlinePlayers().forEach(player -> {
                if(isPlayerOnWall(player)) {
                    player.setVelocity(player.getVelocity().setY(0.25));
                }
            });
        }, 0, 1);
    }

    public boolean isPlayerOnWall(Player player) {
        if(player.getLocation().add(1, 0, 0).getBlock().getType().equals(Material.WAXED_OXIDIZED_CUT_COPPER) ||
                player.getLocation().add(-1, 0, 0).getBlock().getType().equals(Material.WAXED_OXIDIZED_CUT_COPPER) ||
                player.getLocation().add(0, 0, 1).getBlock().getType().equals(Material.WAXED_OXIDIZED_CUT_COPPER) ||
                player.getLocation().add(0, 0, -1).getBlock().getType().equals(Material.WAXED_OXIDIZED_CUT_COPPER)) {
            return true;
        }

        return false;
    }
}
