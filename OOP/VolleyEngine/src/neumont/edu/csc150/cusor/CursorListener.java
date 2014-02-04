package neumont.edu.csc150.cusor;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CursorListener implements MouseListener, MouseMotionListener{

	private Point mouseLoc = new Point(-25,-25);
	
	public Point getMouseLoc(){
		return mouseLoc;
	}
	
	public void mouseClicked(MouseEvent me) {
		mouseLoc = me.getPoint();
	}

	public void mouseEntered(MouseEvent me) {
		mouseLoc = me.getPoint();
	}

	public void mouseExited(MouseEvent me) {
		mouseLoc = me.getPoint();
	}

	public void mousePressed(MouseEvent me) {
		mouseLoc = me.getPoint();
	}

	public void mouseReleased(MouseEvent me) {
		mouseLoc = me.getPoint();
	}

	public void mouseDragged(MouseEvent me) {
		mouseLoc = me.getPoint();
	}

	public void mouseMoved(MouseEvent me) {
		mouseLoc = me.getPoint();
	}
}