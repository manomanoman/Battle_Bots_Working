package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mainStuff.Handler;

public class ExpBox extends PickupableObject{

	public ExpBox(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
	}
	
	@Override
	public void update(){
		/*
		for (Entity e : World.allThings){
			if (e.equals(this)){
				return;
			}
			
			if (e.equals(handler.getEngine().getGameState().getWorld().getPlayer())){
				
				Player ee = (Player) e;
				
				if (this.bounds.intersects(ee.bounds)){
					System.out.println("it works");
					World.allThings.remove(this);
				}
			}
			
			/*if (this.bounds.intersects(e.bounds)){
				System.out.println("FUCK FUCK FUCK IT  FUCKING WORKS");
			}*/
			
		/*}*/
		
	}
	
	@Override
	public void render(Graphics g){
		g.setColor(Color.red);
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}

}
