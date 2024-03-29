package neumont.edu.csc150.volley.game.frame.achievement;

import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import neumont.edu.csc150.player.achievement.GainedAchievement;

public class AchievementPane extends JPanel{

	public AchievementPane(Collection<GainedAchievement> achieves, JPanel toCompare){
		super();
		//setPreferredSize(toCompare.getPreferredSize());
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		for(GainedAchievement ga : achieves){
			add(new AchievementSlot(ga));
			add(Box.createVerticalGlue());
		}
		setVisible(true);
	}
}
