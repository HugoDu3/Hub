package fr.jayrex.hub;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HCMD extends Command {
  public HCMD() {
    super("rh", "hub.admin", new String[] { "hub" });
  }
  
  @SuppressWarnings("deprecation")
public void execute(CommandSender sender, String[] args) {
    ProxiedPlayer p = (ProxiedPlayer)sender;
    if (args.length == 0) {
      p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
            "&cUsage> /hub reload"));
    } else if (args.length == 1) {
      if (args[0].equalsIgnoreCase("reload")) {
        Main.getInstance().saveConfig();
        Main.getInstance().loadConfig();
        p.sendMessage(
            ChatColor.translateAlternateColorCodes('&', 
              "&cReload du fichier config.yml avec succès!"));
      } else {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
              "&cUtilisation> /hub reload"));
      } 
    } else {
      p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
            "&cUtilisation> /hub reload"));
    } 
  }
}

