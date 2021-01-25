package com.first.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1734389667665564376L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	// Create a thread to run the game on
	private Thread thread;
	private boolean running = false;

	// Creates a handler for the game objects
	private Handler handler;

	private Random r;

	public Game() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));

		new Window(WIDTH, HEIGHT, "Lets build a game!", this);

		r = new Random();

		handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player));
		handler.addObject(new BasicEnemy(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.BasicEnemy));

	}

	// Start the game
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	// Stop the game
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Game loop
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}

			// Update the window
			if (running) {
				render();
			}
			frames++;

			// Every second prints the Frames -> FPS
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		handler.tick();

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();

		// Create buffers if there are none
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		// Create graphics
		Graphics g = bs.getDrawGraphics();

		// Fill the canvas with a color
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);

		g.dispose();
		bs.show();

	}

	public static int clamp(int var, int min, int max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}

	public static void main(String[] args) {
		new Game();

	}

}
