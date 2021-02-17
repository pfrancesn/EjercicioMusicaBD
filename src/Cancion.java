
public class Cancion {
	private String cod;
	private String titulo;
	private double duracion;
	
	public Cancion() {
		super();
	}

	public Cancion(String cod, String titulo, double duracion) {
		super();
		this.cod = cod;
		this.titulo = titulo;
		this.duracion = duracion;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Cancion [cod=" + cod + ", titulo=" + titulo + ", duracion=" + duracion + "]";
	}
	
}