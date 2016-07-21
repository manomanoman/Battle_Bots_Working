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
		System.out.println(nextExpCap + " ");

		if (player.getExperience() >= nextExpCap) {
			levelUp(player);
		}

	}

	public int[][] levelToExp = { 
			{ 1, 500 }, 
			{ 2, 1500 },
			{ 3, 2500 },
			{ 4, 4000 } };

	private void levelUp(Player player) {
		// increments the players current level
		player.setLevel(player.getLevel() + 1);
		// sets the currentExperience Variable back to 0
		player.setExperience(0);
		// sets the expToNextLevel to the corresponding array value
		player.setMaxExperience(levelToExp[player.getLevel() - 1][1]);
		// gives the player an upgrade point
		player.setUpgradePoints(player.getUpgradePoints() + 1);

	}

}
