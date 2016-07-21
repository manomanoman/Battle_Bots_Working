package npcs;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entity.NPC;
import mainStuff.Handler;

public class Soldier extends NPC {

	public Soldier(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
		
		health = 100;
		speed = 5;
		range = 150;
		bulletSpeed = 10;
		bulletDamage = 25;
		
	}

	@Override
	public void update() {
		//	if(Math.sqrt((Soldier.x-Player.x)^2+(Soldier.y-Player.y)^2) < range) { // If the soldier is within the vicinity of the player
		//  soldier.x   //move soldier toward payer and shoot 
		//  }
		//	if (boundary of projectile touches soldier) {
		//  health -= projectileDamage;
		//	}
		
	}

	@Override
	public void render(Graphics g) { 
		
	}
	

}
