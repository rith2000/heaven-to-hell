import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Level extends Rectangle2D.Double{

	private ArrayList<MovingImage> platforms;
	private ArrayList<Enemy> enemies;
	private ArrayList<MovingImage> decorations;
	private ArrayList<Portal> portals;
	private ArrayList<Powerup> powerups;
	private ArrayList <Friend> friends;
	
	//private MovingImage friend;



	/*public Level() {
		scene = new ArrayList<MovingImage>();
		scene.add(new MovingImage("tree.gif",150,150,175,300,false));
		scene.add(new MovingImage("house.jpg",525,250,200,200,false));
		scene.add(new MovingImage("sun.jpg",575,50,150,150,false));
		this.width = 800;
		this.height = 600;
	}
	 */
	public Level(int width, int height){
		platforms = new ArrayList<MovingImage>();
		enemies = new ArrayList<Enemy>();
		decorations = new ArrayList<MovingImage>();
		portals = new ArrayList<Portal>();
		powerups = new ArrayList<Powerup>();
		friends = new ArrayList <Friend>();
		//scene.add(new MovingImage("bricks.png", 0,0, width, height, false)); // d/n make sense bc each level has different arrangements
		this.width = width;
		this.height = height;
	}

	public void addPlatform(MovingImage img){
		platforms.add(img);
	}
	public void addEnemy(Enemy img){
		enemies.add(img);
	}
	public void addDecoration(MovingImage img){
		decorations.add(img);
	}

	public void addPortal(Portal img){
		portals.add(img);
	}
	public void addPowerup(Powerup img){
		powerups.add(img);
	}

	public void addFriend(Friend img){
		friends.add(img);
	}//RS
	
	
	
	public ArrayList<Enemy> getEnemies(){
		return enemies;
	}
	
	public ArrayList<MovingImage> getPlatforms(){
		return platforms;
	}
	public ArrayList<MovingImage> getDecorations(){
		return decorations;
	}
	public ArrayList<Portal> getPortals(){
		return portals;
	}
	public ArrayList<Powerup> getPowerups(){
		return powerups;
	}
	
	
	public ArrayList<Friend> getFriends(){
		return friends;
	}//RS
	
	
	public void draw(Graphics2D g2, ImageObserver io) {
		for (MovingImage mi : decorations)
			mi.draw(g2, io);
		for (MovingImage mi : platforms)
			mi.draw(g2, io);
		for (Enemy mi : enemies)
			mi.draw(g2, io);
		for (Portal mi : portals)
			mi.draw(g2, io);
		for (Friend mi : friends)
			mi.draw(g2, io);
		for (Powerup mi : powerups)
			if(mi.getVisibility()){
				mi.draw(g2, io);
			}
	}


		
	

}
