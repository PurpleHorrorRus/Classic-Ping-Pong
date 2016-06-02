package Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {
	
	static double[] velY = new double[2];
	static double[] y = new double[2];
	
	static boolean NPC = false;
	static double coefficientToWinNPC = 0.6;
	
	public static void init(){
		for(int i = 0; i < 2; i++){
			velY[i] = 0;
			y[i] = (double) Player.getY(i);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		setVelY(0, 0);
		setVelY(1, 0);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		tick();
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_DOWN: 
			setVelY(1, 0.5);
			break;
		case KeyEvent.VK_UP:
			setVelY(1, -0.5);
			break;
		case KeyEvent.VK_S:
			setVelY(0, 0.5);
			break;
		case KeyEvent.VK_W:
			setVelY(0, -0.5);
			break;
		case KeyEvent.VK_SPACE:
			if(!Game.started) Game.start();
			break;
		case KeyEvent.VK_N:
			if(!NPC) NPC = true;
			else NPC = false;
			break;
		}
	}
	
	
	public static void setVelY(int playerid, double velY){
		Keyboard.velY[playerid] = velY;
	}
	
	static void tick(){
		for(int i = 0; i < 2; i++) y[i] += velY[i];
		Player.setPos(0, Player.getX(0), (int)y[0]);
		if(NPC) Player.setPos(1, Player.getX(1), Ball.getBallY()*coefficientToWinNPC);
		else Player.setPos(1, Player.getX(1), (int)y[1]);
	}	
}
