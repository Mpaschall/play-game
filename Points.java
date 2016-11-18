import java.util.*;

public class Points{
	private static double points = 0.0;
	
	public Points(){
	}
	public void setPoints(double points){
		this.points = points;
	}
	public static double getPoints(){
		return points;
	}
	public static double addPoints(){
		points += 10;
		return points;
	}
	

}
