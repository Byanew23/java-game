package com.first.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {

	private Handler handler;

	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		velX = 5;
		velY = 5;
		this.handler = handler;

	}

	public Rectangle getBounds() {

		return new Rectangle(x, y, 14, 14);
	}

	public void tick() {
		x += velX;
		y += velY;

		// Window boundary detection
		if (y <= 0 || y >= Game.HEIGHT - 60)
			velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 32)
			velX *= -1;

		handler.addObject(new Trail(x, y, 16, 16, Color.red, 0.06f, ID.Trail, handler));

	}

	public void render(Graphics g) {
		g.setColor(Color.red);

		g.fillOval(x, y, 16, 16);

	}

}
