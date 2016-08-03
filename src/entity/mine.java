package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import file.ImageLoader;
import mainStuff.Handler;
import npcs.SoldierA;
import npcs.SoldierB;

public class Mine extends  PickupableObject {

	public int mineDamage;
	public int mineTick;
	
//	mineAnim [] = {BufferedImage b1 = ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Disarmed1.png"),
//	BufferedImage b2 = ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Disarmed2.png"),
//	BufferedImage b3 = ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Armed.png")};
	
	BufferedImage mineAnim [] = {ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Disarmed1.png"),
			ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Disarmed2.png"),
			ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Armed.png")};
	
	
	public Mine(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
		mineDamage = 200;
		x = 350;
		y = 350;
		
		//Arming Animation
		
		int it = 10;
		

		for(BufferedImage animImage : mineAnim ){
			b = animImage;
		}
		

	}

	@Override
	public void update() {
		
		bounds.x = x;
		bounds.y = y;
		
		for (Entity e : World.allThings){
		
			if (e.isCollision(this)){

						
		//		b = ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Disarmed1.png"), x + (width / 2) - 8,
		//						y + (height / 2) - 8, 32, 32);
				
				if (e.isPlayer){
					
					Player ee = (Player) e;
					
					if(ee.getHealth() - mineDamage < 0){
						return;
						//Kill Player
					}
					
					else if (ee.getHealth() - mineDamage > 0 ){ 

					ee.setHealth(ee.getHealth()-mineDamage);
					World.listIterator.remove();
					}
					
					}
				
					else if (e.isSoldierA){
					SoldierA ee = (SoldierA) e;
					
					
					ee.setHealth(ee.getHealth()-mineDamage);
					World.listIterator.remove();
					
				}	
			}
				
				
			}
			
			
		}
	

	@Override
	public void render(Graphics g) {

		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
		g.drawImage(b, x, y, null);
	}

}
