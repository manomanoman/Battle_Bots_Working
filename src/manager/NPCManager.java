
//Manages the paths of the NPCS
//Manages the when the NPCS appear
//Manages the AI of the NPCS

package manager;

import entity.NPC;
import entity.Player;
import entity.Projectile;
import file.ImageLoader;
import mainStuff.Handler;
import npcs.SoldierA;
import npcs.SoldierB;
import npcs.Crate;

public class NPCManager {
	
	private Handler handler;

	private SoldierA soldierA;
	private SoldierB soldierB;
	
	private Player player;
	
	int Ai_RelPx;
	int Ai_RelPy;
	int playerX;
	int playerY;
	int soldierX;
	int soldierY;
	
	private int projectileSpeed;
	private int projectileDamage;
	private double pXvel;
	private double pYvel;
	
	
	public void shootPlayer() {
		
		projectileSpeed = 1;
		projectileDamage = 5;
		
		playerX = (int)handler.getEngine().getGameState().getWorld().getPlayer().getPlayerX();
		playerY = (int)handler.getEngine().getGameState().getWorld().getPlayer().getPlayerY();
		
		soldierX = (int)handler.getEngine().getGameState().getWorld().getSoldierB().getSoldierBx();
		soldierY = (int)handler.getEngine().getGameState().getWorld().getSoldierB().getSoldierBy();	
		
		//AI is center of coordinate system
		
		Ai_RelPx =	playerX - soldierX ; //Relative x position of Player from AI 
		Ai_RelPy =	playerY - soldierY ; //Relative y position of Player from AI 
		
		Projectile p = new Projectile(handler,
				ImageLoader.loadImage("res\\entities\\object\\projectile\\projectile_1.png"), soldierB.getSoldierBx(),
				soldierB.getSoldierBy(), 16, 16);
		
		double[] unit_Vectors = { Ai_RelPx / Math.sqrt(Ai_RelPy * Ai_RelPy + Ai_RelPx * Ai_RelPx),
				Ai_RelPy / Math.sqrt(Ai_RelPy * Ai_RelPy + Ai_RelPx * Ai_RelPx) };
		
		pXvel = projectileSpeed * unit_Vectors[0];
		pYvel = projectileSpeed * unit_Vectors[1];
		
	//	pXvel = projectileSpeed * unit_Vectors[0];
	//	pYvel = projectileSpeed * unit_Vectors[1];
	//	if (m_RelY > 0 && m_RelX > 0) {
	//		theta = Math.atan(m_RelY / m_RelX) + Math.PI;
	//		quadrant = 1;
	//	} else if (m_RelY > 0 && m_RelX < 0) {
	//		theta = Math.atan(m_RelY / m_RelX);
	//		quadrant = 2;
	//	} else if (m_RelY < 0 && m_RelX < 0) {
	//		theta = Math.atan(m_RelY / m_RelX);
	//		quadrant = 3;
	//	} else if (m_RelY < 0 && m_RelX > 0) {
	//		theta = Math.atan(m_RelY / m_RelX) + Math.PI;
	//		quadrant = 4;
	//	}
	}
	
	
	
}
