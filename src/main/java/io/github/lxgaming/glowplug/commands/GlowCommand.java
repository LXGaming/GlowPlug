/*
 * Copyright 2017 Alex Thomson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
