package manager;

import entity.Player;
import mainStuff.Handler;

public class SkillManager {

	// create all variables you will need

	private Handler handler;

	private Player player;

	public SkillManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;

	}

	public void update() {

		int nextExpCap = levelToExp[player.getLevel() - 1][1];

		if (player.getExperience() >= nextExpCap) {
			levelUp(player);
		}

	}

	public int[][] levelToExp = { 
			{ 1, 200 }, 
			{ 2, 400 },
			{ 3, 600 },				//Temporary quick lvling for testing the skill points
			{ 4, 800 },				
			{ 5, 1000 },
			{ 6, 1200 },
			{ 7, 1400 },
			{ 8, 1600 },
			{ 9, 1800 },
			{ 10, 4000 },
			{ 11, 5000 },
			{ 12, 6000 },
			{ 13, 7000 },
			{ 14, 8000 },
			{ 15, 9000 },
			{ 16, 10000 },
			{ 17, 11000 },
			{ 18, 41000 },
			{ 19, 42000 },
			{ 20, 43000 },
			{ 21, 44000 },
			{ 22, 45000 },
			{ 23, 46000 },
			{ 24, 47000 },
			{ 25, 48000 },
	
	};

	
	
	
	private void levelUp(Player player) {
		// increments the players current level
		player.setLevel(player.getLevel() + 1);
		// sets the currentExperience Variable back to 0
		player.setExperience(0);
		// sets the expToNextLevel to the corresponding array value
		player.setMaxExperience(levelToExp[player.getLevel() - 1][1]);
		// gives the player an upgrade point
		player.setUpgradePoints(player.getUpgradePoints() + 1);
		// gives the player some cash
		player.setCash(player.getCash() + player.getLevel()*500);
	}

}
