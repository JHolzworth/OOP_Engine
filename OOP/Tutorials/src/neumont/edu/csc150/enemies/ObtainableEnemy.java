package neumont.edu.csc150.enemies;

import java.awt.Graphics;
import java.awt.Point;

import neumont.edu.csc150.Game;
import neumont.edu.csc150.enemy.Enemy;

public class ObtainableEnemy extends Enemy{

	public ObtainableEnemy(Point loc, int _size, int _health) {
		super(loc, _size, _health);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	protected boolean checkCollision() {
		return Game.getCurrentPlayer().isColliding(this);
	}

	@Override
	protected void actionForCollision() {
		takeDamage(1);
		Game.getCurrentPlayer().addPoints(1);
		System.out.println(Game.getCurrentPlayer().getPoints());
	}

	@Override
	protected void action() {
		
	}
	
	public void paint(Graphics g){
		g.setColor(OBTAINABLE);
		super.paint(g);
	}

}
