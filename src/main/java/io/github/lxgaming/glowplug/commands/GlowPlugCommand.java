package io.github.lxgaming.glowplug.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GlowPlugCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("glowplug")) {
			sender.sendMessage(ChatColor.GOLD + "===== " + ChatColor.GREEN + "GlowPlug" + ChatColor.GOLD + " ===== ");
			sender.sendMessage(ChatColor.GOLD + "- " + ChatColor.AQUA + "Version 0.1.1");
			sender.sendMessage(ChatColor.GOLD + "- " + ChatColor.AQUA + "Author - LX_Gaming");
			sender.sendMessage(ChatColor.GOLD + "===== " + ChatColor.GREEN + "Commands" + ChatColor.GOLD + " ===== ");
			sender.sendMessage(ChatColor.GOLD + "- " + ChatColor.AQUA + "/glowplug");
			sender.sendMessage(ChatColor.GOLD + "- " + ChatColor.AQUA + "/glow + /glow <Player>");
			sender.sendMessage(ChatColor.GOLD + "- " + ChatColor.AQUA + "/glowall <on/off>");
			sender.sendMessage(ChatColor.GOLD + "===== " + ChatColor.GREEN + "Permissions" + ChatColor.GOLD + " ===== ");
			sender.sendMessage(ChatColor.GOLD + "- " + ChatColor.AQUA + "GlowPlug.Glow");
			sender.sendMessage(ChatColor.GOLD + "- " + ChatColor.AQUA + "GlowPlug.GlowAll");
			return true;
		}
		return false;
	}
}