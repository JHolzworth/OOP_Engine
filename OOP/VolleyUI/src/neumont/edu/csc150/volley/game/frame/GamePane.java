package neumont.edu.csc150.volley.game.frame;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import neumont.edu.csc150.Game;
import neumont.edu.csc150.volley.game.frame.achievement.AchievementPane;
import neumont.edu.csc150.volley.game.frame.level.LevelsPane;

public class GamePane extends JPanel{

	
	public GamePane(){
		super();
		//TODO
		//Take out should be loaded by now...
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JPanel topPane = new JPanel();
		topPane.setLayout(new BoxLayout(topPane,BoxLayout.X_AXIS));
		PlayerStatPane psPane = new PlayerStatPane();
		topPane.add(psPane);
		topPane.add(Box.createHorizontalGlue());
		topPane.add(Box.createRigidArea(new Dimension(50,0)));
		JScrollPane achiPane = new JScrollPane(){
			public void paint(Graphics g){
				super.paint(g);
			}
		};
		
		
		JViewport vp = new JViewport();
		vp.setView(new AchievementPane(Game.getCurrentPlayer().getAchievements(),psPane));
		achiPane.setViewport(vp);
		achiPane.setPreferredSize(new Dimension(400,250));
		
		topPane.add(achiPane);
		topPane.add(Box.createHorizontalGlue());
		
		topPane.setVisible(true);
		
		add(topPane);
		add(Box.createHorizontalGlue());
		
		add(new LevelsPane(Game.getLevels()));
		
		setVisible(true);
	}
}
