package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import mainStuff.Handler;

public abstract class Entity {

	protected BufferedImage b;
	protected int x, y, width, height;
	protected Rectangle bounds;
	protected Handler handler;

	public Entity(Handler handler, BufferedImage b, int x, int y, int width, int height) {
		this.handler = handler;
		this.b = b;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.bounds = new Rectangle(x, y, width, height);
	}

	protected boolean isNPC;
	protected boolean isPlayer;
	protected boolean isSoldierA;
	protected boolean isSoldierB;
	protected boolean isObject;
	protected boolean isProjectile;
	protected boolean isCharacter;
	protected boolean isCrate;
	protected boolean isHillPad;


	protected boolean isCollision(Entity e) {

		if (e.equals(this)) {
			return false;
		}

		if (this.bounds.intersects(e.bounds)) {
			return true;
		}

		return false;

	}

	public abstract void update();

	public abstract void render(Graphics g);

}
