package me.gabrielaiji;

import org.bukkit.Material;
//import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class GunLaser implements Listener{
	
	public GunLaser(LaserMain plugin){
		 plugin.getServer().getPluginManager().registerEvents(this, plugin );	 
	}

	@EventHandler
	public void onInstantShoot(PlayerInteractEvent e){//allows to shoot  straight arrows instantly with a bow in hand, also checks and takes ammunitions(simple arrows)
		
		Player player = e.getPlayer();
		PlayerInventory inventory = player.getInventory();
		
		if(player.getItemInHand().getType() == Material.BOW && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && inventory.contains(Material.ARROW, 1))){
			Arrow arrow = player.launchProjectile(Arrow.class);
			arrow.setVelocity(player.getLocation().getDirection().multiply(4));
			
			inventory.removeItem(new ItemStack[] {new ItemStack(Material.ARROW, 1)});
		}
	}
	
	@EventHandler
	public void onBowShoot(EntityShootBowEvent e){//refuse to shoot an arrow by drawing a bow (just right clicking should shoot)
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onArrowHitBlock(ProjectileHitEvent e){
		
		Entity entity = e.getEntity();
		entity.remove();
		
		/*boolean setArrowsInBody(Player player) {
			((CraftPlayer) player).getHandle().getDataWatcher().watch(9, (byte)0);
		}*/
	}
	
}
