public class NBody {
	
	public static double readRadius(String Filename){
		In in = new In(Filename);
		int Nrow = in.readInt();
		double Radius = in.readDouble();
		return Radius;
	}

	public static Planet[] readPlanets(String Filename) {
		In in = new In(Filename);
		int N = in.readInt();
		double Radius = in.readDouble();
		Planet[] planet = new Planet[N];
		for (int i = 0; i < N; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planet[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return planet;
	}

	public static void main(String[] args){

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double R = readRadius(filename);
		Planet[] planet = readPlanets(filename);
		StdDraw.setScale(-R, R);
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for(int i = 0; i < planet.length ; i++){
			double xP = planet[i].xxPos;
			double yP = planet[i].yyPos;
			String imgFileName = "images/"+planet[i].imgFileName;
			planet[i].draw(xP,yP,imgFileName);
		}

		

		for(double t = 0; t <= T; t = t + dt){

			double[] xForces = new double[planet.length];
			double[] yForces = new double[planet.length];

				for (int i=0; i<planet.length; i++){
					double fX = planet[i].calcNetForceExertedByX(planet);
					double fY = planet[i].calcNetForceExertedByY(planet);
					xForces[i] = fX;
					yForces[i] = fY;
			}
				for (int m = 0; m < planet.length ; m++){
				planet[m].update(dt,xForces[m],yForces[m]);
			}
			StdDraw.enableDoubleBuffering();
			StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg");

				for(int i = 0; i < planet.length ; i++){

					double xP = planet[i].xxPos;
					double yP = planet[i].yyPos;
					String imgFileName = "images/"+planet[i].imgFileName;
					planet[i].draw(xP,yP,imgFileName);

		}

		StdDraw.show();
		StdDraw.pause(10);


}
StdOut.printf("%d\n", planet.length);
StdOut.printf("%.2e\n", R);
for (int i = 0; i < planet.length; i++) {
    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planet[i].xxPos, planet[i].yyPos, planet[i].xxVel,
                  planet[i].yyVel, planet[i].mass, planet[i].imgFileName);   

		}

	}
}



