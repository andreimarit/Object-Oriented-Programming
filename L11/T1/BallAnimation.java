import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BallAnimation extends JPanel{
	
	private static final int BOX_WIDTH = 640;
	private static final int BOX_HEIGHT = 480;
	
	private float ballRadius = 20;
	private float ballX = ballRadius + 50;
	private float ballY = ballRadius + 20;
	private float ballSpeedX = 3;
	private float ballSpeedY = 2;
	Color ballColor = Color.blue;
	
	private static final int UPDATE_RATE = 90;
	
	public BallAnimation() {
		this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
		
		Thread gameThread = new Thread() {
			public void run() {
				while(true) {
					ballX += ballSpeedX;
					ballY += ballSpeedY;
					
					if(ballX - ballRadius < 0) {
						ballSpeedX = -ballSpeedX;
						ballX = ballRadius;
						int red = (int)(Math.random() * 255);
						int green = (int)(Math.random() * 255);
						int blue = (int)(Math.random() * 255);
						ballColor = new Color(red, green, blue);
					} else if(ballX + ballRadius > BOX_WIDTH) {
						ballSpeedX = -ballSpeedX;
						ballX = BOX_WIDTH - ballRadius;
						int red = (int)(Math.random() * 255);
						int green = (int)(Math.random() * 255);
						int blue = (int)(Math.random() * 255);
						ballColor = new Color(red, green, blue);
					}
					
					if(ballY - ballRadius < 0) {
						ballSpeedY = -ballSpeedY;
						ballY = ballRadius;
						int red = (int)(Math.random() * 255);
						int green = (int)(Math.random() * 255);
						int blue = (int)(Math.random() * 255);
						ballColor = new Color(red, green, blue);
					} else if(ballY + ballRadius > BOX_HEIGHT) {
						ballSpeedY = -ballSpeedY;
						ballY = BOX_HEIGHT - ballRadius;
						int red = (int)(Math.random() * 255);
						int green = (int)(Math.random() * 255);
						int blue = (int)(Math.random() * 255);
						ballColor = new Color(red, green, blue);
					}
					
					repaint();
					try {
						Thread.sleep(1000 / UPDATE_RATE);
					} catch (Exception ex) {};
				}
			}
		};
		gameThread.start();
	}

	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Bouncing Ball");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(new BallAnimation());
				frame.setContentPane(new BallAnimation());
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
	
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.white);
			g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);
			
			g.setColor(ballColor);
			g.fillOval((int)(ballX - ballRadius), (int)(ballY - ballRadius), (int)(2 * ballRadius), (int)(2 * ballRadius));
			g.setColor(Color.blue);
			String coord = ("x = " + ballX + " y = " + ballY);
		    g.drawString(coord, 10, 10);
		}




}
