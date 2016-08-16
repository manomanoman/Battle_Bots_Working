package npcs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.ArmorBox;
import entity.NPC;
import entity.World;
import file.ImageLoader;
import mainStuff.Handler;
import settings.AdminSettings;


public class Crate extends NPC {

	public BufferedImage cP;	
	int cash;
	
	public Crate(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height, 5);
		
		isCrate = true;
		
		double crate = Math.random()*99+1;
		
		if (crate < 33){
		maxHealth = 25;
		health = 25;
		cash = 25;
		xp = 25;
		cP = ImageLoader.loadImage("res\\base\\crateBox.png");
		}
		
		else if(crate >= 33 && crate < 66){
		maxHealth = 50;
		health = 50;	
		cash = 50;
		xp = 50;
		cP = ImageLoader.loadImage("res\\base\\crateBox2.png");
		}
		
		else if(crate >= 66){
		maxHealth = 100;
		health = 100;	
		cash = 100;
		xp = 100;
		cP = ImageLoader.loadImage("res\\base\\crateBox3.png");
		}
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void die() {
		
		//Spawn a ArmorBox/HealthBox/CashBox/etc. chosen at random
		
		
		
		//World.listIterator.add(new ArmorBox(handler, ImageLoader.loadImage("res\\base\\armorBox.png"), x, y, 32, 32));
		
		handler.getEngine().getGameState().getWorld().getPlayer().setExperience(handler.getEngine().getGameState().getWorld().getPlayer().getExperience()+xp);
		handler.getEngine().getGameState().getWorld().getPlayer().setCash(handler.getEngine().getGameState().getWorld().getPlayer().getCash()+cash);
	
	
	}

	@Override
	public void update() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		if (AdminSettings.boundingBox == true){
			g.setColor(Color.red);
			g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
		// User Bar
		Color healthColor = new Color(255,94,94);
		
		//Health
		g.setColor(healthColor);
		g.fillRect(59, 845, health*700/maxHealth, 5);
		
		//draws image
		Graphics2D gg = (Graphics2D) g;
		g.drawImage(cP,x,y,width,height,null);
		
		g.setColor(Color.green);
		g.fillRect(x+(width/2)-(health/2), y+height+15, health, 5);
		
		
	}

	

}
