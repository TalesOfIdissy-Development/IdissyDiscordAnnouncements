package me.dahpr0gam3r.IdissyDiscordAnnouncements.Commands.Discord;

import com.tjplaysnow.discord.object.ProgramCommand;
import me.dahpr0gam3r.IdissyDiscordAnnouncements.Main;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import org.bukkit.ChatColor;

import java.util.List;

public class AnnounceCommand extends ProgramCommand {
    @Override
    public String getLabel() {
        return "announce";
    }

    @Override
    public String getDescription() {
        return "Send announcements to specific servers";
    }

    @Override
    protected boolean run(User user, MessageChannel messageChannel, Guild guild, String s, List<String> list) {
        List<Role> userRoles = guild.getMember(user).getRoles();
        Role broadcastRole = guild.getRoleById(Main.plugin.getConfig().getString("bot.broadcastrole"));

        if (user.isBot()) return true;
        if (!userRoles.contains(broadcastRole)) return true;
        if (list.size() < 2) {
            messageChannel.sendMessage("Usage: " + Main.plugin.getConfig().getString("bot.prefix") + "announce [Server name/all] [Message]").complete();
        }
        if (list.get(0).equalsIgnoreCase(Main.plugin.getConfig().getString("bot.currentserver")) || list.get(0).equalsIgnoreCase("all")) {
            list.remove(0);
            String broadcastMessage = ChatColor.translateAlternateColorCodes('&', String.join(" ", list));
            Main.plugin.getServer().broadcastMessage(broadcastMessage);
        }
        return true;
    }
}
