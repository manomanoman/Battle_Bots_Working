package tasks;

import entity.Player;

public abstract class Task {

	private int time;
	
	public Task(Player player){
		
	}
	
	public abstract void update();
	
}
