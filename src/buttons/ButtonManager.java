package buttons;

import java.awt.Color;
import java.util.LinkedList;

import mainStuff.Handler;
import manager.MouseManager;
import states.StateManager;

public class ButtonManager {

	private Handler handler;

	
	//LinkedList which stores all the current button objects
	public static LinkedList<Button> buttons = new LinkedList<Button>();

	// buttons on the home screen
	public Button playButton,settingsButton,instructionsButton,exit1,exit2,pause,returnToGame,upgrades,shop;

	//ButtonManager constructor
	public ButtonManager(Handler handler) {
		this.handler = handler;

		//all buttons are initialized here
		
		//home screen buttons
		playButton = new Button(handler, handler.getEngine().getMenuState(), 700, 350, 200, 200);
		settingsButton = new Button(handler, handler.getEngine().getMenuState(), 472, 350, 200, 200);
		instructionsButton = new Button(handler, handler.getEngine().getMenuState(), 925, 350, 200, 200);
		
		//exit buttons
		exit1 = new Button(handler, handler.getEngine().getSettingsState(), 1480, 17, 100, 100);
		exit2 = new Button(handler, handler.getEngine().getInstructionsState(), 1480, 17, 100, 100);
		
		//gamestate buttons
		pause = new Button(handler,handler.getEngine().getGameState(),772,805,50,50);
		
		//paused state buttons
		returnToGame = new Button(handler,handler.getEngine().getPausedState(),596,560,400,75);
		upgrades = new Button(handler,handler.getEngine().getPausedState(),596,350,250,250);
		shop = new Button(handler,handler.getEngine().getPausedState(),811,350,250,250);
		
		
		//add the buttons to the linkedlist here
		buttons.add(playButton);
		buttons.add(settingsButton);
		buttons.add(instructionsButton);
		
		buttons.add(exit1);
		buttons.add(exit2);
		
		buttons.add(pause);
		
		buttons.add(returnToGame);
		buttons.add(upgrades);
		buttons.add(shop);
	}

	//method that loops through each button when the mouse is clicked and checks if you clicked on a button
	public void buttonHasBeenClicked(MouseManager m) {
		//this loops through every button
		for (Button b : buttons) {

			//simple coordinate comparison
			int mx = m.getMouseX();
			int my = m.getMouseY();

			int x1 = b.getBounds().x;
			int x2 = x1 + b.getBounds().width;

			int y1 = b.getBounds().y;
			int y2 = y1 + b.getBounds().height;
			
			//checks coordinates and if the States check out
			if (StateManager.getCurrentState().equals(b.getState()) && mx >= x1 && mx <= x2 && my >= y1 && my <= y2) {
				System.out.println("Click detected");
				buttonActionActivated(b);
			}
		}
	}

	//make shift switch statement because switch statements cant take in objects as a parameter
	private void buttonActionActivated(Button b) {
		
		//main menu state buttons
		if (b.equals(playButton)) {
			StateManager.setCurrentState(handler.getEngine().getGameState());
		}else if (b.equals(settingsButton)) {
			StateManager.setCurrentState(handler.getEngine().getSettingsState());
		}else if (b.equals(instructionsButton)) {
			StateManager.setCurrentState(handler.getEngine().getInstructionsState());
		}
		
		//exit buttons
		else if (b.equals(exit1)) {
			StateManager.setCurrentState(handler.getEngine().getMenuState());
		}else if (b.equals(exit2)) {
			StateManager.setCurrentState(handler.getEngine().getMenuState());
		}
		
		//game state buttons
		else if(b.equals(pause)){
			StateManager.setCurrentState(handler.getEngine().getPausedState());
		}
		
		//paused state buttons
		else if(b.equals(returnToGame)){
			StateManager.setCurrentState(handler.getEngine().getGameState());
		}else if(b.equals(upgrades)){
			StateManager.setCurrentState(handler.getEngine().getUpgradeScreenHome());
		}else if(b.equals(shop)){
			StateManager.setCurrentState(handler.getEngine().getShopState());
		}
		
	}

}
