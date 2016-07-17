package states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SettingsState extends State{

	public SettingsState(BufferedImage b) {
		super(b);
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
