package neumont.edu.csc150.volley.menu.factory;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import neumont.edu.csc150.player.Player;
import neumont.edu.csc150.player.achievement.GainedAchievement;
import neumont.edu.csc150.player.volley.VolleyPlayer;
import neumont.edu.csc150.shield.Shield;

public class TextFileReader implements FileReader{

protected Color playerColor;
	
	
	/*
	protected int maxHealth, health;
	protected double speed;
	
	//TO MAKE A SHIELD
	protected int shellSize;
	protected int relay;
	protected int health;
	
	
	protected int immunityThresh;
	
	protected int points;
	
	
	private Collection<GainedAchievement> achievements;
	*/
	public Player readPlayer(File file) {
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		HashMap<String,Double> values = new HashMap<String,Double>();
		while(scan.hasNext()){
			values.put(scan.next().replace(":","").toLowerCase(), Double.parseDouble(scan.next()));
		}
		Point loc = new Point(values.get("x").intValue(),values.get("y").intValue());
		Shield s = new Shield(values.get("shieldsize").intValue(),values.get("shieldrelay").intValue(),values.get("size").intValue(),loc);
		Player p = new VolleyPlayer(loc,values.get("size").intValue(),Color.blue,values.get("health").intValue(),values.get("speed"),s,values.get("immune").intValue(),values.get("points").intValue(),new ArrayList<GainedAchievement>());
		
		//int value = Integer.parseInt(m.group(1));
		
		//System.out.println(value);
		
		return p;
	}

}
