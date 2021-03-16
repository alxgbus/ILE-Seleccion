package ec.com.ILE.tren;

import java.util.ArrayList;
import java.util.Hashtable;

public class Routes {
	public Hashtable<Town, Edge> mapaDeRutas;

	public Routes() {
		this.mapaDeRutas = new Hashtable<Town, Edge>();
	}

	public Hashtable<Town, Edge> getRoutingTable() {
		return mapaDeRutas;
	}

	public int distanciaEntrePueblos(ArrayList<Town> pueblos) {
		int distancia = 0;
		int depth = 0;
		int i = 0;
		if (pueblos.size() < 2) {
			return 0;
		}
		while (i < pueblos.size() - 1) {
			if (this.mapaDeRutas.containsKey(pueblos.get(i))) {
				Edge ruta = this.mapaDeRutas.get(pueblos.get(i));
				while (ruta != null) {
					if (ruta.destino.equals(pueblos.get(i + 1))) {
						distancia += ruta.peso;
						depth++;
						break;
					}
					ruta = ruta.siguiente;
				}
			} else
				return -1;
			i++;
		}

		if (depth != pueblos.size() - 1) {
			return -1;
		}
		return distancia;
	}

	public int encontrarRuta(Town origin, Town dest, int depth, int limit) {
		int routes = 0;
		if (this.mapaDeRutas.containsKey(origin) && this.mapaDeRutas.containsKey(dest)) {
			if (depth == limit) {
				return 0;
			}
			depth++;
			origin.visitado = true;
			Edge edge = this.mapaDeRutas.get(origin);
			while (edge != null) {
				if (edge.destino.equals(dest)) {
					routes++;
					edge = edge.siguiente;
					continue;
				} else if (!edge.destino.visitado) {
					depth--;
					routes += encontrarRuta(edge.destino, dest, depth, limit);

				}
				edge = edge.siguiente;
			}
		} else {
			System.out.println(Constants.NO_SUCH_ROUTE);
		}

		origin.visitado = false;
		return routes;
	}

	public int rutaMasCorta(Town origin, Town dest, int distance, int shortestPath) {
		if (this.mapaDeRutas.containsKey(origin) && this.mapaDeRutas.containsKey(dest)) {
			origin.visitado = true;
			Edge edge = this.mapaDeRutas.get(origin);
			while (edge != null) {
				if (edge.destino == dest || !edge.destino.visitado) {
					distance += edge.peso;
				}

				if (edge.destino.equals(dest)) {
					if (shortestPath == 0 || distance < shortestPath)
						shortestPath = distance;
					origin.visitado = false;
					return shortestPath;
				}
				else if (!edge.destino.visitado) {
					shortestPath = rutaMasCorta(edge.destino, dest, distance, shortestPath);
					distance -= edge.peso;
				}
				edge = edge.siguiente;
			}
		} else {
			System.out.println(Constants.NO_SUCH_ROUTE);
		}

		origin.visitado = false;
		return shortestPath;
	}

	public int todasLasRutasEntrePueblos(Town origin, Town destination, int weight, int maxDistance) {
		int routes = 0;
		if (this.mapaDeRutas.containsKey(origin) && this.mapaDeRutas.containsKey(destination)) {

			Edge edge = this.mapaDeRutas.get(origin);
			while (edge != null) {
				weight += edge.peso;
				if (weight <= maxDistance) {
					if (edge.destino.equals(destination)) {
						routes++;
						routes += todasLasRutasEntrePueblos(edge.destino, destination, weight, maxDistance);
						edge = edge.siguiente;
						continue;
					} else {
						routes += todasLasRutasEntrePueblos(edge.destino, destination, weight, maxDistance);
						weight -= edge.peso;
					}
				} else
					weight -= edge.peso;

				edge = edge.siguiente;
			}
		} else {
			System.out.println(Constants.NO_SUCH_ROUTE);

		}
		return routes;

	}
}
