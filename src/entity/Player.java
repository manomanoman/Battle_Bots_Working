package entity;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import file.ImageLoader;
import mainStuff.Handler;

public class Player extends Character{
	
	// Default Player width and height is 64x64
	
	private float mouseX,mouseY;
	private float m_RelX, m_RelY;
	private double theta;
	private int quadrant;
	
	//Player Stats
	private int health,maxHealth;
	private int stamina,maxStamina;
	private int armor,maxArmor;
	private int experience,maxExperience;
	
	private int projectileSpeed;
	private double pXvel;
	private double pYvel;
	
	//Regen Stats
	private int healthRegen;
	private int armorRegen;
	private int staminaRegen;
	
	
	private int speed;
	
	private Color healthColor = new Color(255,94,94);
	private Color armorColor = new Color(122,213,245);
	private Color staminaColor = new Color(250,248,140);
	private Color experiencecolor = new Color(129,247,133);
	
	// booleans
	private boolean turboActive = false;
	
	
	private BufferedImage ui = ImageLoader.loadImage("res\\screens\\user_bar.png");

	public Player(Handler handler,BufferedImage b, int x, int y, int width, int height) {
		super(handler,b, x, y, width, height);
		mouseX = 0;
		mouseY = 0;
		
		//regen rate
		healthRegen = 1;
		armorRegen = 1;
		staminaRegen = 1;
		
		//maximum stat
		maxHealth = 1000;
		maxStamina = 100;
		maxArmor = 500;
		maxExperience = 100;
		
		
		//current stats
		health = 1000;
		stamina = 100;
		armor = 100;
		experience = 100;
		projectileSpeed = 5;
		
		speed = 2;
	}

	@Override
	public void update() {
		
		adjustStats();
		
		//delete after
		if (x >= 500){
			
			
			if (armor > 0){
				armor -=3;
			}else{
				health-=5;
			}
			
		}
		//delete before
		
		//health and armor regen
		
		if (armor < maxArmor){
			armor += armorRegen;
		}
		if (health < maxHealth){
			health += healthRegen;
		}
		
		if (turboActive){
			
			if (stamina <= 0){
				turboActive = false;
			}
			
			speed = 4;
			stamina --;
		}
		
		if (!turboActive){
			speed = 2;
		}
		
		if (stamina < 100 && !turboActive){
			stamina+= staminaRegen;
		}
		
		
		if (handler.getKeyManager().shift && stamina == 100){
			turboActive = true;
		}
		
		
		move();
		
		mouseX = handler.getMouseManager().getMouseX();
		mouseY = handler.getMouseManager().getMouseY();
		m_RelX = x-mouseX + height/2; // Coordinates relative to center of player
		m_RelY = y-mouseY + height/2;
		
		if (m_RelY > 0 && m_RelX > 0){
			theta = Math.atan(m_RelY/m_RelX) + Math.PI;
			quadrant = 1;
		} else if (m_RelY > 0 && m_RelX < 0) {
			theta = Math.atan(m_RelY/m_RelX);
			quadrant = 2;
		} else if (m_RelY < 0 && m_RelX < 0) {
			theta = Math.atan(m_RelY/m_RelX);
			quadrant = 3;
		} else if (m_RelY < 0 && m_RelX > 0) {
			theta = Math.atan(m_RelY/m_RelX) + Math.PI;
			quadrant = 4;
		}
		
		
		
	}

