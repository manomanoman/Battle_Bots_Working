package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mainStuff.Handler;

public abstract class NPC extends Character {

	protected int maxHealth_NPC;
	protected int health_NPC;
	protected int healthRegen;
	protected int speed;
	protected int range;
	protected int bulletSpeed;
	protected int bulletDamage;
	protected int bulletType;


	public NPC(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
	
	
}
