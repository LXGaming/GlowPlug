package io.github.lxgaming.glowplug;

import org.bukkit.plugin.java.JavaPlugin;

import io.github.lxgaming.glowplug.commands.GlowAllCommand;
import io.github.lxgaming.glowplug.commands.GlowCommand;
import io.github.lxgaming.glowplug.commands.GlowPlugCommand;

public class GlowPlug extends JavaPlugin {
	
	public static GlowPlug instance;
	
	@Override
	public void onLoad() {
		getLogger().info("Warming up...");
	}
	
	@Override
	public void onEnable() {
		getLogger().info("Ready to start!");
		instance = this;
		this.getCommand("glowplug").setExecutor(new GlowPlugCommand());
		this.getCommand("glow").setExecutor(new GlowCommand());
		this.getCommand("glowall").setExecutor(new GlowAllCommand());
		getLogger().info("GlowPlug has started!");
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
}