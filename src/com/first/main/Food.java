package com.first.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Food extends GameObject {
	Handler handler;
	Random r;
	int x, y;
	int width = 10, height = 10;

	public Food(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.r = new Random();
		this.x = r.nextInt(Game.WIDTH - 20);
		this.y = r.nextInt(Game.HEIGHT - 50);
		this.handler = handler;

	}

	public void tick() {

		collision();
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);

	}

	public Rectangle getBounds() {

		return new Rectangle(x, y, width, height);
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// Collision code
					handler.removeObject(this);
					handler.addObject(new Food(0, 0, ID.Food, handler));
					HUD.SCORE += 10;

				}
			}

		}
	}

}
