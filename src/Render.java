import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Render extends JPanel {
		
	static Rectangle playerRectangle, player2Rectangle, ball;
	
	@Override
	protected void paintComponent(java.awt.Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());				
		playerRectangle.setLocation((int)Player.getX(), (int)Player.getY());
		player2Rectangle.setLocation((int)Player2.getX(), (int)Player2.getY());
		g.setColor(Color.WHITE);
		g.fillRect((int) Player.getX(), (int) Player.getY(), 50, 200);
		g.fillRect((int) Player2.getX(), (int) Player2.getY(), 50, 200);
		
		if(!Game.started) 
		{ 
			g.fillOval(Ball.getBallX(), (int) Player.getY(), 50, 50);  
			ball.setLocation(Ball.getBallX(), (int) Player.getY()); 
		}
		
		else { g.fillOval(Ball.getBallX(), Ball.getBallY(), 50, 50); 
		ball.setLocation(Ball.getBallX(), Ball.getBallY()); }
		
		Keyboard.tick();
		this.repaint();
	};
}
