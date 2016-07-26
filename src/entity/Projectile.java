package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ConcurrentModificationException;

import mainStuff.Handler;
import npcs.Soldier;
import settings.AdminSettings;

public class Projectile extends Object{

	private int moveX,moveY;
	
	public Projectile(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
		moveX = (int)handler.getEngine().getGameState().getWorld().getPlayer().getpXvel();
		moveY = (int)handler.getEngine().getGameState().getWorld().getPlayer().getpYvel();
		
		isProjectile = true;
	}
	
	@Override
	public void update(){
		this.x -= moveX;
		this.y -= moveY;
		
		bounds.x = x;
		bounds.y = y;
		
		for (Entity e : World.allThings){
			
			if (e.isCollision(this)){
				
				
				
				if (e.isSoldier){
					
					Soldier ee = (Soldier) e;
					ee.setHealth(ee.getHealth()-5);
					
					World.listIterator.remove();
				}
				
				
			}
			
			
		}
		
		
	}

	@Override
	public void render(Graphics g){
		if (AdminSettings.boundingBox == true){
			g.setColor(Color.red);
			g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		}
		g.drawImage(b, x, y, null);
	}
	
}





