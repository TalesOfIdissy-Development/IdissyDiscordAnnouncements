package me.dahpr0gam3r.IdissyDiscordAnnouncements;

import me.dahpr0gam3r.IdissyCore.IdissyCore;
import me.dahpr0gam3r.IdissyDiscordAnnouncements.Commands.CommandAnnounce;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main plugin;
    private CommandAnnounce commandAnnounce = new CommandAnnounce();
    @Override
    public void onEnable() {
        plugin = this;
        this.getCommand("discordannounce").setExecutor(new CommandAnnounce());
        this.loadConfig();
        this.reload_Config();
        IdissyCore.sendStart(this);
    }

    @Override
    public void onDisable() {

    }

    public void loadConfig() {
        this.saveDefaultConfig();
    }

    public void reload_Config() {
        this.reloadConfig();
    }

}
