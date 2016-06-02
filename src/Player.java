package Main;

public class Player {
	static double[] x = new double[2];
	static double[] y = new double[2];
	
	static boolean spell[] = new boolean[3];
	
	public static void init(){
		x[0] = 0.0;
		y[0] = 165.0;
		
		x[1] = 745.0;
		y[1] = 165.0;
	}
	
	public static void setPos(int playerid, double x, double y){
		Player.x[playerid] = x;
		Player.y[playerid] = y;
	}
	
	public static double getX(int playerid){
		return Player.x[playerid];
	}
	
	public static double getY(int playerid){
		return Player.y[playerid];
	}
}
