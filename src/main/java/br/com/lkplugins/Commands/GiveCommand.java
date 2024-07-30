package br.com.lkplugins.Commands;

import br.com.lkplugins.ItemStack.AreiaItem;
import br.com.lkplugins.ItemStack.TerraItem;
import br.com.lkplugins.LkAddons;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        Player p = (Player) sender;

      if(p.hasPermission(LkAddons.getInstance().getConfig().getString("permissao.give"))) {
          if (cmd.getName().equalsIgnoreCase("addon")) {
              if (args.length == 0) {
                  p.sendMessage("§c§lERRO! §fArgumentos invalidos. use /addon give <jogador> <tipo> <quantia>");
              }

              if (args.length == 1) {
                  if (args[0].equalsIgnoreCase("give")) {
                      p.sendMessage("§c§lERRO! §fArgumentos invalidos. use /addon give <jogador> <tipo> <quantia>");
                  }
              }

              if (args.length == 2) {
                  if (args[0].equalsIgnoreCase("give")) {
                      String player = args[1];
                      Player target = Bukkit.getPlayerExact(player);
                      p.sendMessage("§c§lERRO! §fArgumentos invalidos. use /addon give <jogador> <tipo> <quantia>");

                      if (target == null) {
                          p.sendMessage("§c§lERRO! §fJogador invalido.");
                          return true;
                      }
                  }
              }

              if (args.length == 3) {
                  if (args[0].equalsIgnoreCase("give")) {
                      String player = args[1];
                      Player target = Bukkit.getPlayerExact(player);

                      if (target == null) {
                          p.sendMessage("§c§lERRO! §fJogador invalido.");
                          return true;
                      }

                      if (args[2].equalsIgnoreCase("areia")) {
                          p.getInventory().addItem(AreiaItem.AreiaItemStack(1));
                      }
                      if (args[2].equalsIgnoreCase("terra")) {
                          p.getInventory().addItem(TerraItem.TerraItemStack(1));
                      }
                  }
              }

              if (args.length == 4) {
                  if (args[0].equalsIgnoreCase("give")) {
                      String player = args[1];
                      Player target = Bukkit.getPlayerExact(player);

                      if (target == null) {
                          p.sendMessage("§c§lERRO! §fJogador invalido.");
                          return true;
                      }

                      if (args[2].equalsIgnoreCase("areia")) {
                          int ammount = Integer.valueOf(args[3]);
                          p.getInventory().addItem(AreiaItem.AreiaItemStack(ammount));
                      }
                      if (args[2].equalsIgnoreCase("terra")) {
                          int ammount = Integer.valueOf(args[3]);
                          p.getInventory().addItem(TerraItem.TerraItemStack(ammount));
                      }
                  }
              }

          }
      } else {
          p.sendMessage(LkAddons.getInstance().getConfig().getString("mensagens.noperm").replace("&", "§"));
      }return false;
    }
}