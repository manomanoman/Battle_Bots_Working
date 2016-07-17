package states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class InstructionsState extends State{

	public InstructionsState(BufferedImage b) {
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
