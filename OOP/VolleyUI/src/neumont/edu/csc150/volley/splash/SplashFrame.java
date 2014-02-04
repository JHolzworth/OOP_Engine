package neumont.edu.csc150.volley.splash;

import java.awt.Color;

import javax.swing.JFrame;

public class SplashFrame extends JFrame{

	public SplashFrame(){
		super();
		setBounds(0,0,1920,1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		setResizable(false);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		
		add(new SplashPane());
		
		setVisible(true);
	}
}
