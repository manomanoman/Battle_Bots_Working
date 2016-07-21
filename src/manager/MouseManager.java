package manager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import mainStuff.Handler;
import states.StateManager;

public class MouseManager implements MouseListener,MouseMotionListener{
	
	private int mouseX,mouseY;
	private boolean mouse1Held;
	
	
	private Handler handler;
	
	public MouseManager(Handler handler){
		this.handler = handler;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		mouseX = e.getX();
		mouseY = e.getY();
		
		
		
		System.out.println(mouseX + " " + mouseY);
		
		handler.getEngine().getButtonManager().buttonHasBeenClicked(this);
		
		
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		mouse1Held = true;
		
		mouseX = e.getX();
		mouseY = e.getY();
		
		handler.getEngine().getButtonManager().buttonHasBeenClicked(this);
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		mouse1Held = false;
		
		mouseX = e.getX();
		mouseY = e.getY();
		
		
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}
	
	
	public int getMouseY() {
		return mouseY;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

	public int getMouseX() {
		return mouseX;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public boolean isMouse1Held() {
		return mouse1Held;
	}

	public void setMouse1Held(boolean mouse1Held) {
		this.mouse1Held = mouse1Held;
	}

}
