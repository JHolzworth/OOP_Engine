package neumont.edu.csc150.volley.game.frame.level;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import neumont.edu.csc150.Game;
import neumont.edu.csc150.level.Level;
import neumont.edu.csc150.player.Player;
import neumont.edu.csc150.player.achievement.Achievable;
import neumont.edu.csc150.volley.VolleyFrame;
import neumont.edu.csc150.volley.level.pane.LevelPane;

public class LevelSlot extends JPanel{

	public LevelSlot(final Level lev){
		super();
		setLayout(new GridBagLayout());
		GridBagConstraints bgCon = new GridBagConstraints();
		
		JButton button = new JButton(new ImageIcon(lev.getIcon()));
		button.setToolTipText("Play "+lev.getName());
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				LevelPane lp = new LevelPane(lev);
				lev.reset();
				lp.startLevel();
				VolleyFrame.getInstance().loadPane(lp);
			}
		});
		
		bgCon.gridheight = 3;
		bgCon.gridx = 0;
		bgCon.gridy = 1;
		add(button,bgCon);
		
		JLabel name = new JLabel(lev.getName());
		name.setFont(new Font(null,1,15));
		bgCon.gridheight = 1;
		bgCon.gridx = 0;
		bgCon.gridy = 0;
		bgCon.ipady =10;
		add(name,bgCon);
		
		JLabel date = new JLabel(lev.getDate());
		bgCon.gridx = 1;
		bgCon.gridy = 2;
		add(date,bgCon);
		
		
		Player play = Game.getCurrentPlayer();
		Collection<Achievable> achievs = lev.getAchievements();
		achievs.removeAll(play.getAchievements());
		
		JLabel achRatio = new JLabel(lev.getAchievements().size()-achievs.size()+" / "+lev.getAchievements().size()+" achievements");
		bgCon.gridx = 1;
		bgCon.gridy = 3;
		add(achRatio,bgCon);
		
		
		
		setVisible(true);
	}
}
