package me.yoda.warfare;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.*;
import me.yoda.warfare.commands.hidestats;
import me.yoda.warfare.commands.statsshow;

public class main extends JavaPlugin implements Listener {

	public Scoreboard board;

	public void onEnable() {

		getLogger().info("stats enabled");
		getServer().getPluginManager().registerEvents(this, this);
		makeScoreboard();
		getCommand("showstats").setExecutor(new statsshow(board));
		getCommand("hidestats").setExecutor(new hidestats());
	}

	public void makeScoreboard() {

		board = Bukkit.getScoreboardManager().getNewScoreboard();

		Objective objective = board.registerNewObjective("Test", "Test2");
		objective.setDisplayName(ChatColor.UNDERLINE.BOLD.AQUA + "Parkour Stats");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score score = objective.getScore(ChatColor.GOLD + "Iceland Wins");
		score.setScore(Bukkit.getOnlinePlayers().size());

		Score score2 = objective.getScore(ChatColor.GOLD + "Iceland Fails");
		score2.setScore(Bukkit.getMonsterSpawnLimit());

		Score score3 = objective.getScore(ChatColor.GOLD + "Aztec Wins");
		score3.setScore(Bukkit.getMaxPlayers());

		Score score4 = objective.getScore(ChatColor.GOLD + "Aztec Fails");
		score4.setScore(Bukkit.getVersion().length());
	}
}