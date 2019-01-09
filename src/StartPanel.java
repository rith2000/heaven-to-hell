import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;


public class StartPanel extends JPanel implements ActionListener {
	
	private Main w;
	private Image cover, coverBelow;
	
	
	public StartPanel(Main w) {
		this.w = w;
		JPanel p = new JPanel();
		p.setBackground(new Color(0,0,0,0));  // Panel is transparent
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));	
		p.add(Box.createVerticalStrut(300));   // Move down by 300 pixels  
		
		JButton button = new JButton("Play the Game!");
		button.addActionListener(this);
		p.add(button);
		add(p);
		
		cover = (new ImageIcon("HeavenToHellCover.jpg")).getImage();
		coverBelow = (new ImageIcon("coverB.png")).getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		double ratioX = getWidth() / 800.0;
		double ratioY = getHeight() / 600.0;
		
		Graphics2D g2 = (Graphics2D)g;
		
		AffineTransform af = g2.getTransform();
		
		g2.scale(ratioX,ratioY);
		
		g.drawImage(cover, 0, 0, 800, 400, this);
		g.drawImage(coverBelow, 0, 400, 800, 1800, this);
	
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
		
		
		g2.setTransform(af);
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel("2");
	}
	
}