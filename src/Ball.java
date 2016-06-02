package Main;

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
	
	public static boolean ping, pong;
	
	static int x = (int) Player.getX(0)+50;
	static int y;
	
	static int sizeX = 50, sizeY = 50;
	
	public static int destX;

	static int destY;
	
	static int[] toSpellCount = new int[2];
	
	static Timer move;
	
	public static void setDestination(int destX, int destY){
		Ball.destX = destX;
		Ball.destY = destY;
		Ball.y = (int) Player.getY(0);
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
					if(getBallX() > 800 && !Render.ball.intersects(Render.player2Rectangle)) Game.reset();
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
	
	public static int getSizeX(){
		return Ball.sizeX;
	}
	
	static int getSizeY(){
		return Ball.sizeY;
	}
	
	public static void setSizeX(int size){
		Ball.sizeX = size;
	}
	
	public static void setSizeY(int size){
		Ball.sizeY = size;
	}
	
	public static int getBallX(){
		return Ball.x;
	}
	
	public static int getBallY(){
		return Ball.y;
	}
}
