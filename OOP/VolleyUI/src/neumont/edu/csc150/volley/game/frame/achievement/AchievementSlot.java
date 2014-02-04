package neumont.edu.csc150.volley.game.frame.achievement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import neumont.edu.csc150.player.achievement.GainedAchievement;

public class AchievementSlot extends JPanel{

	public AchievementSlot(GainedAchievement achiev){
		super();
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
		JLabel icon = new JLabel();
		icon.setIcon(new ImageIcon(achiev.getIcon()));
		icon.setVisible(true);
		add(icon);
		add(Box.createHorizontalGlue());
		
		JLabel name = new JLabel(achiev.getName());
		name.setVisible(true);
		add(name);
		add(Box.createHorizontalGlue());
		
		JLabel date = new JLabel(achiev.getDate().toString());
		date.setVisible(true);
		add(date);
		
		
		setVisible(true);
	}
}
