import processing.core.PApplet;

public class KochSnowflake {
	
	int level;
	int length;
	KochCurve curve;
	KochCurve curve1; 
	KochCurve curve2;
	
	public KochSnowflake(int level, int length) {
		this.level = level;
		this.length = length;
		curve = new KochCurve(level, length);
		curve1 = new KochCurve(level, length);
		curve2 = new KochCurve(level, length);
	}
	
	public void draw(PApplet marker) {
		drawKochSnowflake(marker, level, length);
	}
	
	private void drawKochSnowflake(PApplet marker, int level, int length) {
		curve.draw(marker, 180, 200, 100);
		curve1.draw(marker, 300, 150, 100+100*Math.sin(Math.toRadians(60)));
		curve2.draw(marker, 60, 100, 100);
	}
}
