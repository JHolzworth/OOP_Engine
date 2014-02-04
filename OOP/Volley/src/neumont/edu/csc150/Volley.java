package neumont.edu.csc150;

import java.awt.Toolkit;

import neumont.edu.csc150.volley.VolleyFrame;
import neumont.edu.csc150.volley.splash.SplashPane;

public class Volley {
	public Volley(){
		int width = 1000;
		int height = 1000;
		int startX = (Toolkit.getDefaultToolkit().getScreenSize().width-width)/2;
		int startY = (Toolkit.getDefaultToolkit().getScreenSize().height-height)/2;
		//VolleyFrame vf = new VolleyFrame(startX, startY, width,height);
		VolleyFrame vf = VolleyFrame.getInstance();
		vf.loadPane(new SplashPane());
		//vf.loadPane(new MenuPane());
		//vf.loadPane(new MenuPane());
		//vf.loadPane(new GamePane());
		
		//vf.loadPane(new SplashPane());
		//SplashFrame sf = new SplashFrame();
	}
}
