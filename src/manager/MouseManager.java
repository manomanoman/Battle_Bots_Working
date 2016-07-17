package manager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import mainStuff.Handler;
import states.StateManager;

public class MouseManager implements MouseListener,MouseMotionListener{
	
	private int mouseX,mouseY;
	
	private Handler handler;
	
	public MouseManager(Handler handler){
		this.handler = handler;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		
		
		System.out.println(mouseX + " " + mouseY);
		
		// Handles all the paths from the home screen
		
		if (StateManager.getCurrentState().equals(handler.getEngine().getMenuState())){
			if (mouseX >= 701 && mouseX <= 899 && mouseY >= 350 && mouseY <= 549){
				StateManager.setCurrentState(handler.getEngine().getGameState());			}
		} 
		if (StateManager.getCurrentState().equals(handler.getEngine().getMenuState())){
			if (mouseX >= 473 && mouseX <= 670 && mouseY >= 350 && mouseY <= 549){
				StateManager.setCurrentState(handler.getEngine().getSettingsState());	
			}
		}
		if (StateManager.getCurrentState().equals(handler.getEngine().getMenuState())){
			if (mouseX >= 923 && mouseX <= 1125 && mouseY >= 350 && mouseY <= 549){
				StateManager.setCurrentState(handler.getEngine().getInstructionsState());	
			}
		}
		
		//handles the return botton for the settings and instruction screen
		
		if (StateManager.getCurrentState().equals(handler.getEngine().getSettingsState())  || StateManager.getCurrentState().equals(handler.getEngine().getInstructionsState())){
			if (mouseX >= 1481 && mouseX <= 1581 && mouseY >= 17 && mouseY <= 113){
				StateManager.setCurrentState(handler.getEngine().getMenuState());	
			}
		}
		
		
		
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
		mouseX = e.getX();
		mouseY = e.getY();
		
		if (StateManager.getCurrentState().equals(handler.getEngine().getGameState())){
			handler.getEngine().getGameState().getWorld().getPlayer().shoot();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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

}
