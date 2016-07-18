package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mainStuff.Handler;

public class Projectile extends Object{

	private int moveX,moveY;
	
	public Projectile(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
		moveX = (int)handler.getEngine().getGameState().getWorld().getPlayer().getpXvel();
		moveY = (int)handler.getEngine().getGameState().getWorld().getPlayer().getpYvel();
	}
	
	@Override
	public void update(){
		this.x -= moveX;
		this.y -= moveY;
	}

	@Override
	public void render(Graphics g){
		g.fillRect(x, y, bounds.width, bounds.height);
		g.drawImage(b, x, y, null);
	}
	
}





