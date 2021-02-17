
public class Artista {
	private String dni;
	private String nombre;
	
	public Artista(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	public Artista() {
		super();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Artista [dni=" + dni + ", nombre=" + nombre + "]";
	}
	
	
}
