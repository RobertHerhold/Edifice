package me.reherhold.edifice.eventhandler;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.filter.cause.Root;

import me.reherhold.edifice.Edifice;

public class ChangeBlockEventHandler {

	private Edifice plugin;

	public ChangeBlockEventHandler(Edifice plugin) {
		this.plugin = plugin;
	}

	@Listener
	public void breakBlock(ChangeBlockEvent.Break event, @Root Player player) {
		if (this.plugin.getPlayerWandActivationStates().containsKey(player.getUniqueId())) {
			if (player.get(Keys.GAME_MODE).get() == GameModes.CREATIVE) {
				event.setCancelled(true);
			}
		}
	}
}