package states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entity.World;
import mainStuff.Handler;

public class GameState extends State{

	private World world;
	
	private Handler handler;
	
	
	
	public GameState(Handler handler,BufferedImage b) {
		super(b);
		this.handler = handler;
		world = new World(handler);
	}

	
	
	@Override
	public void update() {
		world.update();
	}

	@Override
	public void render(Graphics g) {
		
		world.render(g);
		
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
