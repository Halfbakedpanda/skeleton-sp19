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

	public double calcNetForceExertedByX(Body[] allBodys) {
		double res = 0;
		for (Body planet: allBodys){
			if (this.equals(planet)) {
				continue;
			} else{
				double dx = planet.xxPos - this.xxPos;
				double r = this.calcDistance(planet);
				double tf = this.calcForceExertedBy(planet);
				double xf = tf*dx/r;
				res += xf;
			}
		}
		return res;
	}


	public double calcNetForceExertedByY(Body[] allBodys) {
		double res = 0;
		for (Body planet: allBodys){
			if (this.equals(planet)) {
				continue;
			} else{
				double dy = planet.yyPos - this.xxPos;
				double r = this.calcDistance(planet);
				double tf = this.calcForceExertedBy(planet);
				double yf = tf*dy/r;
				res += yf;
			}
		}
		return res;
	}


	public void update(double dt, double fX, double fY) {
		double ax = fX/this.mass;
		double ay = fY/this.mass;
		xxVel += dt*ax;
		yyVel += dt*ay;
		xxPos += dt*xxVel;
		yyPos += dt*yyVel;
	}


	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos , "images/" + this.imgFileName);
		StdDraw.show();
	}

	/**
	public static void main(String[] args){
		Body samh = new Body(1, 0, 0, 0, 10, "samh.gif");
		Body rocinante = new Body(5, -3, 0, 0, 50, "Rocinante.gif");
		Body aegir = new Body(3, 3, 0, 0, 5, "Aegir.gif");

		Body[] allBodys = {samh, rocinante, aegir};
		samh.calcNetForceExertedByX(allBodys);
		samh.calcNetForceExertedByY(allBodys);
	}
	*/
}