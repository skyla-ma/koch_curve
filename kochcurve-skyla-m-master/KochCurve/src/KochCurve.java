import processing.core.PApplet;


/**
  @(#)KochCurve.java


  @author
  @version
*/
public class KochCurve {

	int level; 
	int length;

    public KochCurve(int level, int length) {
    	this.level = level;
    	this.length = length;
    }
    
    public void draw(PApplet marker, double angle, double xcoord, double ycoord) {
    	drawKochCurve(marker, level, length, angle, xcoord, ycoord);
    }

    private void drawKochCurve(PApplet marker, int level, double length, double angle, double xcoord, double ycoord) {
    	if(level < 1) {
    		marker.line((float) xcoord, (float) ycoord, (float) (xcoord+length*Math.cos(Math.toRadians(angle))), (float) (ycoord+length*Math.sin(Math.toRadians(angle))));
    	}
    	else {
    		//draw k-1 level Koch Curve of 1/3 current length
    		drawKochCurve(marker, level-1, length*((double)1/3), angle, xcoord, ycoord);
    		drawKochCurve(marker, level-1, length*((double)1/3), angle+60, xcoord+(Math.cos(Math.toRadians(angle))*((double)1/3)*length), ycoord+(Math.sin(Math.toRadians(angle))*((double)1/3)*length));
    		//drawKochCurve(marker, level-1, length*((double)1/3), angle+120, xcoord+(Math.cos(Math.toRadians(angle))*((double)2/3)*length), ycoord+(Math.sin(Math.toRadians(angle))*((double)2/3)*length));
    		drawKochCurve(marker, level-1, length*((double)1/3), angle-60, (xcoord+(Math.cos(Math.toRadians(angle))*((double)1/3)*length))+(Math.cos(Math.toRadians(angle+60))*length*(double)1/3), (ycoord+(Math.sin(Math.toRadians(angle))*((double)1/3)*length)+(Math.sin(Math.toRadians(angle+60))*length*(double)1/3)));
    		drawKochCurve(marker, level-1, length*((double)1/3), angle, xcoord+(Math.cos(Math.toRadians(angle))*((double)2/3)*length), ycoord+(Math.sin(Math.toRadians(angle))*((double)2/3)*length));
    	}
    }

}
