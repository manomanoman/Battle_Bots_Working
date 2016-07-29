package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import file.ImageLoader;
import mainStuff.Handler;
import npcs.Soldier;

// This is the world which is created when the gamestate is created. This handles the updating and rendering for all entities

public class World {

	
	private Handler handler;
	
	//Characters
	private Player player;
	private Soldier soldier;

	//Items
	private ExpBox expBox;
	private HealthBox healthBox;
	private ArmorBox armorBox;
	private mine mine;


	// This is the Entity LinkedList which stores all the current entities
	public static LinkedList<Entity> allThings = new LinkedList<Entity>();
	public static ListIterator<Entity> listIterator = allThings.listIterator();

	public World(Handler handler) {
		this.handler = handler;
		this.player = new Player(handler, ImageLoader.loadImage("res\\base\\Base_Tier_1.png"), 100, 100, 64, 64);
		this.armorBox = new ArmorBox(handler, ImageLoader.loadImage("res\\base\\armorBox.png"), 400, 400, 32, 32);
		this.healthBox = new HealthBox(handler, ImageLoader.loadImage("res\\base\\healthBox.png"), 300, 300, 32, 32);
		this.mine = new mine(handler, ImageLoader.loadImage("res\\base\\healthBox.png"), 350, 350, 32, 32);
		allThings.add(player);
		allThings.add(armorBox);
		allThings.add(healthBox);
		allThings.add(mine);
	}

	// This loops through the linkedList and updates every entity in it
	public void update() {

		if ((int) (Math.random() * 100) == 0) {
			listIterator.add(new Soldier(handler, ImageLoader.loadImage("res\\base\\Base_Tier_2.png"),
					(int) (Math.random() * 600), (int) (Math.random() * 600), 64, 64));
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

	public ListIterator<Entity> getListIterator() {
		return listIterator;
	}

	public void setListIterator(ListIterator<Entity> listIterator) {
		this.listIterator = listIterator;
	}

}
