package neumont.edu.csc150.volley.splash;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;

import letters.LetterPoint;

public class SplashPane extends JPanel{

	
	private Collection<SplashOval> splashOvals;
	private Thread starter;
	
	private Collection<SplashOval> volleyOvals;
	
	private Collection<SplashOval> deadOvals;
	
	//TODO
	//Make cursor circle...
	//Also make a player that follows you with no shield and is rather fast...
	public SplashPane(){
		super();
		setLayout(null);
		
		volleyOvals = new ArrayList<SplashOval>();
		splashOvals = new ArrayList<SplashOval>();
		deadOvals = new ArrayList<SplashOval>();
		
		setBounds(0,0,1920,1080);
		ArrayList<SplashOval> ovals = new ArrayList<SplashOval>();
		for(int i=0;i<500;i+=25){
			for(int j=0;j<1000;j+=25){
				int x = (int)(Math.random()*1920);
				int y = (int)(Math.random()*1080);
				int chance = ((int)(Math.random()*1000))%4;
				if(chance == 1)
					x=0;
				else if(chance==2)
					x = 1920;
				else if(chance==3)
					y = 0;
				else
					y = 1080;
				ovals.add(new SplashOval(new Point(x,y),50,new Point(1920/2-500+j,1080/2-500+i)));
			}
		}
		

		Timer ovalPumper = new Timer();
		final Collection<SplashOval> waveOne = new ArrayList<SplashOval>();
		for(int i=0;i<ovals.size()/3;i++){
			waveOne.add(ovals.get(i));
		}
		splashOvals.addAll(waveOne);
		
		
		
		final Collection<SplashOval> waveTwo = new ArrayList<SplashOval>();
		for(int j=ovals.size()/3;j<ovals.size()/3*2;j++){
			waveTwo.add(ovals.get(j));
		}
		splashOvals.addAll(waveTwo);
		final Collection<SplashOval> waveThree = new ArrayList<SplashOval>();
		for(int i=ovals.size()/3*2;i<ovals.size();i++){
			waveThree.add(ovals.get(i));
		}
		splashOvals.addAll(waveThree);
		
		
		
		
		
		
		
		Point[] pnts = LetterPoint.getV();
		drawLetter(625,100,pnts);
		
		pnts = LetterPoint.getO();
		drawLetter(750,100,pnts);
		
		pnts = LetterPoint.getL();
		drawLetter(900,100,pnts);
		pnts = LetterPoint.getL();
		drawLetter(1000,100,pnts);
		
		pnts = LetterPoint.getECase();
		drawLetter(1100,100,pnts);
		pnts = LetterPoint.getEInner();
		drawLetter(1100,100,pnts);
		
		pnts = LetterPoint.getY();
		drawLetter(1200,100,pnts);

		
		ovalPumper.schedule(new TimerTask(){
			public void run(){
				synchronized (splashOvals) {
					
				splashOvals.addAll(volleyOvals);
				}
			}
		}, 1000);
		
		setVisible(true);
		
		starter = new Thread(new Runnable(){
			public void run(){
				while(deadOvals.size()!=splashOvals.size()){
					for(SplashOval so : splashOvals){
						if(!so.isAlive()&&!deadOvals.contains(so)){
							deadOvals.add(so);
							if(deadOvals.containsAll(volleyOvals)){
								enableStart();
							}
						}else
							so.move();
					}
					repaint();
					try {
						starter.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		setOpaque(false);
		//setBackground(new Color(0,0,0,0));
		starter.start();
	}
	
	private void enableStart(){
		JButton start = new JButton("Start");
		//Set font
		//set Text Color
		//set Background to a picutre of a circle...
		start.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2-100, Toolkit.getDefaultToolkit().getScreenSize().height/2-100, 100, 100);
		add(start);
		start.setVisible(true);
		
		
		start.addActionListener(new StartButtonListener());
		//Time to open a new VolleyFrame and load it with a menuPane....
	}
	
	
	
	
	private int LETTER_SIZE = 10;
	private void drawLetter(int x, int y, Point[] pnts){
		
		for(int i=0;i<pnts.length;i++){
			pnts[i].x*=LETTER_SIZE;
			pnts[i].y*=LETTER_SIZE;
		}
		for(int i=0;i<pnts.length-1;i++){
			Point location = pnts[i];
			while(location.distance(pnts[i+1])>10){
				double speed = 10;
				int deltaX = location.x-pnts[i+1].x;
				int deltaY = location.y-pnts[i+1].y;
				double theta =  Math.atan2(deltaY,deltaX)*180/Math.PI;
				Point newLocation;
				
				if(Math.abs(theta)<90){
				double newX = (deltaX<0?1:-1)*speed*Math.cos(theta*Math.PI/180);
					double newY = -speed*Math.sin(theta*Math.PI/180);
					newLocation = location;
					newLocation.x+=newX;
					newLocation.y+=newY;
				}else{
					double thetaPrime = 180-theta;
					double newX = (deltaX<0?1:-1)*speed*Math.cos(thetaPrime*Math.PI/180);
					double newY = -speed*Math.sin(thetaPrime*Math.PI/180);
					newLocation = location;
					newLocation.x+=newX;
					newLocation.y+=newY;
				}
				location = newLocation;
				int xp = (int)(Math.random()*1920);
				int yp = (int)(Math.random()*1080);
				int chance = ((int)(Math.random()*1000))%4;
				if(chance == 1){
					xp=0;
					yp=0;
				}
				else if(chance==2){
					xp = 1920;
					yp=0;
				}
				else if(chance==3){
					yp = 1080;
					xp = 0;
				}
				else{
					yp = 1080;
					xp = 1920;
				}
				SplashOval letter = new SplashOval(new Point(xp,yp),30,new Point(location.x+x,location.y+y));
				SplashOval letter2 = new SplashOval(new Point(xp,yp),30,new Point(location.x+x,location.y+y));
				letter.setColor(Color.green);
				letter2.setColor(Color.green);
				volleyOvals.add(letter);
				volleyOvals.add(letter2);
				
			}
			
			
		}
	}
	
	public void paintComponent(Graphics g){
		synchronized (splashOvals) {
			for(SplashOval so : splashOvals){
				so.paint(g);
			}
		}
	}
}
