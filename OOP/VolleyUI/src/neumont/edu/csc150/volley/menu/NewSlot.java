package neumont.edu.csc150.volley.menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import neumont.edu.csc150.Game;
import neumont.edu.csc150.volley.VolleyFrame;
import neumont.edu.csc150.volley.game.frame.GamePane;

public class NewSlot extends MenuSlot{
	public NewSlot(final File save){
		super();
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		JButton newButton = new JButton("New Game");
		newButton.setVisible(true);
		
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Game.setPlayer(Game.getNewPlayer());
				MenuPane.SAVE_FILE = save;
				VolleyFrame.getInstance().loadPane(new GamePane());
				
			}
		});
		
		add(Box.createHorizontalGlue());
		add(newButton,Box.CENTER_ALIGNMENT);
		add(Box.createHorizontalGlue());
		setBorder(BorderFactory.createLineBorder(Color.green));
		setVisible(true);
	}
}
