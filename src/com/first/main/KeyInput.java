package com.first.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				// Key events for Player 1

				if (key == KeyEvent.VK_W)
					tempObject.setVelY(-5);
				if (key == KeyEvent.VK_S)
					tempObject.setVelY(5);
				if (key == KeyEvent.VK_A)
					tempObject.setVelX(-5);
				if (key == KeyEvent.VK_D)
					tempObject.setVelX(5);
			}

			else if (tempObject.getId() == ID.Player2) {
				// Key events for Player 2

				if (key == KeyEvent.VK_UP)
					tempObject.setVelY(-5);
				if (key == KeyEvent.VK_DOWN)
					tempObject.setVelY(5);
				if (key == KeyEvent.VK_LEFT)
					tempObject.setVelX(-5);
				if (key == KeyEvent.VK_RIGHT)
					tempObject.setVelX(5);
			}
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				// Key events for Player 1

				// Move up when W is pressed
				if (key == KeyEvent.VK_W)
					tempObject.setVelY(0);
				if (key == KeyEvent.VK_S)
					tempObject.setVelY(0);
				if (key == KeyEvent.VK_A)
					tempObject.setVelX(0);
				if (key == KeyEvent.VK_D)
					tempObject.setVelX(0);
			}

			else if (tempObject.getId() == ID.Player2) {
				// Key events for Player 2

				if (key == KeyEvent.VK_UP)
					tempObject.setVelY(0);
				if (key == KeyEvent.VK_DOWN)
					tempObject.setVelY(0);
				if (key == KeyEvent.VK_LEFT)
					tempObject.setVelX(0);
				if (key == KeyEvent.VK_RIGHT)
					tempObject.setVelX(0);
			}
		}

	}
}