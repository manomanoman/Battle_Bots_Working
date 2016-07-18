package buttons;

import java.awt.Graphics;
import java.awt.Rectangle;

import mainStuff.Handler;
import states.State;

public class Button {

	private int x, y, width, height;

	private Handler handler;
	private State state;
	private Rectangle bounds;

	public Button(Handler handler, State state, int x, int y, int width, int height) {
		this.handler = handler;
		this.state = state;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.setBounds(new Rectangle(x,y,width,height));
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

}
