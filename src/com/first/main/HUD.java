package com.first.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HUD {

	public static float SCORE = 0;
	private String str = new String("");

	public void tick() {
		str = "";

		SCORE += 0.1f;
		str = "Score: " + String.format("%.0f", SCORE);

	}

	public void render(Graphics g) {
//		g.setColor(Color.gray);
//		g.fillRect(15, 15, 200, 20);
//		g.setColor(Color.green);
//		g.fillRect(15, 15, HEALTH * 2, 20);
//		g.setColor(Color.white);
//		g.drawRect(15, 15, 200, 20);
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.white);
		g.drawString(str, 15, 15);
	}

}
