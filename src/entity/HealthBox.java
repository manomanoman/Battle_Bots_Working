package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import mainStuff.Handler;

public class HealthBox extends PickupableObject{

	public int healthRegen;
	
	public HealthBox(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
		
		healthRegen = 50;
	}

	@Override
	public void update() {
		
		bounds.x = x;
		bounds.y = y;
		
		for (Entity e : World.allThings){
			
			if (e.isCollision(this)){
				
				
				if (e.isPlayer){
					
					Player ee = (Player) e;
					
					if(ee.getHealth() == ee.getMaxHealth()){
					}
					
					else if (ee.getHealth() + healthRegen > ee.getMaxHealth() ){ 
					int remainder = ee.getMaxArmor() - ee.getArmor();
					ee.setHealth(ee.getHealth()+remainder);
					World.listIterator.remove();
					}
					
					else{
					ee.setArmor(ee.getHealth()+ healthRegen );
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
