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
