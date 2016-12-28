import java.awt.Graphics2D;
import java.awt.geom.*;

public class Logo {
	public void draw(Graphics2D g2) {
		int frameWidth = 500;
		int frameHeight = 700;
		
		//Line2D line = new Line2D.Double(250, 0, 250, 700);
		//g2.draw(line);
		Ellipse2D e2 = new Ellipse2D.Double();
		double radius = 80;
		double centerX = (frameWidth/2);
		double centerY = radius + 20;
		e2.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);
		g2.draw(e2);
	}
}
