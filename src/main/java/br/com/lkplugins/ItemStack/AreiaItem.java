package br.com.lkplugins.ItemStack;

import br.com.lkplugins.LkAddons;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AreiaItem {

    public static ItemStack AreiaItemStack(int quantidade) {

        ItemStack itemStack = new ItemStack(Material.SAND, quantidade);
        ItemMeta AreiaM = itemStack.getItemMeta();
        AreiaM.setDisplayName(LkAddons.getInstance().getConfig().getString("areia.name").replace("&", "§"));
        ArrayList<String> AreiaL = new ArrayList<>();
        for(String str : LkAddons.getInstance().getConfig().getStringList("areia.lore")) {
            AreiaL.add(str.replace("&", "§"));
        }
        AreiaM.setLore(AreiaL);

        itemStack.setItemMeta(AreiaM);
        return itemStack;
    }

}
