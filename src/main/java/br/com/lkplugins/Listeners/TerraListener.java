package br.com.lkplugins.Listeners;

import br.com.lkplugins.ItemStack.TerraItem;
import br.com.lkplugins.LkAddons;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class TerraListener implements Listener {
        @EventHandler
        public void onPlace(BlockPlaceEvent e) {
            Block b = e.getBlock();
            Player p = e.getPlayer();

            if(p.getInventory().getItemInHand().isSimilar(TerraItem.TerraItemStack(1))) {
                b.setType(Material.SOIL);
                if(p.getItemInHand().getAmount() < 64) {
                    p.getInventory().addItem(TerraItem.TerraItemStack(1));
                }
            }

        }

    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        Block block = event.getBlock();
        if (block.getType() == Material.SOIL) {
            if (!isNearWater(block)) {
                event.setCancelled(true);
            }
        }
    }

    private boolean isNearWater(Block block) {
        int radius = 4; // Raio de 4 blocos para procurar água
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                for (int y = -1; y <= 1; y++) {
                    if (block.getRelative(x, y, z).getType() == Material.WATER) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}