package me.dahpr0gam3r.IdissyDiscordAnnouncements;

import com.tjplaysnow.discord.object.Bot;
import com.tjplaysnow.discord.object.CommandSpigotManager;
import com.tjplaysnow.discord.object.ThreadSpigot;
import me.dahpr0gam3r.IdissyCore.IdissyCore;
import me.dahpr0gam3r.IdissyDiscordAnnouncements.Commands.CommandAnnounce;
import me.dahpr0gam3r.IdissyDiscordAnnouncements.Commands.Discord.AnnounceCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main plugin;

    public static Bot bot;

    @Override
    public void onEnable() {
        plugin = this;
        this.getCommand("discordannounce").setExecutor(new CommandAnnounce());
        this.loadConfig();
        this.reload_Config();
        IdissyCore.sendStart(this);
        bot = new Bot(this.getConfig().getString("bot.token"), this.getConfig().getString("bot.prefix"));
        bot.setBotThread(new ThreadSpigot(this));
        bot.setConsoleCommandManager(new CommandSpigotManager());
        bot.addCommand(new AnnounceCommand());
    }

    @Override
    public void onDisable() {

    }

    private void loadConfig() {
        this.saveDefaultConfig();
    }

    private void reload_Config() {
        this.reloadConfig();
    }

}
