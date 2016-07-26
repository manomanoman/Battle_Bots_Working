package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mainStuff.Handler;

public abstract class NPC extends Character {

	protected int maxHealth;
	protected int health;
	protected int healthRegen;
	protected int speed;
	protected int range;
	protected int bulletSpeed;
	protected int bulletDamage;
	protected int bulletType;


	public NPC(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
		// TODO Auto-generated constructor stub
		isNPC = true;
	}


	public int getMaxHealth() {
		return maxHealth;
	}


	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public int getHealthRegen() {
		return healthRegen;
	}


	public void setHealthRegen(int healthRegen) {
		this.healthRegen = healthRegen;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getRange() {
		return range;
	}


	public void setRange(int range) {
		this.range = range;
	}


	public int getBulletSpeed() {
		return bulletSpeed;
	}


	public void setBulletSpeed(int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}


	public int getBulletDamage() {
		return bulletDamage;
	}


	public void setBulletDamage(int bulletDamage) {
		this.bulletDamage = bulletDamage;
	}


	public int getBulletType() {
		return bulletType;
	}


	public void setBulletType(int bulletType) {
		this.bulletType = bulletType;
	}
	
	
	

	
	
	
	
}
