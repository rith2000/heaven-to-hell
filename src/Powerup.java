import java.awt.Graphics2D;
import java.awt.image.ImageObserver;



public class Powerup extends MovingImage{
	private boolean isVisible;


	public Powerup(int x, int y, int type){ //1=health,2=speed
		super("Star.png",x,y,70,70, true, 1);
		isVisible=true;
	}
	
	public void claimed(){
		isVisible=false;
	}
	
	public boolean getVisibility(){
		return isVisible;
	}


}
