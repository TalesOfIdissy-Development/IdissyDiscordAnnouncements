package me.dahpr0gam3r.IdissyDiscordAnnouncements.Commands;


import me.dahpr0gam3r.IdissyDiscordAnnouncements.Main;
import net.dv8tion.jda.core.entities.TextChannel;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class CommandAnnounce implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String CommandLabel, String[] args) {

        if (!commandSender.hasPermission("idissydiscordannouncements.announce")) {commandSender.sendMessage(ChatColor.RED + "You do not have the correct Permissions");return true;}
        if (command.getName().equalsIgnoreCase("discordannounce")){
            if (args.length < 2) { commandSender.sendMessage(ChatColor.RED + "Command usage is as follows: /discordannounce [channel] [message]");}
            String[] messageArray = Arrays.copyOfRange(args, 1 , args.length);
            String message = String.join(" ", messageArray);
            if (args[0].equalsIgnoreCase(Main.plugin.getConfig().getString("channels.1.name"))){
                TextChannel channel = Main.bot.getBot().getTextChannelById(Main.plugin.getConfig().getString("channels.1.id"));
                channel.sendMessage(message).complete();
            } else if (args[0].equalsIgnoreCase(Main.plugin.getConfig().getString("channels.2.name"))){
                TextChannel channel = Main.bot.getBot().getTextChannelById(Main.plugin.getConfig().getString("channels.2.id"));
                channel.sendMessage(message).complete();
            }
            else if (args[0].equalsIgnoreCase(Main.plugin.getConfig().getString("channels.3.name"))){
                TextChannel channel = Main.bot.getBot().getTextChannelById(Main.plugin.getConfig().getString("channels.3.id"));
                channel.sendMessage(message).complete();
            }
            else if (args[0].equalsIgnoreCase(Main.plugin.getConfig().getString("channels.4.name"))){
                TextChannel channel = Main.bot.getBot().getTextChannelById(Main.plugin.getConfig().getString("channels.4.id"));
                channel.sendMessage(message).complete();
            }
            else if (args[0].equalsIgnoreCase(Main.plugin.getConfig().getString("channels.5.name"))) {
                TextChannel channel = Main.bot.getBot().getTextChannelById(Main.plugin.getConfig().getString("channels.5.id"));
                channel.sendMessage(message).complete();
            } else {commandSender.sendMessage(ChatColor.RED + "Channel not found");}
            return true;
        }
        return false;
    }
}
