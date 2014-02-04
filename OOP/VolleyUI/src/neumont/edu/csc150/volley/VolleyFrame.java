package neumont.edu.csc150.volley;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import neumont.edu.csc150.Game;
import neumont.edu.csc150.cusor.CursorListener;
import neumont.edu.csc150.level.Level;
import neumont.edu.csc150.volley.game.frame.GamePane;
import neumont.edu.csc150.volley.level.pane.LevelPane;
import neumont.edu.csc150.volley.menu.MenuPane;
import neumont.edu.csc150.volley.menu.factory.ProfileFactory;
import neumont.edu.csc150.volley.splash.SplashPane;

public class VolleyFrame extends JFrame{

	private static VolleyFrame instance;
	private static int DEFAULT_X = Toolkit.getDefaultToolkit().getScreenSize().width/2-500;
	private static int DEFAULT_Y = Toolkit.getDefaultToolkit().getScreenSize().height/2-500;
	private static int DEFAULT_WIDTH = 1000;
	private static int DEFAULT_HEIGHT = 1000;
	
	
	
	
	//TODO
	//Change this so it reads from a properties file...
	private static String ID = "Volley";
	
	private VolleyFrame(int _x, int _y, int _width, int _height){
		super();
		setBounds(_x, _y, _width, _height);
		init();
	}
	
	private VolleyFrame(){
		this(DEFAULT_X,DEFAULT_Y,DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
	
	
	
	public static VolleyFrame getInstance(){
		if(instance==null){
			instance = new VolleyFrame();
		}
		
		return instance;
	}
	
	public static void resetFrame(){
		instance.dispose();
		instance=null;
		getInstance();
	}
	
	
	
	
	public void paint(Graphics g){
		super.paint(g);
	}
	
	private CursorListener cursorListener;
	private void setUpCursor(){
		Image cursorImage;
		/*try {
			cursorImage = ImageIO.read(getClass().getResourceAsStream("images/Cursor.png"));
			Cursor myCursor=Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,new Point(0,0),"cursor");
			setCursor(myCursor);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	private void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent winEvt){
				if(Game.getCurrentPlayer()!=null){
					ProfileFactory.saveProfile();
				}
			}
		});
		
		//TODO
		//Note to change to a layout
		
		setUpCursor();
		cursorListener = new CursorListener();
		addMouseListener(cursorListener);
		addMouseMotionListener(cursorListener);
		/*
		//TODO
		//Get rid of this level etc...
		final LevelPane lp = new LevelPane(0,0,getWidth(),getHeight(),cursorListener);
		ArrayList<Enemy> en = new ArrayList<Enemy>();
		en.add(new FlickeringEnemy(500,500,30,30));
		Level l = new Level(en){

			@Override
			protected void paintBackground(Graphics g) {
				g.setColor(Color.cyan);
				g.fillRect(lp.getX(), lp.getY(), lp.getWidth(), lp.getHeight());
			}

			@Override
			protected void paintForeground(Graphics g) {
				g.setColor(new Color(.3f,.3f,.5f,.3f));
				g.fillOval(0, 0, 500, 500);
			}
			
		};
		lp.loadLevel(l);
		add(lp);
	*/
		//MenuPane mp = new MenuPane();
		//add(mp);
		
		animator = new Thread(new Runnable(){
			public void run(){
				while(true){
					repaint();
					try {
						animator.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		animator.start();
		//l.start();
	}
	private Thread animator;
	public void loadPane(JPanel paneToSet){
		setCursor(null);
		if(getContentPane()!=null){
			remove(getContentPane());
		}
		if(paneToSet instanceof SplashPane){
			setBounds(0,0,1920,1080);
			setLayout(null);
			
			setResizable(false);
			setUndecorated(true);
			setBackground(new Color(0,0,0,0));
			setContentPane(paneToSet);
			
		}
		if(paneToSet instanceof MenuPane){
			setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2-500,Toolkit.getDefaultToolkit().getScreenSize().height/2-500,500,500);
			instance.setLayout(new FlowLayout());
			setContentPane(paneToSet);
			pack();
		}else if(paneToSet instanceof GamePane){
			Game.getCurrentPlayer().reset();
			instance.setLayout(new FlowLayout());
			setContentPane(paneToSet);
			pack();
		}else if(paneToSet instanceof LevelPane){
			instance.setLayout(null);
			LevelPane lp = (LevelPane)paneToSet;
			Level l = lp.getLevel();
			setBounds(0,0,l.getBounds().width,l.getBounds().height);
			setContentPane(paneToSet);
			l.start(Game.getCurrentPlayer(),lp);
			
			Image cursorImage;
			try {
				cursorImage = ImageIO.read(getClass().getResourceAsStream("images/Cursor.png"));
				Cursor myCursor=Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,new Point(16,16),"cursor");
				setCursor(myCursor);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		setVisible(true);
	}
	
}
