import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opc = 0;
		BDController controladorBD = new BDController();
		Scanner sc = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);
		ArrayList<Artista> artis = new ArrayList<Artista>();
		ArrayList<Cancion> cancis = new ArrayList<Cancion>();
		do {
			Main.mostrarMenu();
			opc = sn.nextInt();
			switch(opc) {
			case 1:
				artis = controladorBD.listadoArtistas();
				for (int i = 0; i < artis.size(); i++) {
					System.out.print("Nombre: ");
					System.out.print(artis.get(i).getNombre());
					System.out.print(" DNI: ");
					System.out.println(artis.get(i).getDni());
				}
				System.out.println("--------------");
				break;
			case 2:
				System.out.println("Introduce una letra");
				String letra = sc.nextLine();
				artis = controladorBD.listadoArtistasPorLetra(letra);
				for (int i = 0; i < artis.size(); i++) {
					System.out.print("Nombre: ");
					System.out.print(artis.get(i).getNombre());
					System.out.print(" DNI: ");
					System.out.println(artis.get(i).getDni());
				}
				break;
			case 3:
			
				System.out.println("¿Quieres dar de alta o de baja a un artista?");
				System.out.println("1. Baja");
				System.out.println("2. Alta");
				artis = controladorBD.listadoArtistas();
				int opc2 = sn.nextInt();
				if (opc2==1) {
					System.out.println("Introduce el dni de un artista");
					String dni = sc.nextLine();
					boolean encontrado = false;
					for (int i = 0; i < artis.size(); i++) {
						if(artis.get(i).getDni().equalsIgnoreCase(dni)) {
							controladorBD.dardeBajaArtista(artis.get(i));
							encontrado = true;
						}
					}
					if (encontrado==false) {
						System.out.println("No hay niingún artista con ese dni");
					}
				}else if(opc2==2) {
					System.out.println("Introduce el dni del artista");
					String dni = sc.nextLine();
					System.out.println("Introduce el nombre del artista");
					String nombre = sc.nextLine();
					controladorBD.dardeAltaArtista(new Artista(dni, nombre));
				}
				break;
			case 4:
				System.out.println("Introduce un numero");
				String numero = sc.nextLine();
				artis = controladorBD.listadoArtistasPorNumero(numero);
				for (int i = 0; i < artis.size(); i++) {
					System.out.print("Nombre: ");
					System.out.print(artis.get(i).getNombre());
					System.out.print(" DNI: ");
					System.out.println(artis.get(i).getDni());
				}
				break;
			case 5:
				cancis = controladorBD.listadoCanciones();
				for (int i = 0; i < cancis.size(); i++) {
					System.out.print("Título: ");
					System.out.print(cancis.get(i).getTitulo());
					System.out.print(" Código: ");
					System.out.print(cancis.get(i).getCod());
					System.out.print(" Duración: ");
					System.out.println(cancis.get(i).getDuracion());
				}
				System.out.println("--------------");
				break;
			case 6:
				Cancion can = controladorBD.cancionmasLarga();
				System.out.print("Título: ");
				System.out.print(can.getTitulo());
				System.out.print(" Código: ");
				System.out.print(can.getCod());
				System.out.print(" Duración: ");
				System.out.println(can.getDuracion());
				System.out.println("--------------");
				break;
			case 7:
				System.out.println("Introduce una duracion");
				double duracion = sn.nextDouble();
				cancis = controladorBD.cancionesMenorLongitud(duracion);
				for (int i = 0; i < cancis.size(); i++) {
					System.out.print("Título: ");
					System.out.print(cancis.get(i).getTitulo());
					System.out.print(" Código: ");
					System.out.print(cancis.get(i).getCod());
					System.out.print(" Duración: ");
					System.out.println(cancis.get(i).getDuracion());
				}
				System.out.println("--------------");
				break;
			case 8:
				System.out.print("Introduce el nombre de un disco: ");
				String discName = sc.nextLine();
				cancis = controladorBD
				break;
			}
		}while(opc!=0);
		
	}
	public static void mostrarMenu() {
		System.out.println("Selecciona una opción");
		System.out.println("1. Listado de artistas");
		System.out.println("2. Listado de artistas que empicen por una letra");
		System.out.println("3. Alta o baja de artista");
		System.out.println("4. Lista de artistas que su dni acabe en un numero");
		System.out.println("5. Listado de canciones");
		System.out.println("6. Canción más larga");
		System.out.println("7. Canciones con una duración menor a la que elijas");
		System.out.println("8. Listado de canciones de un disco");
	}
}
