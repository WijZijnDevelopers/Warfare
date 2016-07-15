package me.yoda.warfare.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;


public class statsshow implements CommandExecutor{
	
	public Scoreboard board;
	
	public statsshow(Scoreboard board) {
		
		this.board = board;
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arguments) {
        Player player = (Player) sender;
		player.setScoreboard(board);
	    return true;
	}
}
