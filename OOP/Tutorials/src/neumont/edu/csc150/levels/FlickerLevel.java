package neumont.edu.csc150.levels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.imageio.ImageIO;

import neumont.edu.csc150.enemies.FlickeringEnemy;
import neumont.edu.csc150.enemy.Enemy;
import neumont.edu.csc150.level.Level;
import neumont.edu.csc150.player.Player;
import neumont.edu.csc150.player.achievement.Achievement;

public class FlickerLevel extends Level{

	private static Image icon = null;
	private static int x = 500;
	private static int y = 500;
	private static int width = 1000;
	private static int height = 1000;
	public FlickerLevel() {
		super(x,y,width,height,icon,"Tutorial","Flickering",getEnemies());
		init();
	}
	
	private void init(){
		setIcon();
		setAchievements();
	}

	protected void paintBackground(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0,0, width, height);
	}

	protected void paintForeground(Graphics g) {
		if(!gameOver){
			g.setColor(Color.black);
			g.drawString("Collect all blinking dots...", 450, 25);
			g.drawString("Wait until they blink.", 450, 50);
		}else{
			g.setColor(Color.black);
			g.drawString("They blink red then green, wait until they are green to obtain them.",450,25);
		}
	}

	private void setIcon(){
		try {
			setIcon(ImageIO.read(getClass().getResourceAsStream("images/icons/Flicker.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Collection<Enemy> getEnemies(){
		Collection<Enemy> enemies = new ArrayList<Enemy>();
		for(int i=0;i<3;i++){
			enemies.add(new FlickeringEnemy((int)(Math.random()*1000),(int)(Math.random()*750+150), 25, 1));
		}
		return enemies;
	}
	
	private void setAchievements(){
		try {
			achievements.add(new Achievement("Check",ImageIO.read(new File("C:\\Users\\Joshua\\Desktop\\basicLevel.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void setUpPlayer(Player p){
		p.setLocation(new Point(0,0));
	}
	public void subReset(){
		enemies = getEnemies();
	}
	
	public boolean levelComplete(){
		return enemies.size()==0;
	}
	
	public void subCompletion(){
		this.completed(new Date());
		completed();
	}
	
	Thread waiter;
	public void gameOver(){
		waiter = new Thread(new Runnable(){
			public void run(){
				try {
					waiter.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				completed();
			}
		});
		waiter.start();
	}
}
