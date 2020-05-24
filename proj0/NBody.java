public class NBody{


	public static double readRadius(String filename) {
		In in = new In(filename);
		int Nsize = in.readInt();
		double Radius = in.readDouble();
		return Radius;
	}

	public static Body[] readBodies(String filename){
		In in = new In(filename);
		int Nsize = in.readInt();
		double Radius = in.readDouble();
		Body[] res = new Body[Nsize];
		for (int i = 0; i < Nsize; i++){
			Body body = new Body(in.readDouble(), in.readDouble(),
				in.readDouble(), in.readDouble(), in.readDouble(),
				in.readString());
			res[i] = body;
		}
		return res;
	}

	public static String imageToDraw = "images/starfield.jpg";

	public static void main(String[] args) {


		if (args.length > 0) {
			System.out.println("The T and dt are");
			double T = Double.parseDouble(args[0]);
			double dt = Double.parseDouble(args[1]);
			String filename = args[2];
			double Radius = readRadius(filename);
			Body[] Input = readBodies(filename);
			System.out.println(args);

			StdDraw.enableDoubleBuffering();

			StdDraw.setScale(-Radius, Radius);
			StdDraw.clear();

			StdDraw.picture(0, 0, imageToDraw);

			StdDraw.show();
			StdDraw.pause(2000);

			for (Body planet:Input) {
				planet.draw();
			}

			for (double time = 0; time < T; time = time + dt){
				double[] xForces = new double[Input.length];
				double[] yForces = new double[Input.length];
				for (int i = 0; i < Input.length; i++) {
					xForces[i] = Input[i].calcNetForceExertedByX(Input);
					yForces[i] = Input[i].calcNetForceExertedByY(Input);
				}
				for (int i = 0; i < Input.length; i++) {
					Input[i].update(dt, xForces[i], yForces[i]);
				}	

				StdDraw.enableDoubleBuffering();
				StdDraw.picture(0, 0, imageToDraw);

				for (Body planet:Input) {
					planet.draw();
				}
				StdDraw.show();
				StdDraw.pause(10);
			}

			StdOut.printf("%d\n", Input.length);
			StdOut.printf("%.2e\n", Radius);
			for (int i = 0; i < Input.length; i++) {
			    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
			                  Input[i].xxPos, Input[i].yyPos, Input[i].xxVel,
			                  Input[i].yyVel, Input[i].mass, Input[i].imgFileName);   
			}

			System.out.println("Done!");
		} else {
			System.out.println("No commandline args");
		}
		
	}
}