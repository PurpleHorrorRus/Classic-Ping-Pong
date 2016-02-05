import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Game {
	
	static boolean started;
	
	public static void start(){
		started = true;
		Ball.ping = true;
		int random = Ball.setRandom(0, 1);
		if(random == 0) Ball.setDestination(800, 0);
		if(random == 1) Ball.setDestination(800, 520);
		Ball.move.start();
	}
	
	public static void reset(){
		playSound("win.wav");
		started = false;
		Ball.move.stop();
		Ball.ping = false;
		Ball.pong = false;
		Ball.x = (int) Player.getX()+50;
		Ball.y = (int) Player.getY()+80;
	}
	
	public static synchronized void playSound(final String url) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream stream = AudioSystem.getAudioInputStream(
					ClassicPong.class.getResourceAsStream("/sounds/" + url));
					clip.open(stream);
					clip.start(); 
				} catch (Exception e) { }
			}
		}).start();
	}
}
