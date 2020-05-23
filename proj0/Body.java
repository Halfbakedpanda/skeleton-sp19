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


	public double calcDistance(Body b) {
		double dx = this.xxPos - b.xxPos;
		double dy = this.yyPos - b.yyPos;
		double r = Math.sqrt(dx * dx + dy * dy);
		return r;
	}


	public double calcForceExertedBy(Body b) {
		double r = this.calcDistance(b);
		double tf = (6.67e-11) * this.mass * b.mass / (r*r);
		return tf;
	} 
}