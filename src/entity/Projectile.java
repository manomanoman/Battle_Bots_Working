package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mainStuff.Handler;

public class Projectile extends Object{

	public Projectile(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
	}
	
	@Override
	public void update(){
		x+=5;
	}

	@Override
	public void render(Graphics g){
		g.fillRect(x, y, bounds.width, bounds.height);
		g.drawImage(b, x, y, null);
	}
	
}





