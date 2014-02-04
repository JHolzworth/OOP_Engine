package neumont.edu.csc150.volley.game.frame.level;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class LevelSlotHolder extends JPanel{
	public LevelSlotHolder(){
		super();
		setLayout(new GridBagLayout());
		
		x = 0;
		y = 0;
		
		setVisible(true);
	}
	
	private int COL_SIZE = 2;
	private int x,y;
	
	public void addLevelSlot(LevelSlot levSlot){
		GridBagConstraints bgCon = new GridBagConstraints();
		bgCon.gridx = x;
		bgCon.gridy = y;
		bgCon.ipadx = 30;
		bgCon.ipady = 30;
		add(levSlot,bgCon);
		
		x++;
		if(x==COL_SIZE){
			x=0;
			y++;
		}
	}
}
