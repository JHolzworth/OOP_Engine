package neumont.edu.csc150.volley.menu.factory;

import java.io.File;

import neumont.edu.csc150.Game;
import neumont.edu.csc150.player.Player;
import neumont.edu.csc150.volley.menu.MenuPane;
import neumont.edu.csc150.volley.menu.factory.writer.FileWriter;
import neumont.edu.csc150.volley.menu.factory.writer.TextFileWriter;

public class ProfileFactory {

	public static Player readProfile(File f){
		FileReader fr =  new TextFileReader();
		//FileReader fr = new SerialReader();
		return fr.readPlayer(f);
	}
	
	public static void saveProfile(){
		FileWriter fw = new TextFileWriter();
		//FileWriter fw = new SerialWriter();
		fw.writePlayer(MenuPane.SAVE_FILE, Game.getCurrentPlayer());
	}
}
