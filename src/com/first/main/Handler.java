package com.first.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();

	public void tick() {
		for (int i = 0; i < object.size(); i++) {

			GameObject tempObject = object.get(i);

			tempObject.tick();

		}

	}

	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);

			tempObject.render(g);
		}

	}

	// Add an object into the list
	public void addObject(GameObject object) {
		this.object.add(object);
	}

	// Removes an object from the list
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

}
