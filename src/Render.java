package Main;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Render extends JPanel {
		
	static Rectangle playerRectangle, player2Rectangle, ball;
	
	@Override
	protected void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
						
		playerRectangle.setLocation((int)Player.getX(0), (int)Player.getY(0));
		player2Rectangle.setLocation((int)Player.getX(1), (int)Player.getY(1));
		g.setColor(Color.WHITE);
		g.fillRect((int) Player.getX(0), (int) Player.getY(0), 50, 200);
		g.fillRect((int) Player.getX(1), (int) Player.getY(1), 50, 200);
		
		if(!Game.started) 
		{ 
			g.fillOval(Ball.getBallX(), (int) Player.getY(0), Ball.getSizeX(), Ball.getSizeY());  
			ball.setLocation(Ball.getBallX(), (int) Player.getY(0));
			ball.setSize(Ball.getSizeX(), Ball.getSizeY());
		}
		
		else { g.fillOval(Ball.getBallX(), Ball.getBallY(), Ball.getSizeX(), Ball.getSizeY()); 
			ball.setLocation(Ball.getBallX(), Ball.getBallY());
			ball.setSize(Ball.getSizeX(), Ball.getSizeY());
		}
		
		Keyboard.tick();
		this.repaint();
	};
}
