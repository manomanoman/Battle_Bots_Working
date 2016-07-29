package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mainStuff.Handler;
import npcs.Soldier;

public class mine extends  PickupableObject {

	public int mineDamage;
	
	public mine(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
		mineDamage = 200;
		x = 350;
		y = 350;
	}

	@Override
	public void update() {
		
		bounds.x = x;
		bounds.y = y;
		
		for (Entity e : World.allThings){
			
			if (e.isCollision(this)){
				
				
				if (e.isPlayer){
					
					Player ee = (Player) e;
					
					if(ee.getHealth() - mineDamage < 0){
						//Kill Player
					}
					
					else if (ee.getHealth() - mineDamage > 0 ){ 
					int remainder = ee.getHealth();
					ee.setHealth(ee.getHealth()-mineDamage);
					World.listIterator.remove();
					}
					
					}
				else if (e.isSoldier){
					Soldier ee = (Soldier) e;
					if(ee.getHealth() - mineDamage < 0){
						//Kill soldier
					}
					
					else if (ee.getHealth() - mineDamage > 0 ){ 
					ee.setHealth(ee.getHealth()-mineDamage);
					World.listIterator.remove();
					}
					
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
