package states;

public class StateManager {
	
	public static State currentState;

	public static State getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(State currentState) {
		StateManager.currentState = currentState;
	}
	
	

}
