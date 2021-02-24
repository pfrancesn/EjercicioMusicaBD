import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opc = 0;
		BDController controladorBD = new BDController();
		Scanner sc = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);
		ArrayList<Artista> artistas = new ArrayList<Artista>();
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		do {
			Main.mostrarMenu();
			opc = sn.nextInt();
			switch(opc) {
			case 1:
				Main.mostrarMenu1();
				opc = sn.nextInt();
				switch(opc) {
				case 1:
					artistas = controladorBD.listadoArtistas();
					for (int i = 0; i < artistas.size(); i++) {
						System.out.print("Nombre: ");
						System.out.print(artistas.get(i).getNombre());
						System.out.print(" DNI: ");
						System.out.println(artistas.get(i).getDni());
					}
					System.out.println("--------------");
					break;
				case 2:
					canciones = controladorBD.listadoCanciones();
					for (int i = 0; i < artistas.size(); i++) {
						System.out.print("Cod: ");
						System.out.print(artistas.get(i).getNombre());
						System.out.print(" DNI: ");
						System.out.println(artistas.get(i).getDni());
					}
					break;
				}
				break;
				
			case 2:
				break;
			case 3:
			
				System.out.println("¿Quieres dar de alta o de baja a un artista?");
				System.out.println("1. Baja");
				System.out.println("2. Alta");
				artistas = controladorBD.listadoArtistas();
				int opc2 = sn.nextInt();
				if (opc2==1) {
					System.out.println("Introduce el dni de un artista");
					String dni = sc.nextLine();
					boolean encontrado = false;
					for (int i = 0; i < artistas.size(); i++) {
						if(artistas.get(i).getDni().equalsIgnoreCase(dni)) {
							controladorBD.dardeBajaArtista(artistas.get(i));
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
				artistas = controladorBD.listadoArtistasPorNumero(numero);
				for (int i = 0; i < artistas.size(); i++) {
					System.out.print("Nombre: ");
					System.out.print(artistas.get(i).getNombre());
					System.out.print(" DNI: ");
					System.out.println(artistas.get(i).getDni());
				}
				break;
			case 5:
				canciones = controladorBD.listadoCanciones();
				for (int i = 0; i < canciones.size(); i++) {
					System.out.print("Título: ");
					System.out.print(canciones.get(i).getTitulo());
					System.out.print(" Código: ");
					System.out.print(canciones.get(i).getCod());
					System.out.print(" Duración: ");
					System.out.println(canciones.get(i).getDuracion());
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
				canciones = controladorBD.cancionesMenorLongitud(duracion);
				for (int i = 0; i < canciones.size(); i++) {
					System.out.print("Título: ");
					System.out.print(canciones.get(i).getTitulo());
					System.out.print(" Código: ");
					System.out.print(canciones.get(i).getCod());
					System.out.print(" Duración: ");
					System.out.println(canciones.get(i).getDuracion());
				}
				System.out.println("--------------");
				break;
			case 8:
				System.out.print("Introduce el dni de un artista: ");
				String dni = sc.nextLine();
				if (controladorBD.existeArtista(dni)) {
					System.out.println("existe");
				} else {
					System.out.println("no");
				}
				
				break;
				default:
					break;
			}
		}while(opc!=0);
		
	}

	public static void mostrarMenu() {
		System.out.println("1. Listado de artistas");
		System.out.println("2. Listado de artistas que empicen por una letra");
		System.out.println("3. Alta o baja de artista");
		System.out.println("4. Lista de artistas que su dni acabe en un numero");
		System.out.println("5. Listado de canciones");
		System.out.println("6. Canción más larga");
		System.out.println("7. Canciones con una duración menor a la que elijas");
		System.out.println("8. Listado de canciones de un disco");
		System.out.print("Selecciona una opción: ");
	}

	public static void mostrarMenu1() {
		System.out.println("1. Listado de artistas");
		System.out.println("2. Listado de canciones");
		System.out.println("3. Listado de grupos");
		System.out.println("4. Listado de discos");
		System.out.println("5. Listado de compañias");
		System.out.println("6. Listado de clubes");
		System.out.print("Selecciona una opción: ");

	}
}
