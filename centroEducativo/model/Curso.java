package centroEducativo.model;

public class Curso {

	int id;
	String descripcion;

	/**
	 * 
	 */
	public Curso() {
		super();
	}

	/**
	 * @param id
	 * @param descripcion
	 */
	public Curso(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", descripcion=" + descripcion + "]";
	}

}
