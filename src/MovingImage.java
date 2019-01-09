
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/*
 * Represents a moving, appearing/disappearing image.
 *
 * by: Amanda
 * on: 5/20/17
 */
 
public class MovingImage extends Rectangle2D.Double

{
	
	private boolean isVisible;
	// 5/18/17 ADD INT "KIND" FOR PLAT, DECORATION, HEALTH, PORTAL
	// platform = 0, health =1, devil= -1, portal = 2, decoration = 3 , player=4
	private BufferedImage img;
	public Rectangle area;
	private boolean textured;
	
	// CONSTRUCTOR

	public MovingImage(String filename, int x, int y, int w, int h, boolean textured, int type) {
		super(x,y,w,h);
		try {
			img = ImageIO.read(new File(filename));
		} 
		catch(IOException ex) {
			System.out.println("Hello!\n");
		}
		area = new Rectangle(x, y, w, h);
		isVisible = true;
		this.textured = textured;
	}
	
	public MovingImage(Image img, double x, double y, double w, double h) {	
		super(x,y,w,h);
		isVisible = true;
		this.textured = textured;
	}
	
	public void moveInLimits(Rectangle2D.Double limits, double x, double y) {
		double newX = this.x + x;
		double newY = this.y + y;
		if (limits.contains(new Rectangle2D.Double(newX,newY,width,height))) {
			this.x = newX;
			this.y = newY;
		}
	}
	
	public Point2D.Double getCenter() {
		return new Point2D.Double(getX()+getWidth()/2,getY()+getHeight()/2);
	}

	
	// METHODS
	
	public void toggleVisibility() {
		isVisible = !isVisible;
	}
	
	public void moveToLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveByAmount(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-this.width);
		y = Math.min(y,windowHeight-this.height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	public boolean isPointInImage(double mouseX, double mouseY) {
		if (mouseX >= x && mouseY >= y && mouseX <= x + width && mouseY <= y + height)
			return true;
		return false;
	}
	
	public void resize(double w, double h) {
		width = w;
		height = h;
	}
	
	public void draw(Graphics g, ImageObserver io) {
		if (isVisible)
			g.drawImage(img,(int)x,(int)y,(int)width,(int)height,io);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public boolean isVisible() {
		return isVisible;
	}

	

	
	
}










