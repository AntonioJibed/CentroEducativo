package centroEducativo.model;

public class Materia {
	int id;
	String nombre;
	String acronimo;
	int idCurso;
	/**
	 * 
	 */
	public Materia() {
		super();
	}

	/**
	 * @param id
	 * @param nombre
	 * @param acronimo
	 * @param idCurso
	 */
	public Materia(int id, String nombre, String acronimo, int idCurso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.acronimo = acronimo;
		this.idCurso = idCurso;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", acronimo=" + acronimo + ", idCurso=" + idCurso + "]";
	}
	
}
