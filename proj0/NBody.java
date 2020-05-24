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
		for (int i = 0; i < 5; i++){
			Body body = new Body(in.readDouble(), in.readDouble(),
				in.readDouble(), in.readDouble(), in.readDouble(),
				in.readString());
			res[i] = body;
		}
		return res;
	}
}