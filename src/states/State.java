package states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class State {
	
	protected BufferedImage b;
	
	public State(BufferedImage b){
		this.b = b;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);

}
