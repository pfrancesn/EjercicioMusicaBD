import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BDController {
	private Connection conexion;

	public BDController() {
		super();
		try {
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/musica_pablo", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el constructor vacio del BDController");
			e.printStackTrace();
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Artista> listadoArtistas() {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from artista");
			while (rs.next()) {
				artistas.add(new Artista(rs.getString("dni"), rs.getString("nombre")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistas");
			e.printStackTrace();
		}
		return artistas;
	}

	public ArrayList<Artista> listadoArtistasPorLetra(String letra) {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from artista where nombre like '" + letra + "%';");
			while (rs.next()) {
				artistas.add(new Artista(rs.getString("dni"), rs.getString("nombre")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistasPorLetra");
			e.printStackTrace();
		}
		return artistas;
	}

	public void dardeAltaArtista(Artista artista) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String cadena = "Insert artista (dni, nombre) values ('" + artista.getDni() + "', '" + artista.getNombre()
					+ "');";
			miStatement.executeUpdate(cadena);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en dardeAltaArtista");
			e.printStackTrace();
		}
	}

	public void dardeBajaArtista(Artista artista) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String cadena = "delete from artista where dni='" + artista.getDni() + "';";
			miStatement.executeUpdate(cadena);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en bajaOpositor");
			e.printStackTrace();
		}
	}

	public ArrayList<Artista> listadoArtistasPorNumero(String numero) {
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from artista where dni like '%" + numero + "';");
			while (rs.next()) {
				artistas.add(new Artista(rs.getString("dni"), rs.getString("nombre")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistasPorNumero");
			e.printStackTrace();
		}
		return artistas;
	}

	public ArrayList<Cancion> listadoCanciones() {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from cancion");
			while (rs.next()) {
				canciones.add(new Cancion(rs.getString("cod"), rs.getString("titulo"), rs.getDouble("duracion")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistas");
			e.printStackTrace();
		}
		return canciones;
	}

	public Cancion cancionmasLarga() {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from cancion order by duracion desc limit 0,1");
			while (rs.next()) {
				canciones.add(new Cancion(rs.getString("cod"), rs.getString("titulo"), rs.getDouble("duracion")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistas");
			e.printStackTrace();
		}
		return canciones.get(0);
	}

	public ArrayList<Cancion> cancionesMenorLongitud(double duracion) {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from cancion where duracion<" + duracion);
			while (rs.next()) {
				canciones.add(new Cancion(rs.getString("cod"), rs.getString("titulo"), rs.getDouble("duracion")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoArtistas");
			e.printStackTrace();
		}
		return canciones;
	}

	public ArrayList<Cancion> cancionesDisco(String discName) {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("SELECT * FROM cancion WHERE ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return canciones;

	}

	public boolean existeArtista(String dni) {
		boolean existe = false;
		try {
			Statement miStatement = this.conexion.createStatement();
			String sql = "SELECT * FROM artista WHERE dni LIKE '" + dni + "'";
			ResultSet rs = miStatement.executeQuery(sql);
			if (rs.next()==true) {
				existe = true;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error en existe artista");
		}
		return existe;

	}

}
