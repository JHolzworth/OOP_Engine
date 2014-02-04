package neumont.edu.csc150.volley.menu.factory.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import neumont.edu.csc150.player.Player;

public class TextFileWriter implements FileWriter{

	public void writePlayer(File f, Player p) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String x = "X: "+p.getLocation().x;
		out.write(x+"\n");
		String y = "Y: "+p.getLocation().y;
		out.write(y+"\n");
		String health = "Health: "+p.getMaxHealth();
		out.write(health+"\n");
		String size = "Size: "+p.getSize();
		out.write(size+"\n");
		String speed = "Speed: "+p.getSpeed();
		out.write(speed+"\n");
		String shieldSize = "ShieldSize: "+p.getShield().getShellSize();
		out.write(shieldSize+"\n");
		String shieldRelay = "ShieldRelay: "+p.getShield().getRelay();
		out.write(shieldRelay+"\n");
		String immune = "Immune: "+p.getImmuneThresh();
		out.write(immune+"\n");
		String pnts = "Points: "+p.getPoints();
		out.write(pnts+"\n");
		out.flush();
		out.close();
		
	}

}
