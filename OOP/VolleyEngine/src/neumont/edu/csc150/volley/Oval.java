package neumont.edu.csc150.volley;

import java.awt.Graphics;
import java.awt.Point;

import neumont.edu.csc150.volley.paintable.Paintable;

public class Oval implements Paintable{

	protected Point location;
	protected int size;
	
	public Oval(int _x, int _y, int _size){
		location = new Point(_x,_y);
		size = _size;
	}
	
	public Oval(Point _location, int _size){
		location = _location;
		size = _size;
	}
	
	public void setBounds(int _x, int _y, int _size){
		location = new Point(_x,_y);
		size = _size;
	}
	
	public void setLocation(Point _location){
		location = _location;
	}
	
	public void setLocation(int _x, int _y){
		location = new Point(_x,_y);
	}
	
	public Point getLocation(){
		return location;
	}
	
	public int getSize(){
		return size;
	}
	
	public int getX(){
		return location.x;
	}
	
	public int getY(){
		return location.y;
	}

	public void paint(Graphics g) {
		g.fillOval(location.x-size/2, location.y-size/2,size,size);
	}
	
	public boolean contains(Point _location){
		boolean contains = false;
		double distance = location.distanceSq(_location);
		contains = distance<(size/2);
		return contains;
	}
	
	public boolean isColliding(Oval oval){
		boolean colliding = false;
		double distance = location.distance(oval.getLocation());
		colliding = distance<(size)/2+oval.getSize()/2;
		return colliding;
	}
}
