import java.lang.Math;

public class Body {
	/** Body class can represent a planet, star, or various objects
	 *  in this universe.
	 */
	
	/** Its current x position*/
	public double xxPos;

	/** Its current y position*/
	public double yyPos;

	/** Its current velocity in the x direction*/
	public double xxVel;

	/** Its current velocity in the y direction*/
	public double yyVel;

	/** Its mass*/
	public double mass;

	/** file_name corresponds to the image that depicts the body */
	public String imgFileName;

	/** First Constructor*/
	public Body(double xP, double yP, double xV,
				 double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/** Second Constructor */
	public Body(Body b){
		Body body = new Body(b);
	}


	public double calcDistance(Body body2) {
		double dx = this.xxPos - body2.xxPos;
		double dy = this.yyPos - body2.yyPos;
		double r = Math.sqrt(dx * dx + dy * dy);
		return r;
	}
}