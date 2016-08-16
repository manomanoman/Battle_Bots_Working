package manager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import file.ImageLoader;
import mainStuff.Handler;
import states.StateManager;
import entity.Player;
import entity.World;
import entity.Entity;
import entity.Mine;
import entity.Object;


public class AnimationManager extends Object{

	public int i = 0;
	public int j = 0;
	public int k = 0;
	public int n = 0;
	
	private BufferedImage AnimFrame;	
	boolean isExplosion = true;
	boolean isPlay = true;
	int delay = 0;
	int it = 0;
	int fRate = 7;
	//Explosion   -- OPTIMIZE WITH LOOP
	BufferedImage expAnim [] = {
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"1"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"2"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"3"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"4"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"5"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"6"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"7"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"8"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"9"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"10"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"11"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"12"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"13"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"14"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"15"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"16"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"17"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"18"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"19"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"20"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"21"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"22"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"23"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"24"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"25"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"26"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"27"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"28"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"29"+".png"),
			ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+"30"+".png"),
			};
	
	public AnimationManager(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		super(handler, b, x, y, width, height);
		if (isExplosion = true){
		AnimFrame = expAnim [0];
		}
		x = 200;
		y = 200;
		b = AnimFrame;
		// TODO Auto-generated constructor stub
		
		
		
//		for (int n= 0; n<5; n++){
//			i++;
//			explosion [n] = {ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+n+".png")};
//		}
	}
	
	//@Override
	public void playExplode(){
	
	
	//	int frame = 0;	
	//	for (int delay = 0; delay <= 90000000; delay++){
	//	if (frame < 30){	
	//	AnimFrame = expAnim [frame];	
	//	}
	//	if (delay/3000000 ==  0){	
	//	frame++;
	//	}
	//	if (delay == 90000000){
	//	isPlay = false;
	//	}
	//	}
		
	//	int delay = 0;
	//	int it = 0;
		
		if (isPlay == true){	
			
			
			if (delay < 5){
				AnimFrame = expAnim[0];
				delay++;
			}
			
			else if (delay >= 5 && delay <= 10){
				AnimFrame = expAnim[15];
				delay++;			
			}
			else{
				AnimFrame = expAnim[25];
				delay++;
				
				if(delay == 15){
				//	choco = 0;
					it ++;
				
					if (it == 10){
						isPlay = false;
					}
				}
			}
		}
		
	}
	
	@Override
	public void update() {
		for (Entity e : World.allThings){
			if (isPlay == true){	
				
				//OPTIMIZE WITH LOOP
				
				if (delay < fRate){
					AnimFrame = expAnim[0];
					delay++;
				}
				
				else if (delay >= 1*fRate && delay < 2*fRate){
					AnimFrame = expAnim[1];
					delay++;			
				}
				else if (delay >= 2*fRate && delay < 3*fRate){
					AnimFrame = expAnim[2];
					delay++;
				}
				else if (delay >= 3*fRate && delay < 4*fRate){
					AnimFrame = expAnim[3];
					delay++;
				}
				else if (delay >= 4*fRate && delay < 5*fRate){
					AnimFrame = expAnim[4];
					delay++;
				}
				else if (delay >= 5*fRate && delay < 6*fRate){
					AnimFrame = expAnim[5];
					delay++;
				}
				else if (delay >= 6*fRate && delay < 7*fRate){
					AnimFrame = expAnim[6];
					delay++;
				}
				else if (delay >= 7*fRate && delay < 8*fRate){
					AnimFrame = expAnim[7];
					delay++;
				}
				else if (delay >= 8*fRate && delay < 9*fRate){
					AnimFrame = expAnim[8];
					delay++;
				}
				else if (delay >= 9*fRate && delay < 10*fRate){
					AnimFrame = expAnim[9];
					delay++;
				}
				else if (delay >= 10*fRate && delay < 11*fRate){
					AnimFrame = expAnim[10];
					delay++;
				}
				else if (delay >= 11*fRate && delay < 12*fRate){
					AnimFrame = expAnim[11];
					delay++;
				}
				else if (delay >= 12*fRate && delay < 13*fRate){
					AnimFrame = expAnim[12];
					delay++;
				}
				else if (delay >= 13*fRate && delay < 14*fRate){
					AnimFrame = expAnim[13];
					delay++;
				}
				else if (delay >= 14*fRate && delay < 15*fRate){
					AnimFrame = expAnim[14];
					delay++;
				}
				else if (delay >= 15*fRate && delay < 16*fRate){
					AnimFrame = expAnim[15];
					delay++;
				}
				else if (delay >= 16*fRate && delay < 17*fRate){
					AnimFrame = expAnim[16];
					delay++;
				}
				else if (delay >= 17*fRate && delay < 18*fRate){
					AnimFrame = expAnim[17];
					delay++;
				}
				else if (delay >= 18*fRate && delay < 19*fRate){
					AnimFrame = expAnim[18];
					delay++;
				}
				else if (delay >= 19*fRate && delay < 20*fRate){
					AnimFrame = expAnim[19];
					delay++;
				}
				else if (delay >= 20*fRate && delay < 21*fRate){
					AnimFrame = expAnim[20];
					delay++;
				}
				else if (delay >= 21*fRate && delay < 22*fRate){
					AnimFrame = expAnim[21];
					delay++;
				}
				else if (delay >= 22*fRate && delay < 23*fRate){
					AnimFrame = expAnim[22];
					delay++;
				}
				else if (delay >= 23*fRate && delay < 24*fRate){
					AnimFrame = expAnim[23];
					delay++;
				}
				else if (delay >= 24*fRate && delay < 25*fRate){
					AnimFrame = expAnim[24];
					delay++;
				}
				else if (delay >= 25*fRate && delay < 26*fRate){
					AnimFrame = expAnim[25];
					delay++;
				}
				else if (delay >= 26*fRate && delay < 27*fRate){
					AnimFrame = expAnim[26];
					delay++;
				}
				else if (delay >= 27*fRate && delay < 28*fRate){
					AnimFrame = expAnim[27];
					delay++;
				}
				else if (delay >= 28*fRate && delay < 29*fRate){
					AnimFrame = expAnim[28];
					delay++;
				}
				else if (delay >= 29*fRate && delay < 30*fRate){
					AnimFrame = expAnim[29];
					delay++;
				}
				else if (delay >= 30*fRate){
				//	AnimFrame = null;
					World.listIterator.remove();
				}
				
				
			//		if(delay == 135){
					//	choco = 0;
			//			it ++;
					
		//				if (it == 10){
		//					isPlay = false;
				//		}
			//		}
				}
			}
			
	//	if (isPlay == true){
	//		isPlay = false;
	//	}
	
		//	else if (isPlay == false){
	//		AnimFrame = null;
	//		World.listIterator.remove();
	//		}
		
		}
	
	
	@Override
	public void render(Graphics g) {
	//	g.setColor(Color.green);
	//	g.fillRect(x, y, width, height);
		Graphics2D gg = (Graphics2D) g;
		g.drawImage(AnimFrame, x, y, null);
	}
	
//	public void playExplode() {
//		BufferedImage explosion [] = {ImageLoader.loadImage("res\\graphix\\explosion1\\expl"+n+".png")};
		
//	}

}



