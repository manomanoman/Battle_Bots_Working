package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mainStuff.Handler;

public class mine extends  PickupableObject {

	public mine(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
}
