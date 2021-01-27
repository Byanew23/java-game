package com.first.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	int width, height;

	public Player(int width, int height, ID id, Handler handler) {
		super(width, height, id);
		this.handler = handler;
		this.width = width;
		this.height = height;

	}

	int x = (Game.WIDTH / 2) - width;
	int y = (Game.WIDTH / 2) - height;

	public Rectangle getBounds() {

		return new Rectangle(x, y, width, height);
	}

	public void tick() {
		x += velX;
		y += velY;

		// Window border detection
//		x = Game.clamp(x, 0, Game.WIDTH - 28);
//		y = Game.clamp(y, 0, Game.HEIGHT - 54);

		// If you touch the border
		if (x <= 0 || x >= Game.WIDTH - 28 || y <= 0 || y >= Game.HEIGHT - 54) {
			x = Game.WIDTH / 2 - width;
			y = Game.WIDTH / 2 - height;
			velX = 0;
			velY = 0;
			HUD.SCORE = 0;

		}

		collision();

	}

	// Handle collision with enemy
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.BasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// Collision code

				}
			}

		}
	}

	public void render(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(x, y, width, height);

	}

}
