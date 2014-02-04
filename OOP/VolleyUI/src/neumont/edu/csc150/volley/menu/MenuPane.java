package neumont.edu.csc150.volley.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import neumont.edu.csc150.Game;
import neumont.edu.csc150.level.Level;
import neumont.edu.csc150.levels.FlickerLevel;
import neumont.edu.csc150.levels.FogLevel;
import neumont.edu.csc150.levels.MixLevel;
import neumont.edu.csc150.levels.ObtainableLevel;
import neumont.edu.csc150.player.achievement.GainedAchievement;

public class MenuPane extends JPanel implements DeleteListener{

	
	private Collection<MenuSlot> slots;
	public static File SAVE_FILE;
	
	public MenuPane(){
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		
		slots = new ArrayList<MenuSlot>();
		//Read in the files here...
		slots.add(new TitleSlot());
		
		String file = "sav";
		String fileExten = ".vsav";
		
		
		for(int i=1;i<5;i++){
			if(new File(file+i+fileExten).exists()){
				try{
					//TODO must throw
					//custom file is blank exception
					SaveSlot ss = new SaveSlot(new File(file+i+fileExten));
					ss.addListener(this);
					slots.add(ss);
				}catch(Exception e){
					slots.add(new NewSlot(new File(file+i+fileExten)));
				}
				
			}
			else
				slots.add(new NewSlot(new File(file+i+fileExten)));
		}
		
		
		
		
		
		
		
		
		
		Collection<GainedAchievement> achievs = new ArrayList<GainedAchievement>();
		//Player p = new VolleyPlayer(0,0,25,Color.cyan,5,3,new Shield(3,1,25,0,0),1, achievs);
		
		Collection<Level> levels = new ArrayList<Level>();
		levels.add(new ObtainableLevel());
		levels.add(new FlickerLevel());
		levels.add(new MixLevel());
		levels.add(new FogLevel());
		Game.setPlayer(null);
		Game.setLevels(levels);
		
		
		
		
		for(MenuSlot slot : slots){
			add(slot);
			add(Box.createVerticalGlue());
		}
		
		setVisible(true);
		setFocusable(true);
		requestFocus();
	}

	public void deleted(MenuSlot ms, File f) {
		try {
			PrintWriter pw = new PrintWriter(f);
			pw.write("");
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		remove(ms);
		NewSlot ns = new NewSlot(f);
		add(ns);
		add(Box.createVerticalGlue());
		ns.revalidate();
		repaint();
		setVisible(true);
	}
	
	
}
