package states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UpgradeScreenHome extends State{

	public UpgradeScreenHome(BufferedImage b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(b,0,0,1600,900,null);
		
	}

}
