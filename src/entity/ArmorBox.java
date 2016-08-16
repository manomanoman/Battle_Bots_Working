package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mainStuff.Handler;

public class ArmorBox extends PickupableObject{
	
	public int armorRegen;
	
	public ArmorBox(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
		
	 armorRegen = 50;
		
		x = 300;
		y = 300;		
	}

	@Override
	public void update() {
		
		bounds.x = x;
		bounds.y = y;
		
		for (Entity e : World.allThings){
			
			if (e.isCollision(this)){
				
				
				if (e.isPlayer){
					
					Player ee = (Player) e;
					
					if(ee.getArmor() == ee.getMaxArmor()){
					}
					
					else if (ee.getArmor() + armorRegen > ee.getMaxArmor() ){ 
					int remainder = ee.getMaxArmor() - ee.getArmor();
					ee.setArmor(ee.getArmor()+remainder);
					World.listIterator.remove();
					}
					
					else{
					ee.setArmor(ee.getArmor()+ armorRegen );
					World.listIterator.remove();
					}
				}
				
				
			}
			
			
		}
	}

	@Override
	public void render(Graphics g) {

	//	g.setColor(Color.green);
	//	g.fillRect(x, y, width, height);
		g.drawImage(b, x, y, null);
	}

}
