package neumont.edu.csc150.volley.menu.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;

import neumont.edu.csc150.Game;
import neumont.edu.csc150.level.Level;
import neumont.edu.csc150.player.Player;
import neumont.edu.csc150.player.volley.VolleyPlayer;

public class SerialReader implements FileReader{

	@Override
	public Player readPlayer(File file) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			Player p = (VolleyPlayer) ois.readObject();
			Game.setPlayer(p);
			Collection<Level> levs = (Collection<Level>) ois.readObject();
			Game.setLevels(levs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Game.getCurrentPlayer();
	}

}
