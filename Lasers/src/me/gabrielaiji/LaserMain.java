package me.gabrielaiji;

import org.bukkit.plugin.java.JavaPlugin;

public class LaserMain extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new GunLaser(this);
		new LightSaber(this);
	}
	
	@Override
	public void onDisable() {
		
	}


}
