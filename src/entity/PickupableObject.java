package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mainStuff.Handler;

public abstract class PickupableObject extends Object{

	public PickupableObject(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
	}
	
	

}
