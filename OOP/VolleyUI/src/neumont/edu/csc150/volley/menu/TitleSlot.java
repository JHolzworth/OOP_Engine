package neumont.edu.csc150.volley.menu;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class TitleSlot extends MenuSlot{
	private Font TITLE_FONT = new Font(null,1,50);
	private String GAME_NAME = "Volley";
	JLabel title;
	public TitleSlot(){
		super();
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		title = new JLabel(GAME_NAME);
		title.setFont(TITLE_FONT);
		title.setVisible(true);
		add(Box.createHorizontalGlue());
		add(title);
		add(Box.createHorizontalGlue());
		//setBorder(BorderFactory.createLineBorder(Color.Red));
		setVisible(true);
	}
	
}
