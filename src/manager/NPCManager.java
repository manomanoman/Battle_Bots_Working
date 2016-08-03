
//Manages the paths of the NPCS
//Manages the when the NPCS appear
//Manages the AI of the NPCS

package manager;

import entity.NPC;
import entity.Player;
import mainStuff.Handler;
import npcs.SoldierA;
import npcs.SoldierB;

public class NPCManager {
	
	private Handler handler;

	private SoldierA soldierA;
	private SoldierB soldierB;
	
	private Player player;
	
	
	int Ai_RelPx;
	int Ai_RelPy;
	
	
	
	public void followPlayer() {
		
		
		//AI is center of coordinate system
		Ai_RelPx =	player.getPlayerX() - soldierB.getSoldierBx() ; //Relative x position of Player from AI 
		Ai_RelPy =	player.getPlayerY() - soldierB.getSoldierBy() ; //Relative y position of Player from AI 
		
		double[] unit_Vectors = { Ai_RelPx / Math.sqrt(Ai_RelPy * Ai_RelPy + Ai_RelPx * Ai_RelPx),
				Ai_RelPy / Math.sqrt(Ai_RelPy * Ai_RelPy + Ai_RelPx * Ai_RelPx) };

		
		
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
