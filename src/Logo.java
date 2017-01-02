import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;

import javax.swing.Icon;

public class Logo implements Icon {

	private int width;
	private int height;
	Color pinkTan = new Color(214, 132, 87);
	Color lightTan = new Color(214, 174, 126);

	
	public Logo(int w, int h){
		width = w;
		height = h;
	}

	public int getIconWidth() {
		return width;
	}

	public int getIconHeight() {
		return height;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double e2 = new Ellipse2D.Double(x, y, width, height);
		g2.setPaint(lightTan);
		g2.fill(e2);
		g2.draw(e2);
		
		
	}	
//	public void draw(Graphics2D g2) {
//		int frameWidth = 500;
//		int frameHeight = 700;
//		Color tan = new Color(214, 132, 87);
//
//		
//		//Line2D line = new Line2D.Double(250, 0, 250, 700);
//		//g2.draw(line);
//		Ellipse2D.Double e2 = new Ellipse2D.Double();
//		double radius = 80;
//		double centerX = (frameWidth/2);
//		double centerY = radius + 20;
//		g2.setPaint(tan);
//		g2.fill(e2);
//		g2.fillOval((int)centerX, (int)centerY, (int)(centerX+radius), (int)(centerY+radius));
//		e2.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);
//		g2.draw(e2);
//	}
}
