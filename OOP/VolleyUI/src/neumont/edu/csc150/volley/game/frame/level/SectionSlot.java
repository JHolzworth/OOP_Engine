package neumont.edu.csc150.volley.game.frame.level;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SectionSlot extends JPanel{
	
	private String name;
	private LevelSlotHolder slotHolder;
	private Font TITLE_FONT = new Font("Arial",1,25);
	private Color TITLE_COLOR = Color.black;
	
	public SectionSlot(String _name){
		super();
		name = _name;
		slotHolder = new LevelSlotHolder();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		
		JLabel nameLabel = new JLabel(name);
		nameLabel.setFont(TITLE_FONT);
		nameLabel.setForeground(TITLE_COLOR);
		nameLabel.setVisible(true);
		add(nameLabel);
		
		add(slotHolder);
		
		setVisible(true);
	}
	
	public String getName(){
		return name;
	}
	
	public void addSlot(LevelSlot ls){
		slotHolder.addLevelSlot(ls);
	}
}
