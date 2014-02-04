package neumont.edu.csc150.player.achievement;

import java.awt.Image;

public abstract class Achievable {
	private String name;
	private Image icon;
	
	public Achievable(String _name, Image _icon){
		name = _name;
		icon = _icon;
	}
	
	public String getName(){
		return name;
	}
	
	public Image getIcon(){
		return icon;
	}
	
	public boolean equals(Object o){
		boolean equal = false;
		if(o instanceof Achievable){
			if(name.equals(((Achievable) o).getName()))
				equal = true;
		}
		return equal;
	}
}
