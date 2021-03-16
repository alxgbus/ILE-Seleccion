package ec.com.ILE.tren;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
	
	public List<String> rutasEjercicio1()  {

		List<String> rutasTodas = new ArrayList<String>();
        Routes graph = new Routes();

        Town  a = new Town("A");
        Town  b = new Town("B");
        Town  c = new Town("C");
        Town  d = new Town("D");
        Town  e = new Town("E");

        graph.mapaDeRutas.put(a, new Edge(a,b,5).next(new Edge(a,d,5).next(new Edge(a,e,7))));
        graph.mapaDeRutas.put(b, new Edge(b,c,4));
        graph.mapaDeRutas.put(c, new Edge(c,d,8).next(new Edge(c,e,2)));
        graph.mapaDeRutas.put(d, new Edge(d,c,8).next(new Edge(d,e,6)));
        graph.mapaDeRutas.put(e, new Edge(e,b,3));

        ArrayList<Town> routes1 = new ArrayList<Town>();
        routes1.add(a);
        routes1.add(b);
        routes1.add(c);
        rutasTodas.add("Output #1: " + evaluarDistancia(graph.distanciaEntrePueblos(routes1)));

        ArrayList<Town> routes2 = new ArrayList<Town>();
        routes2.add(a);
        routes2.add(d);
        rutasTodas.add("Output #2: " + evaluarDistancia(graph.distanciaEntrePueblos(routes2)));

        ArrayList<Town> routes3 = new ArrayList<Town>();
        routes3.add(a);
        routes3.add(d);
        routes3.add(c);
        rutasTodas.add("Output #3: " + evaluarDistancia(graph.distanciaEntrePueblos(routes3)));
        
        ArrayList<Town> routes4 = new ArrayList<Town>();
        routes4.add(a);
        routes4.add(e);
        routes4.add(b);
        routes4.add(c);
        routes4.add(d);

        rutasTodas.add("Output #4: " + evaluarDistancia(graph.distanciaEntrePueblos(routes4)));
        ArrayList<Town> routes5 = new ArrayList<Town>();
        routes5.add(a);
        routes5.add(e);
        routes5.add(d);
        
        rutasTodas.add("Output #5: " + evaluarDistancia(graph.distanciaEntrePueblos(routes5)));
        rutasTodas.add("Output #6: " + evaluarDistancia(graph.encontrarRuta(c,c,0,3)));
        rutasTodas.add("Output #7: " + evaluarDistancia(graph.encontrarRuta(a,c,0,4)));
        rutasTodas.add("Output #8: " + evaluarDistancia(graph.rutaMasCorta(a,c,0,0)));

        rutasTodas.add("Output #9: " + evaluarDistancia(graph.rutaMasCorta(b,b,0,0)));
        rutasTodas.add("Output #10: " + evaluarDistancia(graph.todasLasRutasEntrePueblos(c,c,0,30)));
        
        return rutasTodas;
	}
	
	private static String evaluarDistancia(int distanciaEntrePueblos) {
		if (distanciaEntrePueblos==-1) {
			return Constants.NO_SUCH_ROUTE;
		}
		else 
			return String.valueOf(distanciaEntrePueblos);
	}
}
