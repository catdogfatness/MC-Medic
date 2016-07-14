package me.catdogfatness.medic;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class MedicSigns implements Listener{

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		
		if(e.getLine(0).equalsIgnoreCase("[Heal]")) {
			
			e.setLine(0, "§3[Heal] ");
			e.setLine(1, "§Right Click here");
			e.setLine(3, "§3 to be healed!");
			
			
		}
		
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		
		if(!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return; 
		if(e.getClickedBlock().getState() instanceof Sign) {
			Sign s = (Sign) e.getClickedBlock().getState();
			if (s.getLine(0).equalsIgnoreCase("§3[Heal]")) {
				
				e.getPlayer().setHealth(20);
				e.getPlayer().sendMessage(ChatColor.GREEN + "You have been healed!");
				
				
			}
		}
			
		
		
		
	}
	
	
}
