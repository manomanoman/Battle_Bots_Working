package entity;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

import file.ImageLoader;
import mainStuff.Handler;


// This is the world which is created when the gamestate is created. This handles the updating and rendering for all entities

public class World {
	
	private Player player;
	private Handler handler;
	
	//This is the Entity LinkedList which stores all the current entities
	public static LinkedList<Entity> allThings = new LinkedList<Entity>();
	
	public World(Handler handler){
		this.handler = handler;
		this.player = new Player(handler,ImageLoader.loadImage("res\\base\\Base_Tier_1.png"), 100, 100, 64, 64);
		
		allThings.add(player);
		
	}
	
	// This loops through the linkedList and updates every entity in it
	public void update(){
		/*for (Entity e : allThings){
			e.update();
		}*/
		
		
		
		for (Iterator<Entity> kente = allThings.iterator() ; kente.hasNext();){
			Entity e  = kente.next();
			
			if (e.x <= 0 || e.x >= 1600 || e.y <= 0 || e.y >= 900){
				kente.remove();
			}
			e.update();
		}
		
		//System.out.println("Entities in game " + allThings.size());
	}
	
	// This loops through the linkedList and renders every entity in it
	public void render(Graphics g){
		/*for (Entity e : allThings){
			e.render(g);
		}*/
		
		for (Iterator<Entity> kente = allThings.iterator() ; kente.hasNext();){
			
			Entity e  = kente.next();
			e.render(g);
			
			
		}
		
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
