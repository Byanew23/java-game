package com.first.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {

	private float alpha = 1;
	float life;
	private Handler handler;
	private Color color;

	private int width, height;

	// life = 0.001 - 0.1

	public Trail(int x, int y, int width, int height, Color color, float life, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}

	public void tick() {
		if (alpha > life) {
			alpha -= life - 0.001f;
		} else
			handler.removeObject(this);

	}

	public void render(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.setComposite(makeTransparent(alpha));

		g.setColor(color);
		g.fillOval(x, y, width, height);

		g2d.setComposite(makeTransparent(1));

	}

	// Renders out the transparency in the trail
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;

		return (AlphaComposite.getInstance(type, alpha));
	}

	public Rectangle getBounds() {

		return null;
	}

}
