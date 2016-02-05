import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Ball {
	
	/*
	 * Class physics of the ball
	 * dest (destination X|Y) - Aim the direction the ball will fly
	 * playerRectangle and player2Rectangle - collision
	 * Directions:
	 * ping ->
	 * <- pong
	 */
	
	static boolean ping, pong;
	
	static int x = (int) Player.getX()+50;
	static int y;
	
	static int destX, destY;
	
	static Timer move;
	
	public static void setDestination(int destX, int destY){
		Ball.destX = destX;
		Ball.destY = destY;
		Ball.y = (int) Player.getY();
		move = new Timer(1, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pong){
					if(Render.ball.intersects(Render.playerRectangle)){
						Game.playSound("ping.wav");
						ping = true;
						pong = false;
						Ball.destX = 800;
					}
					if(getBallY() > Ball.destY) y--;
					if(getBallX() > Ball.destX) x--;
					if(getBallX() < 0 && !Render.ball.intersects(Render.playerRectangle)) Game.reset();
					if(getBallY() < Ball.destY) y++;
					
					if(getBallY() <= 0){
						Ball.destX -= setRandom(5, 10);
						Ball.destY = 600;
					}
					
					if(getBallY() >= 520){
						Ball.destX -= setRandom(5, 10);
						Ball.destY = 0;
					}
				}
				
				if(ping){
					if(Render.ball.intersects(Render.player2Rectangle)){
						Game.playSound("ping.wav");
						pong = true;
						ping = false;
						Ball.destX = 0;
					}
					
					if(getBallY() > Ball.destY) y--;
					if(getBallX() < Ball.destX) x++;
					if(getBallX() > 700 && !Render.ball.intersects(Render.player2Rectangle)) Game.reset();
					if(getBallY() < Ball.destY) y++;
					
					if(getBallY() <= 0){
						Ball.destX += setRandom(5, 10);
						Ball.destY = 600;
					}
					if(getBallY() >= 520){
						Ball.destX += setRandom(5, 10);
						Ball.destY = 0;
					}
					
				}
				
			}
		});
	}
	
	static int setRandom(int Min, int Max){
		return Min + (int)(Math.random() * ((Max - Min) + 1));
	}
	
	public static int getBallX(){
		return Ball.x;
	}
	
	public static int getBallY(){
		return Ball.y;
	}
}
