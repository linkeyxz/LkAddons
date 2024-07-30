package br.com.lkplugins;

import br.com.lkplugins.Commands.GiveCommand;
import br.com.lkplugins.Listeners.AreiaListener;
import br.com.lkplugins.Listeners.TerraListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LkAddons extends JavaPlugin {

    public static LkAddons getInstance(){
        return getPlugin(LkAddons.class);
    }

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage("§a[LkAddons] Iniciando...");
        saveDefaultConfig();
        Eventos();
        Commands();
        Bukkit.getConsoleSender().sendMessage("§a[LkAddons] Iniciado com sucesso");

    }

    @Override
    public void onDisable() {

    }

    void Eventos(){
        Bukkit.getPluginManager().registerEvents(new AreiaListener(), this);
        Bukkit.getPluginManager().registerEvents(new TerraListener(), this);
    }

    void Commands(){
        this.getCommand("addon").setExecutor(new GiveCommand());
    }
}
