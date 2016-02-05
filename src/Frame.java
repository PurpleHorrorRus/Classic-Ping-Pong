import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	JPanel GameWindow;
	
	Frame(){
		setResizable(false);
		setSize(800, 600);
		setTitle("Classic Ping-Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Render.playerRectangle = new Rectangle(0, 0, 50, 200);
		Render.player2Rectangle = new Rectangle(730, 100, 50, 200);
		Render.ball = new Rectangle(0, 0, 50, 50);
		GameWindow = new Render();
		add(GameWindow);
		addKeyListener(new Keyboard());
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
