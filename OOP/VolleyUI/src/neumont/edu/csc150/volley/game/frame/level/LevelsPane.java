package neumont.edu.csc150.volley.game.frame.level;

import java.util.Collection;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import neumont.edu.csc150.level.Level;

public class LevelsPane extends JPanel{

	public LevelsPane(Collection<Level> allLevels){
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		
		//TODO
		//Need a way to presist this...FAIL josh fucking fail...
		HashMap<String, SectionSlot> sections = new HashMap<String,SectionSlot>();
		
		for(Level l : allLevels){
			if(!sections.containsKey(l.getSection())){
				sections.put(l.getSection(), new SectionSlot(l.getSection()));
			}
			SectionSlot currentSlot = sections.get(l.getSection());
			currentSlot.addSlot(new LevelSlot(l));
			
		}
		
		for(String s : sections.keySet()){
			add(sections.get(s));
		}
		
		setVisible(true);
	}
}