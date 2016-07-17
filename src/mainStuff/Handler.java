package mainStuff;
import manager.KeyManager;
import manager.MouseManager;

public class Handler {
	
	private Engine e;
	
	// This is the handler, if you want to access something in the folder through a handler, create a getter in here
	
	public Handler(Engine e){
		this.e = e;
	}
	
	public KeyManager getKeyManager(){
		return e.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return e.getMouseManager();
	}

	public Engine getEngine(){
		return e;
	}
}
