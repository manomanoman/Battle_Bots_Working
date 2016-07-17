package entity;

import java.awt.image.BufferedImage;

import mainStuff.Handler;

public abstract class Character extends Entity{
	
	

	public Character(Handler handler,BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
	}

}
