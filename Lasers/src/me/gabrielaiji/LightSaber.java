package me.gabrielaiji;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageModifier;
import org.bukkit.projectiles.ProjectileSource;

public class LightSaber implements Listener{
	
	public LightSaber(LaserMain plugin){
		 plugin.getServer().getPluginManager().registerEvents(this, plugin );	 
	}
	
	@EventHandler
	public void onSwordDefence(EntityDamageByEntityEvent e){//returns an arrow in direction of the Entity eyes if he right-click with an iron_sword

		if(((HumanEntity) e.getEntity()).getItemInHand().getType() == Material.IRON_SWORD){
						
			if(e.getDamage(DamageModifier.BLOCKING) < 0){

				e.setCancelled(true);
				
				Arrow arrow = ((ProjectileSource) e.getEntity()).launchProjectile(Arrow.class);
				arrow.setVelocity(e.getEntity().getLocation().getDirection().multiply(4));
				
				
			}
		}
	}

}
