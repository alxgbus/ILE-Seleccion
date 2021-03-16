package ec.com.ILE.tren;

public class Edge {
	public Town origen;
	public Town destino;
	public int peso;
	public Edge siguiente;

	public Edge(Town origen, Town destino) {
		this(origen, destino, Integer.MAX_VALUE);
	}

	public Edge(Town origen, Town destino, int peso) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
		this.siguiente = null;
	}

	public Edge next(Edge edge) {
		this.siguiente = edge;
		return this;
	}

	public String toString() {
		return origen + "a" + destino;
	}

	public double getPeso() {
		return peso;
	}
}
