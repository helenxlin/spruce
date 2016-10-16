package com.minime;

import java.util.Random;

public class IntegrationFunctions {

	public void sunlight(Tree tree, long time) {
		int points1 = tree.getPoints();
		int points2 = tree.getPoints();
		if (time<12 || time>24) {
			points2 = tree.getPoints();
			points2 = points2 - 10;
			tree.setPoints(points2);
		}
		else if (time>=12 && time<=24) {
			points2 = tree.getPoints();
			points2 = points2 + 10;
			tree.setPoints(points2);
		}
		
		height(points1, points2, tree);
		color(points1, points2, tree);
	}
	
	public void rain(Tree tree, long time) {
		int points1 = tree.getPoints();
		int points2 = tree.getPoints();
		if (time<6 || time>12) {
			points2 = tree.getPoints();
			points2 = points2 - 10;
			tree.setPoints(points2);
		}
		else if (time>=6 && time<=12) {
			points2 = tree.getPoints();
			points2 = points2 + 10;
			tree.setPoints(points2);
		}
		
		height(points1, points2, tree);
		color(points1, points2, tree);
	}
	
	private void temperature(Tree tree, long temperature, long time) {
		int points1 = tree.getPoints();
		int points2 = tree.getPoints();
		if ((temperature<15 || temperature>25) && time>8) {
			points2 = points2 - 3;
		}
		else if (temperature>=15 && temperature<=25 && time>8){
			points2 = points2 + 3;
		}
		
		height(points1, points2, tree);
		color(points1, points2, tree);
	}
	
	public boolean dead(Tree tree) {
		int points = tree.getPoints();
		if (points<=0) {
			System.out.print("your tree is dead... :(");
			return true;
		}
		else return false;
	}
	
	public boolean completed(Tree tree) {
		int points = tree.getPoints();
		if (points>=100) {
			System.out.print("you've finished the game!! :)");
			return true;
		}
		else return false;
	}
	
	private void height(int points1, int points2, Tree tree) {
		if (points2>points1) {
			int growth = points2-points1;
			growth = growth*2;
			int height = tree.getHeight();
			height = height + growth;
			tree.setHeight(height);
		}
	}
	
	private void color(int points1, int points2, Tree tree) {
		int growth = points2-points1;
		growth = growth*2;
		int color = tree.getColor();
		color = color + growth;
		if (color>100) {
			color = 100;
		}
		tree.setColor(color);
	}
	
	public void addToBank(BankAccount x, int addedMoney) {
		int currentMoney = x.getMoney();
		x.setMoney(currentMoney+addedMoney);
	}
	public void subtractFromBank(BankAccount x, int subtractedMoney) {
		int currentMoney = x.getMoney();
		x.setMoney(currentMoney-subtractedMoney);
	}
	
	public String displayGoals() {
		return "Save $100 by the end of this week!!";
	}
	
	public BankAccount createBank() {
		BankAccount bankAccount = new BankAccount();
		return bankAccount;
	}
	
	public int RNG(int x, int y) {
		Random rand = new Random();
		int n = rand.nextInt(x) + y;
		return n;
	}
	
}
