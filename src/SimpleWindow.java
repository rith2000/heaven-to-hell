import java.awt.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
//import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Amanda and Rithika
   @version TODO Date

   Period - TODO Your Period
   Assignment - TODO Name of Assignment

   Sources - TODO list collaborators
 */
public class SimpleWindow extends JPanel implements KeyListener, Runnable
{
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	private static final int FULL_HEALTH = 5;

	private Player player;
	private MovingImage platform;
	private boolean hasCollided, isGameOver;

	private int vulnerableCounter;
	private int healths;



	//private boolean isLeftKeyDown, isRightKeyDown, isUpKeyDown;
	// public boolean isHit;

	// public static final int ASSUMED_DRAWING_WIDTH = 400; // These numbers are way too small
	// public static final int ASSUMED_DRAWING_HEIGHT = 300; // We are only using them to zoom in on the scene

	private double ratioX, ratioY;

	//private MovingImage mario;

	private boolean rightKey, leftKey, upKey, downKey;
	private MovingImage health1,health2,health3,health4,health5;
	private int spacing;

	private Rectangle2D.Double visibleSpace;
	private Rectangle2D.Double characterSpace;
	private Rectangle2D.Double worldSpace;

	private boolean isLeftKeyDown;
	private boolean isRightKeyDown;
	private boolean isUpKeyDown;
	private ArrayList<Level> levels;
	private Level level;
	private int levelNum;

	//private Level platform;



	public SimpleWindow (ArrayList<Level> lvls) {
		super();
		player = new Player(0,0);
		hasCollided = false;
		//enemy = new Enemy(925,1000 ,1000,1000);
		spacing = 10;
		health1 = new MovingImage("Kirby.png",1945,30,30,30, true, 0);
		health2 = new MovingImage("Kirby.png",1945,30+spacing+20,30,30, false, 0);
		health3 = new MovingImage("Kirby.png",1945,30+2*20+2*spacing,30,30, false, 0);
		health4 = new MovingImage("Kirby.png",1945,30+3*20+3*spacing,30,30, false, 0);
		health5 = new MovingImage("Kirby.png",1945,30+4*20+4*spacing,30,30, false, 0);// textured = like infinity brik, false textured = mario (nonrepeated image) 
		healths = 5;
		vulnerableCounter = 1000;
		//Timer clock = new Timer(30, this); 
		//clock.start();
		//isHit = false;

		setBackground(Color.CYAN);
		//thisLevel = new Level();
		levels = lvls;
		levelNum=0;
		level=levels.get(levelNum);
		
		worldSpace = new Rectangle2D.Double(0,0,level.getWidth(),level.getHeight());
		visibleSpace = new Rectangle2D.Double(0,0,level.getWidth(),level.getHeight());
		characterSpace = new Rectangle2D.Double(0,0,level.getWidth(),level.getHeight());
		//characterSpace = new Rectangle2D.Double(visibleSpace.getX()+visibleSpace.getWidth()/5,visibleSpace.getY()+visibleSpace.getHeight()/5,visibleSpace.getWidth()*3/5,visibleSpace.getHeight()*3/5);

		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				ratioX = (double)e.getComponent().getWidth()/DRAWING_WIDTH;
				ratioY = (double)e.getComponent().getHeight()/DRAWING_HEIGHT;
			}	  	
		});



		new Thread(this).start();
	}




	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		int healthBarWidth = 14;
		int x0 = width - healthBarWidth - 5;
		int y0 = 5;

		double ratioX = width/level.getWidth();
		double ratioY = height/level.getHeight();

		final int yStep = 7;
		

		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.black);

		AffineTransform at = g2.getTransform();

		g2.translate(visibleSpace.getX(),visibleSpace.getY());
		g2.scale(ratioX,ratioY);

		level.draw(g2, this);
		player.draw(g2,this);
		
		if(healths==1){
			health1.draw(g2, this);
		}
		else if(healths==2){
			health1.draw(g2, this);
			health2.draw(g2, this);
		}
		else if (healths==3){
			health1.draw(g2, this);
			health2.draw(g2, this);
			health3.draw(g2, this);
		}
		else if(healths==4){
			health1.draw(g2, this);
			health2.draw(g2, this);
			health3.draw(g2, this);
			health4.draw(g2, this);
		}
		else if(healths>=5){
			health1.draw(g2, this);
			health2.draw(g2, this);
			health3.draw(g2, this);
			health4.draw(g2, this);
			health5.draw(g2, this);
		}
		else if(healths<1){
			isGameOver = true; //RS
			 //RS
		}
		g2.setTransform(at);
		






	}


	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// WALK LEFT
			isLeftKeyDown = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// WALK RIGHT
			isRightKeyDown = true;

		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			// JUMP
			isUpKeyDown = true;
			//if up and playerIsAtPortal==true, then go to next level
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			isLeftKeyDown = false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			isRightKeyDown = false;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {

			isUpKeyDown = false;
		}

	}

	public void keyTyped(KeyEvent e) {

	}


	public void run() {
		while(true) {
			// MAKE A CHANGE
			long startTime = System.currentTimeMillis();
			
			
			platform = player.fall(level.getPlatforms());
			checkplayer();

			if(isLeftKeyDown){
				player.walk(-1);
			}
			if(isRightKeyDown){
				player.walk(1);
			}
			if(isUpKeyDown){
				player.jump(level.getPlatforms());
			}
			
			for(Enemy enemy : level.getEnemies()){
				enemy.move();
			}

			//HIT ENEMY
			
			
			vulnerableCounter ++;
			if(player.isHit(level.getEnemies())){
				if(vulnerableCounter > 15){
					healths--;
					vulnerableCounter = 0;
					System.out.println("HIT");
				}
			}
			for(Powerup power : level.getPowerups()){
				if(player.hitsPowerup(level.getPowerups())){
					power.claimed();
					if(healths<5){
						healths++;
					}
				}
			}
			if(player.hitsPortal(level.getPortals())){
				//exit out of simple window
				player = new Player(380,0);//give different val for where kirby should start
				levelNum ++;
				level=levels.get(levelNum);
				worldSpace = new Rectangle2D.Double(0,0,level.getWidth(),level.getHeight());
				
			}
			if(player.hitsFriend(level.getFriends())){
				//exit out of simple window
				player = new Player(975-70,1100 -100);
				//give different val for where kirby should start
				levelNum ++;
				level=levels.get(levelNum);
				worldSpace = new Rectangle2D.Double(0,0,level.getWidth(),level.getHeight());
				
				System.out.println("You win!");
				
			}if(isGameOver){
				JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
				System.exit(ABORT);
				isGameOver = false;
				return;
			}
			
			// constantly check if player is at portal;
			// SHOW THE CHANGE
			repaint();
			
			long waitTime = 20 - (System.currentTimeMillis() - startTime);
			//System.out.println(waitTime);
			
			if (waitTime > 0) {
				try {
					Thread.sleep(waitTime);
				} catch (InterruptedException e) {}
			}
		}
	}

	public boolean playerIsAtPortal(){
		//if they player intersects with portal
		return true;
		//else return false;
	}
	public void checkplayer() {
		double x = player.getX() + player.getWidth()/2;
		double y = player.getY() + player.getHeight()/2;
		if (x < 0 || x > level.getWidth() || y > level.getHeight()){
			player = new Player(380,0);
			healths --;
			System.out.println("you fell to death "); // 5/18/17 SHOULD PRINT OUT GAME OVER OR HEALTH --
		}
	}



	
}


