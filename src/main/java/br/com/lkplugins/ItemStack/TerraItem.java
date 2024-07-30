package br.com.lkplugins.ItemStack;

import br.com.lkplugins.LkAddons;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TerraItem {

    public static ItemStack TerraItemStack(int quantidade) {

        ItemStack itemStack = new ItemStack(Material.DIRT, quantidade);
        ItemMeta TerraM = itemStack.getItemMeta();
        TerraM.setDisplayName(LkAddons.getInstance().getConfig().getString("terra.name").replace("&", "§"));
        ArrayList<String> TerraL = new ArrayList<>();
        for(String str : LkAddons.getInstance().getConfig().getStringList("terra.lore")) {
            TerraL.add(str.replace("&", "§"));
        }
        TerraM.setLore(TerraL);

        itemStack.setItemMeta(TerraM);
        return itemStack;
    }
}
