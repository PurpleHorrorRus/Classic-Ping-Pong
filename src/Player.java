public class Player {
	//Initial coordinates
	static double x = 0.0; 
	static double y = 165.0;
	
	public static void setPos(double x, double y){
		Player.x = x;
		Player.y = y;
	}
	
	public static double getX(){
		return Player.x;
	}
	
	public static double getY(){
		return Player.y;
	}
}
