package states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class OffensiveUpgradeScreen extends State{

	public OffensiveUpgradeScreen(BufferedImage b) {
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
