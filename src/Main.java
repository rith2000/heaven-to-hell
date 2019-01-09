import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame  {//RS
	
	private Level level1; //Am
	private Level level2; //Rith
	private Level level3;//Rith
	private Level level4;
	private Level level5;
	private Level level6;//Rith
	private ArrayList<Level> levels;


	private JPanel cardPanel;
	
	public Main(String title){ //RS 
		super(title);
		setBounds(100, 100, 640, 480);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	    cardPanel = new JPanel();//RS 
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    levels = new ArrayList<Level>();
	    createLevel1();
	    createLevel2();
	    createLevel3();
	    createLevel4();
	    createLevel5();
	    createLevel6();
	    levels.add(level1);
	    levels.add(level2);
	    levels.add(level3);
	    levels.add(level4);
	    levels.add(level5);
	    levels.add(level6);
	   
	    StartPanel panel1 = new StartPanel(this);
	    OptionPanel gamePanel = new OptionPanel(this, levels);

	    // this.add(gamePanel);  
	    
	    
	    cardPanel.add(panel1,"1"); // Card is named "1"
	    //cardPanel.add(panel2,"2");
	    cardPanel.add(gamePanel,"2");
	    
	    add(cardPanel);
	    addKeyListener(gamePanel);//RS	
	    
	    setVisible(true);
	}
	
	
private void createLevel1(){
		
		level1 = new Level (2000, 1200);
		MovingImage img;
		MovingImage imgHell;
		Enemy imgE;
		Portal imgP;
		Powerup imgPow;
		
		imgHell = new MovingImage("hell1.jpg",0,0,2000,1200, true, 3); // cloud //RS
		level1.addDecoration(imgHell); 
		
		img = new MovingImage("PLATFORMCloud.png",0,550,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
		level1.addPlatform(img);
		
		img = new MovingImage("PLATFORMCloud.png",1530,1000,500,50, true, 0); // Rith (1600 to 1530)
		level1.addPlatform(img);
		
		img = new MovingImage("PLATFORMCloud.png",930,1100,500,50, true, 0); // Rith (1100 to 930)
		level1.addPlatform(img);
		
		img = new MovingImage("PLATFORMCloud.png",0,1200,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
		level1.addPlatform(img);
		
		img = new MovingImage("PLATFORMCloud.png",150,700,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
		level1.addPlatform(img);
		
		img = new MovingImage("PLATFORMCloud.png",300,1000,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
		level1.addPlatform(img);
		
		//POWERUP
		
		imgPow = new Powerup(1600,800, 1); //health 
		level1.addPowerup(imgPow);
		
		//PORTAL
		
		imgP = new Portal(1900,900); //RS
		level1.addPortal(imgP);
		
		//ENEMIES
		
		imgE = new Enemy(925,1000 ,1200,1000, .01);
		level1.addEnemy(imgE);
		
		imgE = new Enemy(1000,1100 ,1000,700, .03);
		level1.addEnemy(imgE);
		
		//ARROWKEYS
		
		img = new MovingImage("rightArrow.png",250, 300, 300, 150, true, 3); // cloud 
		level1.addDecoration(img);
		
		
		img = new MovingImage("upArrow.png",650 + 100, 800, 300, 150, true, 3); // cloud 
		level1.addDecoration(img);
		
		img = new MovingImage("rightArrow.png",650, 800, 300, 150, true, 3); // cloud 
		level1.addDecoration(img);
		
	}
	
	private void createLevel2(){ //RITH
			
			level2 = new Level (2000, 1200);//Rith 
			MovingImage img;
			Enemy imgE;
			Portal imgP;
			Powerup imgPow;
			
			MovingImage imgHell;
			imgHell = new MovingImage("hell2.jpg",0,0,2000,1200, true, 3); // cloud //RS
			level2.addDecoration(imgHell); 
			
			//POWERUP
			
			imgPow = new Powerup(1250,600,1); //health 
			level2.addPowerup(imgPow);
			
			//PLATFORM
			
			img = new MovingImage("PLATFORMCloud.png",0,320,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
			level2.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",570,260,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
			level2.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",1070,1100,200,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
			level2.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",1170,1000,100,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
			level2.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",1270,900,100,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
			level2.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",1370,800,100,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
			level2.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",1570,900,100,50, true, 0); // 
			level2.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",1670,1000,320,50, true, 0); //health 
			level2.addPlatform(img);
			
			imgP = new Portal(1900,900); //RS
			level2.addPortal(imgP);//RS
			
			//ENEMIES
			
			imgE = new Enemy(1000,300 ,1000,0, .02);
			level2.addEnemy(imgE);
			
			imgE = new Enemy(834,300 ,834,0, .02);
			level2.addEnemy(imgE);
			
			imgE = new Enemy(1000,680 ,1800,680, .01);
			level2.addEnemy(imgE);
			
			imgE = new Enemy(1100,850,1700,850, .01);
			level2.addEnemy(imgE);
			
		}
	
		private void createLevel3(){//RS
		
		level3 = new Level (2000, 1200);	
			MovingImage img;
			Enemy imgE;
			Portal imgP;
			Powerup imgPow;//RS
			
		MovingImage imgHell;
		imgHell = new MovingImage("hell3.jpg",0,0,4000,1200, true, 3);  //RS
		level3.addDecoration(imgHell); 
		
		//Powerup
		imgPow = new Powerup(1180,250,1); //health 
		level3.addPowerup(imgPow);
		
		//PLATFORMS
		
		img = new MovingImage("PLATFORMCloud.png",0,550,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
		level3.addPlatform(img);
		
		img = new MovingImage("PLATFORMCloud.png",575,650,30,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
		level3.addPlatform(img);
		
		img = new MovingImage("PLATFORMCloud.png",700,700,300,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
		level3.addPlatform(img);
		
		img = new MovingImage("PLATFORMCloud.png",1105,675,50,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
		level3.addPlatform(img);
		
		img = new MovingImage("PLATFORMCloud.png",1150,545,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
		level3.addPlatform(img);
		
		img = new MovingImage("PLATFORMCloud.png",1150,425,100,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
		level3.addPlatform(img);
		
		img = new MovingImage("PLATFORMCloud.png",1350,1150,300,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
		level3.addPlatform(img);
		
		img = new MovingImage("PLATFORMCloud.png",1800,800,200,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
		level3.addPlatform(img);
		
		//Enemies
		
		imgE = new Enemy(1000,700 ,1000,500, .02);
		level3.addEnemy(imgE);
		
		imgE = new Enemy(1050,375 ,1350,375, .02);
		level3.addEnemy(imgE);
		
		imgE = new Enemy(1600,730 ,1800,730, .03);
		level3.addEnemy(imgE);
		
		imgE = new Enemy(1675,1000 ,1675,1200, .04);
		level3.addEnemy(imgE);
		
		//Portal
		
		imgP = new Portal(1750,1100); //RS
		level3.addPortal(imgP);//RS*/
		
	}
		
		private void createLevel4(){
			
			level4 = new Level (2000, 1200);
			MovingImage img;
			Enemy imgE;
			Portal imgP;
			Powerup imgPow;//RS
			
			MovingImage imgHell;
			imgHell = new MovingImage("hell4.jpg",0,0,2000,1200, true, 3); // cloud //RS
			level4.addDecoration(imgHell); 
			
			//Powerup
			imgPow = new Powerup(1180,250,1); //health 
			level4.addPowerup(imgPow);
			
			
			//PLATFORMS
			img = new MovingImage("PLATFORMCloud.png",300,900,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
			level4.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",900,800,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
			level4.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",1000,700,100,80, true, 0); // cloud 
			level4.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",1100,600,100,80, true, 0); // cloud 
			level4.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",1200,500,70,70, true, 0); //health 
			level4.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",1300,400,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
			level4.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",1400,300,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
			level4.addPlatform(img);
			
			img = new MovingImage("PLATFORMCloud.png",1500,200,500,50, true, 0); // textured = like infinity brik, false textured = mario (nonrepeated image) 
			level4.addPlatform(img);
			
			
			//ENEMIES
			/*
			 * imgE = new Enemy(800,830 ,300,830, .02);
			level4.addEnemy(imgE);
			*/
			imgE = new Enemy(1220,250 ,1220,500, .02);
			level4.addEnemy(imgE);
			
			imgE = new Enemy(1650,250 ,1650,400, .02);
			level4.addEnemy(imgE);
			
			imgE = new Enemy(1600,730 ,1900,730, .03);
			level4.addEnemy(imgE);
			
			imgE = new Enemy(1900,930 ,1600,930, .03);
			level4.addEnemy(imgE);
			
			
			//PORTAL
			imgP = new Portal(1750,1100); //RS
			level4.addPortal(imgP);//RS*/
			
		}
	
	
	private void createLevel5(){
			
			level5 = new Level (2000, 1200);
			MovingImage img4;
			Friend img;
			Enemy imgE;
			Portal imgP;
			Powerup imgPow;
			
			MovingImage imgHell;
			imgHell = new MovingImage("hell5.jpg",0,0,2000,1200, true, 3); // cloud //RS
			level5.addDecoration(imgHell); 
			
			//PLATFORMS
			for(int i = 0; i <= 3; i++){
				img4 = new MovingImage("PLATFORMCloud.png",500*(i),1160 ,400,50, true, 0);
				level5.addPlatform(img4);
			}
			
			img4 = new MovingImage("PLATFORMCloud.png",1900,1100 ,100,50, true, 0);
			level5.addPlatform(img4);
			
			//FRIEND
			img = new Friend(1900, 1020);
			level5.addFriend(img);
			
			//ENEMIES
			imgE = new Enemy(200,5000,300,5000, 0.09);
			level5.addEnemy(imgE);
			
			imgE = new Enemy(370,1100 ,490,1100, .06);
			level5.addEnemy(imgE);
			
			imgE = new Enemy(870,1100 ,990,1100, .06);
			level5.addEnemy(imgE);
			
			imgE = new Enemy(1370,1100 ,1490,1100, .06);
			level5.addEnemy(imgE);
			
			imgE = new Enemy(1800,1000,2000,1000, .08);
			level5.addEnemy(imgE);
			
			
		}
	
	private void createLevel6(){
		
		level6 = new Level (2000, 1200);
		MovingImage img4;
		MovingImage img5;
		MovingImage img6;
		Friend img;
		Enemy imgE;
		Portal imgP;
		Powerup imgPow;
		
		
		for(int i = 0; i <= 3; i++){
			img4 = new MovingImage("nothing.png",500*(i),1160 ,500, 50, true, 0);
			level6.addPlatform(img4);
		}	
		
		
		img = new Friend(1025, 1073); //RS
		level6.addFriend(img);
		 
		
		img5 = new MovingImage("Heaven.jpg",0,0,2000,1200, true, 3); // cloud //RS
		level6.addDecoration(img5); 
		
		img6 = new MovingImage("YouWon.png",100,100,1800,1000, true, 3); // cloud //RS
		level6.addDecoration(img6);
	
	}	


	public static void main(String[] args)
	{
		Main w = new Main("Heaven To Hell");
	}

	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}


  
}