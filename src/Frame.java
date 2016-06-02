package Main;

import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	
	JPanel GameWindow;
	
	Frame(){
		setResizable(false);
		setSize(800, 600);
		setTitle("Classic Ping-Pong [Nikifor0ff.ru]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Render.playerRectangle[0] = new Rectangle(0, 0, 50, 200);
		Render.playerRectangle[1] = new Rectangle(730, 100, 50, 200);
		Render.ball = new Rectangle(0, 0, Ball.getSizeX(), Ball.getSizeY());
		GameWindow = new Render();
		add(GameWindow);
		addKeyListener(new Keyboard());
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
