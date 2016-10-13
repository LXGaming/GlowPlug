package io.github.lxgaming.glowplug.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class GlowCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("glow") && sender.hasPermission("GlowPlug.Glow")) {
			Player player = (Player) sender;
			if (args.length == 0) {
				if (sender instanceof Player) {
					if (!player.hasPotionEffect(PotionEffectType.GLOWING)) {
						player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 9999999, 1));
						player.sendMessage(ChatColor.GREEN + "You're now glowing.");
					} else {
						player.removePotionEffect(PotionEffectType.GLOWING);
						player.sendMessage(ChatColor.GREEN + "You're no longer glowing.");
					}
				} else {
					sender.sendMessage(ChatColor.RED + "We cannot effect the Console!");
				}
				return true;
			}
			
			if (args.length == 1) {
				Player targetPlayer = Bukkit.getPlayerExact(args[0]);
				if (!(targetPlayer == null) && targetPlayer.isOnline()) {
					if (!targetPlayer.hasPotionEffect(PotionEffectType.GLOWING)) {
						targetPlayer.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 9999999, 1));
						sender.sendMessage(targetPlayer.getName() + ChatColor.GREEN + " is now glowing.");
					} else {
						targetPlayer.removePotionEffect(PotionEffectType.GLOWING);
						sender.sendMessage(targetPlayer.getName() + ChatColor.GREEN + " is no longer glowing.");
					}
				} else {
					sender.sendMessage(ChatColor.RED + "Player is Offline!");
				}
				return true;
			}
			sender.sendMessage(ChatColor.RED + "Invalid Args!");
		} else {
			sender.sendMessage(ChatColor.RED + "You do not have permission!");
			return true;
		}
		return false;
	}
}