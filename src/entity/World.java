package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import file.ImageLoader;
import mainStuff.Handler;
import manager.AnimationManager;
import npcs.Crate;
import npcs.SoldierA;
import npcs.SoldierB;
import entity.hillPad;


// This is the world which is created when the gamestate is created. This handles the updating and rendering for all entities

public class World {
	
	private Handler handler;
	
	//Characters
	private Player player;
	private SoldierA soldierA;
	private SoldierB soldierB;

	//Items
	private Crate crate;
	private ExpBox expBox;
	private HealthBox healthBox;
	private Mine mine;
	
	//Animations
	private AnimationManager explosion;
//	private AnimationManager napalm;
	
	//Environment
	private hillPad hillPad;
	
	// This is the Entity LinkedList which stores all the current entities
	public static LinkedList<Entity> allThings = new LinkedList<Entity>();
	public static ListIterator<Entity> listIterator = allThings.listIterator();

	public World(Handler handler) {
		this.handler = handler;
		// if GameMode = King of The Hill
		this.hillPad = new hillPad(handler, ImageLoader.loadImage("res\\entities\\object\\enviroment\\hillPad.png"), 700, 300, 250, 250);
		
		this.player = new Player(handler, ImageLoader.loadImage("res\\base\\Base_Tier_1.png"), 775, 350, 64, 64);
		this.healthBox = new HealthBox(handler, ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"20"+".png"), 100, 100, 32, 32);
		this.mine = new Mine(handler, ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Armed.png"), 350, 350, 32, 32);

	//	this.explosion = new AnimationManager(handler, ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"20"+".png"), 100, 100, 100, 100);
	//	allThings.add(explosion);
		
		allThings.add(player);
		allThings.add(hillPad);
		allThings.add(healthBox);
		allThings.add(mine);
	}

	// This loops through the linkedList and updates every entity in it
	public void update() {

		if ((int) (Math.random() * 100) == 0) {
			listIterator.add(new SoldierA(handler, ImageLoader.loadImage("res\\base\\Base_Tier_2.png"),
					440,440, 64, 64));
			listIterator.add(new SoldierB(handler, ImageLoader.loadImage("res\\base\\Base_Tier_3.png"),
					550,650, 64, 64));
			listIterator.add(new Crate(handler,ImageLoader.loadImage("res\\base\\crateBox.png"),
					(int) (Math.random()*1599+1), (int) (Math.random()*599+1), 36, 36));
			
		}
		
		

		for (listIterator = allThings.listIterator(); listIterator.hasNext();) {
			try {
				Entity e = listIterator.next();
				if (e.x <= 0 || e.x >= 1600 || e.y <= 0 || e.y >= 900) {
					listIterator.remove();

				}

				if (e.isPlayer) {
					Player ee = (Player) e;

					if (ee.getHealth() <= 0) {
						listIterator.remove();
					}
				}

				if (e.isNPC) {
					NPC ee = (NPC) e;

					if (ee.getHealth() <= 0) {
						ee.die();
						listIterator.remove();
						if (ee.isCrate) {
							
							double rew = 9*Math.random()+1;
							if (rew >= 7){
							listIterator.add(new ArmorBox(handler, ImageLoader.loadImage("res\\base\\armorBox.png"), e.x, e.y, 32, 32));
							}
							else if (rew > 3 && rew < 7){
							listIterator.add(new HealthBox(handler, ImageLoader.loadImage("res\\base\\healthBox.png"), e.x, e.y, 32, 32));	
							}
							else if (rew <= 3){
							listIterator.add(new Mine(handler, ImageLoader.loadImage("res\\entities\\object\\projectile\\mine_Armed.png"), e.x, e.y, 32, 32));
							}
						}
					}
					
				}

				e.update();

			} catch (ConcurrentModificationException e) {
				System.out.println("Java conccurent modification error in world.java");
			}

		}

	}

	// This loops through the linkedList and renders every entity in it
	public void render(Graphics g) {

		for (listIterator = allThings.listIterator(); listIterator.hasNext();) {
			Entity e = listIterator.next();

			e.render(g);
		}

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public SoldierA getSoldierA() {
		return soldierA;
	}

	public void setPlayer(SoldierA soldierA) {
		this.soldierA = soldierA;
	}
	
	public SoldierB getSoldierB() {
		return soldierB;
	}

	public void setPlayer(SoldierB soldierB) {
		this.soldierB = soldierB;
	}

	public ListIterator<Entity> getListIterator() {
		return listIterator;
	}

	public void setListIterator(ListIterator<Entity> listIterator) {
		this.listIterator = listIterator;
	}

	public AnimationManager getExplosion() {
		return explosion;
	}

	public void setExplosion(AnimationManager explosion) {
		this.explosion = explosion;
	}

}
