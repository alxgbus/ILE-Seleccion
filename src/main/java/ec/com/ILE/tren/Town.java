package ec.com.ILE.tren;

public class Town {
	protected String nombre;
	protected boolean visitado;

	public Town(String name) {
		this.nombre = name;
		this.visitado = false;
	}

	public String getName() {
		return this.nombre;
	}

	public boolean getVisited() {
		return this.visitado;
	}
}
