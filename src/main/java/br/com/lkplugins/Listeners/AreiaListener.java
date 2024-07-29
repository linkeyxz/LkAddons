package br.com.lkplugins.Listeners;

import br.com.lkplugins.ItemStack.AreiaItem;
import br.com.lkplugins.LkAddons;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class AreiaListener implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();

            if(p.getInventory().getItemInHand().isSimilar(AreiaItem.AreiaItemStack(1))) {
                if(p.getInventory().getItemInHand().getAmount() < 64) {
                    p.getInventory().addItem(AreiaItem.AreiaItemStack(1));
                }
            }
    }
}
