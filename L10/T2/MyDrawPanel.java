import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel{
	
	public void paintComponent(Graphics g) {
			
			int red = (int)(Math.random() * 255);
			int green = (int)(Math.random() * 255);
			int blue = (int)(Math.random() * 255);
			
			g.setColor(new Color(red, green, blue));
			
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

	}
	
}
