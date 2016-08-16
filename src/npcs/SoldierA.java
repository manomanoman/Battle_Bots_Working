package npcs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.NPC;
import file.ImageLoader;
import mainStuff.Handler;
import settings.AdminSettings;
import manager.NPCManager;


public class SoldierA extends NPC {

	public SoldierA(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height,25);
		
		isSoldierA = true;
		
		maxHealth = 25;
		health = 25;
		healthRegen = 5;
		speed = 5;
		range = 150;
		bulletSpeed = 10;
		bulletDamage = 25;
		
	}

//	//private BufferedImage ui = ImageLoader.loadImage("res\\screens\\NPC_healthBar.png");
	
	@Override
	public void update() {
		this.x -= 2;
		this.y -= 2 * Math.random();
		
		bounds.x = x;
		bounds.y = y;	
		
	//	NPCManager.shootPlayer();
		
		
		//	if(Math.sqrt((Soldier.x-Player.x)^2+(Soldier.y-Player.y)^2) < range) { // If the soldier is within the vicinity of the player
		//  soldier.x   //move soldier toward payer and shoot 
		//  }
//		if(entity.Projectile.this.equals(bounds))
			
		
	}

	@Override
	public void render(Graphics g) { 
		
		// Soldier
		
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
		g.drawImage(b,x,y,width,height,null);
		
		g.setColor(Color.green);
		g.fillRect(x+(width/2)-(health/2), y+height+15, health, 5);
	}
	
	@Override
	public void die() {
		handler.getEngine().getGameState().getWorld().getPlayer().setExperience(handler.getEngine().getGameState().getWorld().getPlayer().getExperience()+xp);
		handler.getEngine().getGameState().getWorld().getPlayer().setCash(handler.getEngine().getGameState().getWorld().getPlayer().getCash()+25);
	}
	
	public int getSoldierAx(){
		return x;
	}
	public int getSoldierAy(){
		return y;
	}
	
	private void adjustStats(){

		if (health > maxHealth){
			health = maxHealth;
		}
//		if (armor > maxArmor){  // For higher lvl NPCs
//			armor = maxArmor;
		}

	
	}