	@Override
	public void render(Graphics g) {
		
		g.fillRect(500, 0, 1100, 900);
		
		// This rectangle represents the bounding box, aka what we will use to check collisions
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
		
		//User Info
		g.drawString("Player X " + x, 10, 10);
		g.drawString("Player Y " + y, 10, 25);
		g.drawString("MouseX " + mouseX, 10, 40);
		g.drawString("MouseY " + mouseY, 10, 55);
	
		
		AffineTransform playerRotation = AffineTransform.getTranslateInstance(x, y);
		if (mouseX == 0 || mouseY == 0){
			mouseX ++;
			mouseY++;
		}
		

		g.drawString("Theta " + Math.toDegrees(theta), 10, 65);		
		g.drawString("Mouse Relative Y" + m_RelY, 10, 75);	
		g.drawString("Mouse Relative X" + m_RelX, 10, 85);	
		g.drawString("Quandrant " + quadrant, 10, 95);				
		playerRotation.rotate(theta,32,32);
		
		Graphics2D gg = (Graphics2D) g;
		gg.drawImage(b,playerRotation,null);
		
		
		g.setColor(Color.red);
		
		//g.drawImage(b, x,y,null);
		
		// User Bar
		
		g.drawImage(ui,0,-15,1600,900,null);
		//Health
		g.setColor(healthColor);
		g.fillRect(59, 845, health*700/maxHealth, 5);
		//Armor
		g.setColor(armorColor);
		g.fillRect(59, 815, armor*700/maxArmor, 5);
		//Stamina
		g.setColor(staminaColor);
		g.fillRect(870, 845, stamina*700/maxStamina, 5);
		//Experience
		g.setColor(experiencecolor);
		g.fillRect(870, 815, experience*700/maxExperience, 5);
		
		
	}
	
	public void shoot(){
//		int barrelLength = 10;
//		double barrelTip_X = barrelLength*Math.cos(theta) + x-mouseX + 32;
//		double barrelTip_Y = barrelLength*Math.sin(theta) + y-mouseY + 32;
		//This is what pat coded, hell have to fix this eventually
		//Projectile p = new Projectile(handler, ImageLoader.loadImage("res\\entities\\object\\projectile\\projectile_1.png"), (int)barrelTip_X,(int) barrelTip_Y, 16, 16);
		Projectile p = new Projectile(handler, ImageLoader.loadImage("res\\entities\\object\\projectile\\projectile_1.png"),x+(width/2),y+(height/2), 16, 16);
		
		double[] unit_Vectors =  {m_RelX/Math.sqrt(m_RelY*m_RelY+m_RelX*m_RelX),m_RelY/Math.sqrt(m_RelY*m_RelY+m_RelX*m_RelX)};

		pXvel = projectileSpeed*unit_Vectors[0];
		pYvel = projectileSpeed*unit_Vectors[1]; 
	
		p.x += pXvel;
		p.y += pYvel;
		
		World.allThings.add(p);
		


		
	}
	
	public int getProjectileSpeed() {
		return projectileSpeed;
	}

	public void setProjectileSpeed(int projectileSpeed) {
		this.projectileSpeed = projectileSpeed;
	}

	public double getpXvel() {
		return pXvel;
	}

	public void setpXvel(double pXvel) {
		this.pXvel = pXvel;
	}

	public double getpYvel() {
		return pYvel;
	}

	public void setpYvel(double pYvel) {
		this.pYvel = pYvel;
	}

	private void move(){
		if (handler.getKeyManager().left){
			x-=speed;
		}
		if (handler.getKeyManager().right){
			x+=speed;
		}
		if (handler.getKeyManager().up){
			y-=speed;
		}
		if (handler.getKeyManager().down){
			y+=speed;
		}
	}
	
	// this method adjusts stats if they are over the maximum back to the maximum
	
	private void adjustStats(){
		if (stamina > maxStamina){
			stamina = maxStamina;
		}
		if (health > maxHealth){
			health = maxHealth;
		}
		if (armor > maxArmor){
			armor = maxArmor;
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getMaxStamina() {
		return maxStamina;
	}

	public void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}

	public int getMaxArmor() {
		return maxArmor;
	}

	public void setMaxArmor(int maxArmor) {
		this.maxArmor = maxArmor;
	}

	public int getMaxExperience() {
		return maxExperience;
	}

	public void setMaxExperience(int maxExperience) {
		this.maxExperience = maxExperience;
	}

	public int getStaminaRegen() {
		return staminaRegen;
	}

	public void setStaminaRegen(int staminaRegen) {
		this.staminaRegen = staminaRegen;
	}

	public int getArmorRegen() {
		return armorRegen;
	}

	public void setArmorRegen(int armorRegen) {
		this.armorRegen = armorRegen;
	}

	public int getHealthRegen() {
		return healthRegen;
	}

	public void setHealthRegen(int healthRegen) {
		this.healthRegen = healthRegen;
	}

}
