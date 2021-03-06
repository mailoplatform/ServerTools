package de.maltesermailo.OpMessage.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class AFKToggleEvent extends PlayerEvent {

	private final boolean wasAFK;
	private boolean toAFK;
	private String message = null;
	
	public AFKToggleEvent(Player who, boolean wasAFK,boolean toAFK, String message) {
		this(who, wasAFK, toAFK);
		this.setMessage(message);
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
	public AFKToggleEvent(Player who, boolean wasAFK, boolean toAFK) {
		super(who);
		this.wasAFK = wasAFK;
		this.setAFK(toAFK);
	}
	public boolean wasAFK() {
		return this.wasAFK;
	}
	public void setAFK(boolean afk) {
		this.toAFK = afk;
	}
	public boolean toAFK()  {
		return this.toAFK;
	}
	public static HandlerList handlers = new HandlerList();
	@Override
	public HandlerList getHandlers() {
		return AFKToggleEvent.handlers;
	}
	public static HandlerList getHandlerList() {
		return AFKToggleEvent.handlers;
	}

	
	
}
