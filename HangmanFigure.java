import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.*;

import javax.swing.JPanel;

public class HangmanFigure extends JPanel {
	
	private int guesses;

	public HangmanFigure() {
		super();
		guesses = 0;
		setPreferredSize(new Dimension(300, 300));
		setOpaque(true);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		setBackground(Color.cyan);
		
		//stand set up
		int[] galBaseX = {30,80,200,150};
		int[] galBaseY = {260,220,220,260};
		int[] galEdgeX = {150,200,200,150};
		int[] galEdgeY = {260,220,230,270};
		
		//right arm setup
		int[] right_arm_x = {170,205,200,160};
		int[] right_arm_y = {115,145,150,120};
		
		//left arm setup
		int[] left_arm_x = {155,130,132,160};
		int[] left_arm_y = {110,145,148,115};
		
		//right leg setup
		int[] right_leg_x = {176,195,185,163};
		int[] right_leg_y = {173,215,220,170};
		
		//left leg setup
		int[] left_leg_x = {154,135,145,165};
		int[] left_leg_y = {173,215,220,170};
		
		//drawing 
		Rectangle2D.Double frontBase = new Rectangle2D.Double(30,260,120,10);
		Rectangle2D.Double post = new Rectangle2D.Double(70, 40, 20, 190);
		Rectangle2D.Double crossBar = new Rectangle2D.Double(70, 20, 120, 20);
	
		Polygon galBase = new Polygon(galBaseX, galBaseY, 4);
		Polygon galEdge = new Polygon(galEdgeX, galEdgeY, 4);
		
		Ellipse2D.Double left_eye = new Ellipse2D.Double(153, 80, 6, 6);
		Ellipse2D.Double right_eye = new Ellipse2D.Double(165, 80, 6, 6);
		Ellipse2D.Double  head = new Ellipse2D.Double(148.5,70,28,38);
		Ellipse2D.Double body = new Ellipse2D.Double(145.5,105,35,80);
		Line2D.Double mouth = new Line2D.Double(153, 90, 165, 90);
		
		Polygon rightArm = new Polygon(right_arm_x, right_arm_y, 4);
		Polygon leftArm = new Polygon(left_arm_x,left_arm_y,4);
		Polygon rightLeg = new Polygon(right_leg_x,right_leg_y,4);
		Polygon leftLeg = new Polygon(left_leg_x,left_leg_y,4);
		
		Rectangle2D.Double rope = new Rectangle2D.Double(160, 40, 7, 40);
		Ellipse2D.Double  ropeO = new Ellipse2D.Double(148.5, 65, 30, 50);
		Ellipse2D.Double ropeI = new Ellipse2D.Double(153.5,70, 20, 40);
		
		Rectangle2D.Double shirt = new Rectangle2D.Double(146, 118, 35, 40);
		Rectangle2D.Double skirt = new Rectangle2D.Double(146, 154, 35, 32);
		Ellipse2D.Double left_shoe = new Ellipse2D.Double(128, 205, 30, 13);
		Ellipse2D.Double right_shoe = new Ellipse2D.Double(178, 205, 30, 13);
		
		Rectangle2D.Double lose_sign = new Rectangle2D.Double(0, 0, 300, 300);
		
		Rectangle2D.Double background= new Rectangle2D.Double(0, 0, 300, 300);
		g2.setColor(Color.CYAN);
		g2.fill(background);
		
		g2.setColor(new Color(153,61,25));
		g2.fill(post);
		g2.fill(frontBase);
		g2.fill(crossBar);
		g2.fill(galBase);
		g2.fill(galEdge);
		g2.fill(ropeO);
		g2.fill(rope);
		
		g2.setColor(new Color(153,61,25));
		g2.draw(post);
		g2.draw(frontBase);
		g2.draw(crossBar);
		g2.draw(galBase);
		g2.draw(galEdge);
		
		g2.setColor(new Color(219,187,157));
		g2.draw(ropeO);
		g2.draw(rope);
		
		g2.setColor(new Color(255,255,255));
		g2.fill(ropeI);
		g2.draw(ropeI);
		
		
		
		// face
		if(guesses > 0) {
			g2.setColor(new Color(225,170,145));
			g2.fill(head);
			g2.draw(head);
			
			g2.setColor(new Color(0, 0, 255));
			g2.fill(left_eye);
			g2.fill(right_eye);
			g2.draw(left_eye);
			g2.draw(right_eye);
			
			g2.setColor(new Color(0, 0, 0));
			g2.fill(mouth);
			g2.draw(mouth);
		}
		
		g2.setColor(new Color(225,170,145));
		
		// body
		if(guesses > 1) {
			g2.fill(body);
			g2.draw(body);
		}
		
		// left arm
		if(guesses > 2) {
			g2.fill(leftArm);
			g2.draw(leftArm);
		}
		
		// right arm
		if(guesses > 3) {
			g2.fill(rightArm);
			g2.draw(rightArm);
			
		}
		
		// left leg
		if(guesses > 4) {
			g2.fill(leftLeg);
			g2.draw(leftLeg);
		}
		
		// right leg
		if(guesses > 5) {
			g2.fill(rightLeg);
			g2.draw(rightLeg);
		}
		
		//shirt
		if(guesses > 6) {
			g2.setColor(new Color(255, 190, 190));
			g2.fill(shirt);
			g2.draw(shirt);
		}
		
		//skirt
		if(guesses > 7) {
			g2.setColor(new Color(0, 0, 255));
			g2.fill(skirt);
			g2.draw(skirt);
		}
		
		//left shoe
		if(guesses > 8) {
			g2.setColor(new Color(0, 0, 0));
			g2.fill(left_shoe);
			g2.draw(left_shoe);
		}
		
		if(guesses > 9) {
			g2.fill(right_shoe);
			g2.draw(right_shoe);
		}
		
		if(guesses > 10) {
			//g2.setColor(new Color(0, 0, 0));
			g2.fill(lose_sign);
			g2.draw(lose_sign);
			g2.setColor(Color.WHITE);
			g2.drawString("YOU LOSE!", 125, 125);
		}
	}
	public void set() {
		guesses++;
		paintComponent(getGraphics());
	}
	
}
