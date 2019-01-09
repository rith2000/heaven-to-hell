import java.util.ArrayList;
import java.awt.Rectangle;//Amanda: for collision detection, need to set bounds of player and enemy

public class Player extends MovingImage  {
	// FIELDS
	private double vx, vy;
	private boolean isOnSurface = true;
	private boolean isHit;
	private int health, x, y, width, height;
	//private SimpleWindow simplewindow;

	
	// CONSTRUCTOR
	public Player(int x, int y) {
		super("Kirby.png",x,y,60,70, false, 4); // kirby is an independent character not a space to be filled w a texture
		//^used to be width = 40, height = 50
		vx = 0;
		vy = 0;
		this.x=x;//RS
		this.y=y;//RS
		width=40;
		height=50;
	}

	// METHODS
	public void walk(int dir) {
		// WALK! neg = left and pos = right to go faster, edit this method not the simple windows parameter
		
		super.moveByAmount(4*dir, 0); //use vx instead to accelerate!
	}

	public MovingImage jump(ArrayList<MovingImage> scene) {
		// JUMP!
		
		
		if(isOnSurface){
			System.out.println("1. " + vy +"");
			System.out.println("1. " +isOnSurface + "");
			vy = -15;
			//isOnSurface = false;
		}
		for(MovingImage img : scene){
			
			
			if(img.isPointInImage(x, y)){
				System.out.println("2. " +img +"");
				System.out.println("2. " +vy +"");
				System.out.println("2. " +isOnSurface + "");
				super.moveByAmount(0, -(y-img.getY()));
				vy = 0.8;
				isOnSurface = false;
				return img;
			}
			else{
				System.out.println("3. " +img +"");
				System.out.println("3. " +vy +"");
				System.out.println("3. " +isOnSurface + "");
				isOnSurface = false;

			}
			
			

		}
		// how hard does he push off the ground
		return null;
	}

	public MovingImage fall(ArrayList<MovingImage> scene){ //return type is to keep things simple and tell 
		//simplewindow what platform player is currently on (like assigning variable) assigning simple window
		//plat field w/right value
		// FALL!

		vy += .8;

		double x = getX();
		double y = getY();

		x += getWidth()/2;
		y += getHeight();

		super.moveByAmount(0, vy);
		for(MovingImage img : scene){
 			if(img.isPointInImage(x, y)){
				super.moveByAmount(0, -(y-img.getY()));
				vy = 0;
				isOnSurface = true;
				return img;
			}
			else{
				isOnSurface = false;

			}

		}
		return null;

	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	public boolean isHit(ArrayList<Enemy> enemies){
		double x = getX();
		double y = getY();

		x += getWidth()/2;
		y += getHeight()/2;

		
		for(Enemy img : enemies){
			if(img.isPointInImage(x, y)){
				return true;
			}

		}
		return false;
	}
	
	public boolean hitsPowerup(ArrayList<Powerup> powerups){
		double x = getX();
		double y = getY();

		x += getWidth()/2;
		y += getHeight()/2;

		
		for(Powerup power : powerups){
			if(power.isPointInImage(x, y) && power.getVisibility()==true){
				return true;
				
			}

		}
		return false;
	}
	public boolean hitsPortal(ArrayList<Portal> portals){
		double x = getX();
		double y = getY();

		x += getWidth()/2;
		y += getHeight()/2;

		
		for(Portal port : portals){
			if(port.isPointInImage(x, y)){
				return true;
			}

		}
		return false;
	}
	
	public boolean hitsFriend(ArrayList<Friend> friends){
		double x = getX();
		double y = getY();

		x += getWidth()/2;
		y += getHeight()/2;

		
		for(Friend frie : friends){
			if(frie.isPointInImage(x, y)){
				return true;
			}

		}
		return false;
		
	}
	
	
	
	
	



}