package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ConcurrentModificationException;

import mainStuff.Handler;
import npcs.Crate;
import npcs.SoldierA;
import npcs.SoldierB;
import settings.AdminSettings;

public class hillPad extends Object{
	
	int blueDamage = 255;
	int redDamage = 0;
	private Color hillColor = new Color(redDamage, 0, blueDamage);
	

	public hillPad(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);

		isHillPad = true;
		
	//	maxHealth = 25;
	//	health = 25;
		
	}
	
	@Override
	public void update(){
		
		bounds.x = x;
		bounds.y = y;
		
		for (Entity e : World.allThings){
			
			if (e.isCollision(this)){
				
				if (redDamage < 250){
				if (e.isSoldierA){
					
					SoldierA ee = (SoldierA) e;
					ee.setHealth(ee.getHealth()-5);
					blueDamage -= 1;
					redDamage += 1;
					hillColor = new Color(redDamage, 0, blueDamage);
				}
				
				if (e.isSoldierB){
					
					SoldierB ee = (SoldierB) e;
					ee.setHealth(ee.getHealth()-5);
					blueDamage -= 5;
					redDamage += 5;
					hillColor = new Color(redDamage, 0, blueDamage);	
				}
				
				else if(redDamage >= 250){
				World.listIterator.remove();	
				}
				
				}
				
		//		if (e.isPlayer){
		//			
		//			Player ee = (Player) e;
		//			ee.setHealth(--mineDamage);
		//		
		//		}
				
				
			}
			
			
		}
		
		
	}

	@Override
	public void render(Graphics g){
	//	if (AdminSettings.boundingBox == true){
			g.setColor(hillColor);
			g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
	//	}
	//	g.drawImage(b, x, y, null);
	}
	
}





