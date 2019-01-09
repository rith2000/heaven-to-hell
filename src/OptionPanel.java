import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

import java.util.*;


public class OptionPanel extends SimpleWindow /*RS*/ implements KeyListener
{

	private String message;
	private Main m;
	

	public OptionPanel (Main m, ArrayList<Level> lvls) {
		super(lvls);
		this.m = m;
		message = "Press escape to pause."; 
		
	      
	}


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		Graphics2D g2 = (Graphics2D)g;

		int width = getWidth();
		int height = getHeight();

		double ratioX = (double)width/800.0;
		double ratioY = (double)height/600.0;

		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);

		g.setColor(Color.WHITE);
		g.setFont(new Font("SansSerif",Font.BOLD,16));
		int strWidth = g.getFontMetrics().stringWidth(message);
		g.drawString(message, 400-strWidth/2, 15);//RS
		
		
		

		g2.setTransform(at);

		
	}
	
	


	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			m.changePanel("1");
		}else{
			super.keyPressed(e);//RS
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyTyped(e);
	}


}
