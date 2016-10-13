package io.github.lxgaming.glowplug.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class GlowAllCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("glowall") && sender.hasPermission("GlowPlug.GlowAll")) {
			
			if (args.length == 0) {
				sender.sendMessage(ChatColor.GREEN + "Usage: /Glowall on/off");
				return true;
			}
			
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("on")) {
					for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
						onlinePlayer.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 9999999, 1));
					}
					sender.sendMessage(ChatColor.GREEN + "All players are now glowing.");
				} else if (args[0].equalsIgnoreCase("off")) {
					for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
						onlinePlayer.removePotionEffect(PotionEffectType.GLOWING);
					}
					sender.sendMessage(ChatColor.GREEN + "All players are no longer glowing.");
				}
				return true;
			}
		}
		return false;
	}
}