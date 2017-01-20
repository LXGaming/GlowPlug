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
