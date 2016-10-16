package com.minime;

public class Tree {
	
	//Constructor: constructs a Tree object
	public Tree() {
		this.points = 5;
		this.height = 10;
		this.color = 10;
	}
	
	//number of points the tree has
	int points;
	
	//height of the tree
	int height;
	
	//color of tree
	int color;

	//getters and setters
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
}
