public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double ConstantG = 6.67e-11;


	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}


	//Planet p = new Planet();



	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	
    public double calcDistance(Planet p) {
    	double dx = p.xxPos - this.xxPos;
    	double dy = p.yyPos - this.yyPos;
    	double r = Math.sqrt(dx*dx + dy*dy);
    	return r;
    }

    public double calcForceExertedBy(Planet p){
    	double SquareR = (this.calcDistance(p)) * (this.calcDistance(p));
    	double F = (ConstantG * this.mass * p.mass) / SquareR;
    	return F;
    }

    public double calcForceExertedByX(Planet p) {
    	double dx = p.xxPos - this.xxPos;
    	double Fx = (this.calcForceExertedBy(p) * dx) / (this.calcDistance(p));
    	return Fx;
    }

    public double calcForceExertedByY(Planet p) {
    	double dy = p.yyPos - this.yyPos;
    	double Fy = (this.calcForceExertedBy(p) * dy) / (this.calcDistance(p));
    	return Fy;
    }


    public double calcNetForceExertedByX(Planet[] pa) {
    	//Planet[] allPlanets = {samh,rocinante,aegir};
    	double NetFx = 0;
    	for (int i = 0; i < pa.length; i += 1) {
    	if (this.equals(pa[i])) {
    		continue;
    		}
    	else {
    	NetFx = NetFx + this.calcForceExertedByX(pa[i]); 
    		}
       }
       return NetFx;
	}

	public double calcNetForceExertedByY(Planet[] pa) {
    	//Planet[] allPlanets = {samh,rocinante,aegir};
    	double NetFy = 0;
    	for (int i = 0; i < pa.length; i += 1) {
    	if (this.equals(pa[i])) {
    		continue;
    		}
    	else {
    	NetFy = NetFy + this.calcForceExertedByY(pa[i]); 
    		}
       }
       return NetFy;
	}

	public void update(double dt, double fX, double fY) {
		double ax = fX / this.mass;
		double ay = fY / this.mass;
		this.xxVel = this.xxVel + dt * ax;
		this.yyVel = this.yyVel + dt * ay;
		this.xxPos = this.xxPos + dt * xxVel;
		this.yyPos = this.yyPos + dt * yyVel;
	}

	public static void draw(double xP, double yP, String imgFileName) {
		StdDraw.picture(xP, yP, imgFileName);
	}


}