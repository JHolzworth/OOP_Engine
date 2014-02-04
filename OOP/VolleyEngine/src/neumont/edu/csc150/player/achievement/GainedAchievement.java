package neumont.edu.csc150.player.achievement;

import java.awt.Image;
import java.util.Date;

public class GainedAchievement extends Achievable{

	private Date completed;
	
	
	public GainedAchievement(String _name, Image _icon, Date _completed) {
		super(_name, _icon);
		completed = _completed;
	}
	
	public Date getDate(){
		return completed;
	}

}
