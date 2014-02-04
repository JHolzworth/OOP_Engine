package neumont.edu.csc150.volley.level.pane;

import java.awt.Graphics;

import javax.swing.JPanel;

import neumont.edu.csc150.Game;
import neumont.edu.csc150.level.Level;
import neumont.edu.csc150.level.LevelListener;
import neumont.edu.csc150.move.PlayerController;
import neumont.edu.csc150.move.mouseMover.MouseMover;
import neumont.edu.csc150.player.Player;
import neumont.edu.csc150.volley.VolleyFrame;
import neumont.edu.csc150.volley.game.frame.GamePane;

public class LevelPane extends JPanel implements LevelListener{
	
	private Player player;
	private Level currentLevel;
	private PlayerController controller;
	
	
	public LevelPane(Level _currentLevel){
		super();
		currentLevel = _currentLevel;
		setBounds(0,0,currentLevel.getBounds().width,currentLevel.getBounds().height);
		init();
	}
	
	public Level getLevel(){
		return currentLevel;
	}
	
	private void init(){
		setLayout(null);
		setVisible(true);
		setFocusable(true);
		requestFocus();
		
		player = Game.getCurrentPlayer();
		controller = new PlayerController(player);
		currentLevel.addListener(this);
		
		mm = new MouseMover();
		mm.addMoveListener(controller);
		
		
		addMouseListener(currentLevel.getCursorListener());
		addMouseMotionListener(currentLevel.getCursorListener());
		
		
		addMouseMotionListener(mm);
		addMouseListener(mm);
	}
	
	MouseMover mm;
	
	//TODO
	//Must start level and start animations etc...
	public void startLevel(){
		removeAll();
		currentLevel.reset();
		currentLevel.start(Game.getCurrentPlayer(), this);
		controller.start();
		
	}
	
	public void paint(Graphics g){
		currentLevel.paint(player, g);
	}

	public void levelComplete() {
		controller.end();
		VolleyFrame.getInstance().loadPane(new GamePane());
		removeMouseListener(currentLevel.getCursorListener());
		removeMouseMotionListener(currentLevel.getCursorListener());
	}
}
