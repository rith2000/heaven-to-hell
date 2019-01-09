
public class Portal extends MovingImage {
	
	public Portal(int x1, int y1) {
		super("portal.png",x1,y1,100,100, false, -1); // platform = 0, health =1, devil= -1, portal = 2, decoration = 3 , player=4
	}
	
	public void enterPortal(){
	}
	
}
