package neumont.edu.csc150.volley.menu.factory.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import neumont.edu.csc150.Game;
import neumont.edu.csc150.player.Player;

public class SerialWriter implements FileWriter{

	@Override
	public void writePlayer(File f, Player p) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(Game.getCurrentPlayer());
			//oos.writeObject(Game.getLevels());
			oos.flush();
			oos.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
