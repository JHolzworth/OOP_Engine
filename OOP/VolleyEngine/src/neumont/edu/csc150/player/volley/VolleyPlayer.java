package neumont.edu.csc150.player.volley;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

import neumont.edu.csc150.player.Player;
import neumont.edu.csc150.player.achievement.GainedAchievement;
import neumont.edu.csc150.shield.Shield;
import neumont.edu.csc150.volley.Oval;

public class VolleyPlayer extends Player{

	public boolean immune;

	public VolleyPlayer(Point _location, int _size, Color _playerColor, int _health, double _speed, Shield _shield, int _immuneThresh,int _points, Collection<GainedAchievement> _achievements ) {
		super(_location, _size, _playerColor, _health, _speed, _shield, _immuneThresh, _points, _achievements );
		init();
	}
	
	public VolleyPlayer(int _x, int _y, int _size, Color _playerColor, int _health, double _speed, Shield _shield, int _immuneThresh,int _points, Collection<GainedAchievement> _achievements) {
		super(_x,_y, _size, _playerColor, _health, _speed, _shield, _immuneThresh, _points, _achievements);
		init();
	}
	
	private void init(){
		immune = false;
	}
	
	public boolean isColliding(Oval oval){
		boolean colliding = super.isColliding(oval);
		if(!shield.isDepleted()){
			colliding = colliding | shield.isColliding(oval);
		}
		return colliding;
	}
	
	public boolean contains(Point _location){
		boolean contains = super.contains(_location);
		if(!shield.isDepleted()){
			contains = contains | shield.contains(_location);
		}
		return contains;
	}
	
	public void takeDamage(int dmg) {
		if(!shield.isDepleted()){
			shield.takeDamage(dmg);
		}else{
			if(!immune){
				setHealth(health-dmg);
				//turn immune for immunity delay
				immunator = new Thread(new Runnable(){
					public void run(){
						immune = true;
						try {
							Timer t= new Timer();
							for(int i=0;i<immunityThresh;i+=75){
								t.schedule(new TimerTask(){

									public void run() {
										blink = !blink;
									}
									
								},i);
							}
							immunator.sleep(immunityThresh);
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						immune = false;
						blink = false;
					}
				});
				immunator.start();
			}
		}
	}
	private boolean blink = false;
	private Thread immunator;

	public void paint(Graphics g){
		if(immune){
			if(blink)
				playerColor = new Color(0f,0f,1f,.3f);
			else
				playerColor = new Color(0f,0f,1f,1f);
		}else
			playerColor = new Color(0f,0f,1f,1f);
		super.paint(g);
	}
}
