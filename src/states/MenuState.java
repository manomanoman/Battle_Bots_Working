package states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuState extends State{

	public MenuState(BufferedImage b) {
		super(b);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(b,0,0,1600,900,null);
	}

}
