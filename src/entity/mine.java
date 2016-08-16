package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ConcurrentModificationException;

import file.ImageLoader;
import mainStuff.Handler;
import manager.AnimationManager;
import npcs.SoldierA;
import npcs.SoldierB;

public class Mine extends  PickupableObject {

	public int mineDamage;
	public int mineTick;
	
	private BufferedImage ci;
	
//	mineAnim [] = {BufferedImage b1 = ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Disarmed1.png"),
//	BufferedImage b2 = ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Disarmed2.png"),
//	BufferedImage b3 = ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Armed.png")};
	
	BufferedImage mineAnim [] = {
			ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Disarmed1.png"),
			ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Disarmed2.png"),
			ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Armed.png")
			};
	
	public Mine(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
		mineDamage = 250;
		x = 350;
		y = 350;
		
		//Arming Animation

		ci = mineAnim[0];
	
	}

	
	int choco = 0;
	int it = 0;
	
	boolean armed = false;
	
	@Override
	public void update() {
		
		bounds.x = x;
		bounds.y = y;
		
		
		if (armed == false){	
			
			
			if (choco < 5){
				ci = mineAnim[0];
				choco ++;
			}
			
			else if (choco >= 5 && choco <= 10){
				ci = mineAnim[1];
				choco ++;			
			}
			else{
				ci = mineAnim[2];
				choco ++;
				
				if(choco == 15){
					choco = 0;
					it ++;
				
					if (it == 10){
						armed = true;
					}
				}
			}
		}
	
		//	if(ee.getHealth() - mineDamage < 0){
		//		return;
			//	Kill Player
//			}
	//		else if (ee.getHealth() - mineDamage > 0 ){ 
		
	if (armed == true){
		for (Entity e : World.allThings){
		
			if (e.isCollision(this)){
				
				// OPTIMIZE WITH SWITCH CASE LATER
				
				if (e.isPlayer){
				Player ee = (Player) e;
				ee.setArmor(ee.getArmor()-mineDamage); //I changed this to armor before and it worked.. but health doesnt work...
				World.listIterator.remove();				
				}
				
				else if (e.isSoldierA){
				SoldierA ee = (SoldierA) e;
				ee.setHealth(ee.getHealth()-mineDamage);
				World.listIterator.remove();
				}	
				
				else if (e.isSoldierB){
				SoldierB ee = (SoldierB) e;
				ee.setHealth(ee.getHealth()-mineDamage);
				World.listIterator.remove();
				}	
			
			AnimationManager expl = new AnimationManager(handler,
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"1"+".png"), x - 35,
			y - 35, 100, 100);
			handler.getEngine().getGameState().getWorld().getListIterator().add(expl);

			}
		}
		}
				
			}
			
			
		
	

	@Override
	public void render(Graphics g) {
	//	g.setColor(Color.green);
	//	g.fillRect(x, y, width, height);
		g.drawImage(ci, x, y, null);
	}

}
