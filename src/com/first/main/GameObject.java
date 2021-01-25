package com.first.main;

import java.awt.Graphics;

public abstract class GameObject {

	// Position f the game object
	protected int x, y;

	// Create id
	protected ID id;

	// Speed for the game object
	protected int velX, velY;

	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	// Setters
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	// Getters
	public int getX() {
		return y;
	}

	public int getY() {
		return y;
	}

	public ID getId() {
		return id;
	}

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}

}
