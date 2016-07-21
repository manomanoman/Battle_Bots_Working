package entity;

import java.awt.Graphics;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import file.ImageLoader;
import mainStuff.Handler;


// This is the world which is created when the gamestate is created. This handles the updating and rendering for all entities

public class World {
	
	private Player player;
	private Handler handler;
	
	private ExpBox xb;
	
	//This is the Entity LinkedList which stores all the current entities
	public static LinkedList<Entity> allThings = new LinkedList<Entity>();
	private ListIterator<Entity> listIterator = allThings.listIterator();
	
	public World(Handler handler){
		this.handler = handler;
		this.player = new Player(handler,ImageLoader.loadImage("res\\base\\Base_Tier_1.png"), 100, 100, 64, 64);
		xb = new ExpBox(handler, null, 200, 200, 15, 15);
		allThings.add(player);
		allThings.add(xb);
		
	}
	
	// This loops through the linkedList and updates every entity in it
	public void update() {

		for (listIterator = allThings.listIterator(); listIterator.hasNext();) {
			try{
			Entity e = listIterator.next();
			if (e.x <= 0 || e.x >= 1600 || e.y <= 0 || e.y >= 900) {
				listIterator.remove();

			}
			e.update();
			}catch(ConcurrentModificationException e){
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
