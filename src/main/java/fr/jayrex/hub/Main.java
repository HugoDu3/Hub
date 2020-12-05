package fr.jayrex.hub;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Main extends Plugin {
  private Configuration config;
  
  static Main instance;
  
  public static Main getInstance() {
    return instance;
  }
  
  public void onEnable() {
    instance = this;
    loadCommands();
    try {
      if (!getDataFolder().exists())
        getDataFolder().mkdir(); 
      File file = new File(getDataFolder(), "config.yml");
      if (!file.exists())
        Files.copy(getResourceAsStream("config.yml"), file.toPath(), new java.nio.file.CopyOption[0]); 
      loadConfig();
    } catch (IOException iOException) {}
  }
  
  public void loadConfig() {
    try {
      this.config = ConfigurationProvider.getProvider(YamlConfiguration.class)
        .load(new File(getDataFolder(), "config.yml"));
    } catch (IOException iOException) {}
  }
  
  public void saveConfig() {
    try {
      ConfigurationProvider.getProvider(YamlConfiguration.class).save(
          getConfig(), new File(getDataFolder(), "config.yml"));
    } catch (IOException ex) {
      ex.printStackTrace();
    } 
  }
  
  void loadCommands() {
    getProxy().getPluginManager().registerCommand(this, new HubCMD());
    getProxy().getPluginManager().registerCommand(this, new HCMD());
  }
  
  public Configuration getConfig() {
    return this.config;
  }
}
