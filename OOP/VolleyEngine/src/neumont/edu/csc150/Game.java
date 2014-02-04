package neumont.edu.csc150;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import neumont.edu.csc150.level.Level;
import neumont.edu.csc150.player.Player;
import neumont.edu.csc150.player.achievement.GainedAchievement;
import neumont.edu.csc150.player.volley.VolleyPlayer;
import neumont.edu.csc150.shield.Shield;

public class Game implements Serializable{

	
	private static Player NEW_PLAYER = new VolleyPlayer(0,0,25,Color.blue,5,3,new Shield(5, 1, 25, new Point(0,0)),1,0,new ArrayList<GainedAchievement>());
	
	private static Player currentPlayer;
	private static Collection<Level> allLevels;
	
	public static void setPlayer(Player _player){
		currentPlayer = _player;
	}
	
	
	public static void setLevels(Collection<Level> _levels){
		allLevels = _levels;
	}
	public static Collection<Level> getLevels(){
		return allLevels;
	}
	
	public static Player getCurrentPlayer(){
		return currentPlayer;
	}
	
	public static Player getNewPlayer(){
		return NEW_PLAYER;
	}
}
