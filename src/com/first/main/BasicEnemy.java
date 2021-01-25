package com.first.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {

	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);

		velX = 5;
		velY = 5;

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

	}

	public void render(Graphics g) {
		g.setColor(Color.red);

		g.fillOval(x, y, 16, 16);

	}

}
