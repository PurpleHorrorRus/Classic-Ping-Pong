import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {

	static double velY = 0;
	static double y = (double) Player.getY();
	
	static double velY2 = 0;
	static double y2 = (double) Player2.getY();
	
	static boolean NPC = false;
	static double coefficientToWinNPC = 0.6;
	
	@Override
	public void keyReleased(KeyEvent e) {
		setVelY(0);
		setVelY2(0);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		tick();
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_DOWN: 
			setVelY2(0.5);
			break;
		case KeyEvent.VK_UP:
			setVelY2(-0.5);
			break;
		case KeyEvent.VK_S:
			setVelY(0.5);
			
			break;
		case KeyEvent.VK_W:
			setVelY(-0.5);
			break;
		case KeyEvent.VK_SPACE:
			if(!Game.started){
				Game.start();
			}
			break;
		case KeyEvent.VK_N:
			if(!NPC) { NPC = true; }
			else { NPC = false; }
			break;
		}
	}
	
	
	public static void setVelY(double velY){
		Keyboard.velY = velY;
	}
	
	public static void setVelY2(double velY){
		Keyboard.velY2 = velY;
	}
	
	static void tick(){
		y += velY;
		y2 += velY2;
		Player.setPos(Player.getX(), (int)y);
		if(NPC){ Player2.setPos(Player2.getX(), Ball.getBallY()*coefficientToWinNPC); }
		else{ Player2.setPos(Player2.getX(), (int)y2); }
	}
	
}
