
import java.awt.Rectangle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.Timer;

	
	
	
	//Amanda coded this class
	
	
public class Enemy extends MovingImage{ 
	// FIELDS
	private int pointX1, pointY1, pointX2, pointY2, width, height; //enemy will move from p1 to p2
	private double vx, vy;
	private double delta, increment, time;
	private boolean isIncreasing;
	
	//private ImageObserver io;
	//private Image enemy;
	
	
	// CONSTRUCTOR
	public Enemy(int x1, int y1, int x2, int y2, double increment) {
		super("Devil.png",x1,y1,50,50, false, -1); // platform = 0, health =1, devil= -1, portal = 2, decoration = 3 , player=4
		pointX1=x1;
		pointY1=y1;
		pointX2=x2;
		pointY2=y2;
		vx = 0;
		vy = 0;
		time = 0;
		this.increment = increment;
		delta = this.increment;
		isIncreasing = true;
	
	}
	
	// METHODS
	public void die(int dir) {
		
	}
	
	public void move(){
		
		if(time>1){
			isIncreasing =false;
		}
		if(time<0){
			isIncreasing = true;
		}
		
		if(isIncreasing){
			delta = increment;
		}
		else{
			delta = -increment;
		}
		
		time += delta;
		
		//super.moveByAmount(4*time, 0);\
		x = (double)pointX1 + time*(pointX2-pointX1);
		y = (double)pointY1 + time*(pointY2-pointY1);
		super.moveToLocation(x, y);
	}
	
	
}