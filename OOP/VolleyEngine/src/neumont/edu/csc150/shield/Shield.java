package neumont.edu.csc150.shield;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

import neumont.edu.csc150.player.movement.MoveListener;
import neumont.edu.csc150.volley.Oval;

public class Shield extends Oval implements MoveListener, Serializable{

	protected int shellSize;
	protected int relay;
	protected int health;
	
	
	private static double SHIELD_OVERLAY = .3;
	
	public Shield(int _size, int _relay, int _playerSize, int _playerX, int _playerY){
		super(_playerX, _playerY, _playerSize);
		shellSize = _size;
		relay = _relay;
		init();
	}
	
	public Shield(int _size, int _relay, int _playerSize,Point _location){
		super(_location, _playerSize);
		shellSize = _size;
		relay = _relay;
		init();
	}
	
	private void init(){
		super.setBounds(getX(), getY(), getSize()+(int)(getSize()*SHIELD_OVERLAY));
		health = shellSize;
	}
	
	public int getShellSize(){
		return shellSize;
	}
	
	public void setShellSize(int _size){
		shellSize = _size;
	}
	
	public int getRelay(){
		return relay;
	}
	
	public void setRelay(int _relay){
		relay = _relay;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void reset(){
		health = shellSize;
	}
	
	public void setHealth(int _health){
		if(_health<0){
			_health=0;
			//if not recharging
				//start recharge - relay*
		}else{
			health = _health;
		}
	}
	
	public void takeDamage(int dmg){
		if(health>0){
			setHealth(health-dmg);
		}
	}
	
	public boolean isDepleted(){
		return health==0;
	}

	public void paint(Graphics g) {
		if(health>=0){
			g.setColor(new Color(.3f,.3f,.5f,.5f));
			super.paint(g);
		}
	}

	public void move(Point loc) {
		location = loc;
	}
}
