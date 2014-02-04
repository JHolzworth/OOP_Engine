package neumont.edu.csc150.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import neumont.edu.csc150.level.Level;
import neumont.edu.csc150.player.achievement.GainedAchievement;
import neumont.edu.csc150.player.movement.MoveListener;
import neumont.edu.csc150.shield.Shield;
import neumont.edu.csc150.volley.Oval;

public abstract class Player extends Oval implements Serializable {

	
	
	//TODO
	//Find a way to strip this into a separate class
	//Because enemies need to be drawn too
	protected Color playerColor;
	
	
	
	protected int maxHealth, health;
	protected double speed;
	protected Shield shield;
	protected int immunityThresh;
	
	protected int points;
	
	private Collection<MoveListener> moveListeners;
	private Collection<GainedAchievement> achievements;
	
	private Collection<Level> levels;
	
	
	public Player(Point _location, int _size, Color _playerColor, int _health, double _speed, Shield _shield, int _immuneThresh, int _points, Collection<GainedAchievement> _achievements) {
		super(_location, _size);
		playerColor = _playerColor;
		maxHealth = _health;
		speed = _speed;
		shield = _shield;
		immunityThresh = _immuneThresh;
		achievements = _achievements;
		points = _points;
		init();
	}
	
	public Player(int _x, int _y, int _size, Color _playerColor, int _health, double _speed, Shield _shield, int _immuneThresh, int _points, Collection<GainedAchievement> _achievements)  {
		super(_x,_y, _size);
		playerColor = _playerColor;
		maxHealth = _health;
		speed = _speed;
		shield = _shield;
		immunityThresh = _immuneThresh;
		achievements = _achievements;
		points = _points;
		init();
	}
	
	private void init(){
		moveListeners = new ArrayList<MoveListener>(0);
		addMoveListener(shield);
		health = maxHealth;
	}
	
	public void addMoveListener(MoveListener moveListener){
		moveListeners.add(moveListener);
	}
	
	public void removeMoveListener(MoveListener moveListener){
		moveListeners.add(moveListener);
	}
	
	public void setLocation(Point loc){
		super.setLocation(loc);
		moved(loc);
	}
	
	public void setLocation(int _x, int _y){
		super.setLocation(_x,_y);
		moved(new Point(_x,_y));
	}
	
	private void moved(Point loc){
		for(MoveListener ml : moveListeners){
			ml.move(loc);
		}
	}
	
	public Color getColor(){
		return playerColor;
	}
	
	public int getMaxHealth(){
		return maxHealth;
	}
	public int getHealth(){
		return health;
	}
	
	public void setHealth(int _health){
		if(_health<0){
			health=0;
		}
		else{
			health = _health;
		}
	}
	
	public double getSpeed(){
		return speed;
	}
	
	public void setSpeed(double _speed){
		speed = _speed;
	}
	
	public Shield getShield(){
		return shield;
	}
	
	public void setShield(Shield _shield){
		shield = _shield;
	}
	
	public int getImmuneThresh(){
		return immunityThresh;
	}
	
	public void setImmuneThresh(int _immuneThresh){
		immunityThresh = _immuneThresh;
	}
	
	public void setPoints(int _pnts){
		points = _pnts;
	}
	
	public void addPoints(int _pnts){
		points+=_pnts;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void paint(Graphics g){
		shield.paint(g);
		g.setColor(playerColor);
		super.paint(g);
	}
	
	public Collection<GainedAchievement> getAchievements(){
		return achievements;
	}
	
	public void setAchievements(Collection<GainedAchievement> _achievs){
		achievements  = _achievs;
	}
	
	public abstract void takeDamage(int _dmg);
	
	public void reset(){
		health = maxHealth;
		shield.reset();
	}
	
}
