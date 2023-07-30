/*
 * Proyecto desarrollado por: Roberto Ramírez 7690-22-12700
 * 
 * La aplicación permite obtener la velocidad promedio de varios vehiculos, registrando cada
 * uno de los tiempos por vuelta en una pista de carreras, utilizando la programación orientada
 * a objetos
 */

import java.util.*;

public class CarreraVehiculosPoo {
    public static void main(String[] args) {
    	Scanner entrada = new Scanner(System.in);
    	int opcion = 0;
    	int salir = 0;
    	//Menu principal
    	while(salir !=1) {
    		System.out.println("\n\tBIENVENIDO");
    		System.out.println("\n1.INICIAR");
    		System.out.println("\n2.FINALIZAR");
    		System.out.println("\nElige una opción");
    		opcion = entrada.nextInt();
    		entrada.nextLine();
    		switch(opcion) {
    			case 1:
			        System.out.print("Ingrese el ID de la pista: ");
			        String idp = entrada.nextLine();
			        System.out.print("Ingrese el nombre de la pista: ");
			        String nombre = entrada.nextLine();
			        System.out.print("Ingrese la longitud de la pista: ");
			        float longitud = entrada.nextFloat();
			        entrada.nextLine();
			        Pista pista = new Pista(idp, nombre, longitud);
			        System.out.print("Ingrese la cantidad de vehiculos: ");
			        int cantidad = Integer.parseInt(entrada.nextLine()); // Leer la cantidad con nextLine()
			        List<Vehiculo> vehiculos = new ArrayList<>();
			        for (int i = 1; i <= cantidad; i++) {
			            System.out.println("Ingrese el ID del vehiculo " + i);
			            String id = entrada.nextLine();
			            System.out.println("Ingrese la marca del vehiculo " + i);
			            String marca = entrada.nextLine();
			            Vehiculo vehiculo = new Vehiculo(id, marca);
			            System.out.println("Ingrese la cantidad de vueltas del vehiculo " + i);
			            int vueltas = Integer.parseInt(entrada.nextLine()); // Leer las vueltas con nextLine()
			            float tTotal = 0;
			            for (int j = 1; j <= vueltas; j++) {
			                System.out.println("Ingrese el tiempo de la vuelta " + j);
			                float tVuelta = Float.parseFloat(entrada.nextLine()); // Leer los tiempos con nextLine()
			                tTotal += tVuelta;
			            }
			            vehiculo.settTotal(tTotal); // Establecer el tiempo total para el vehículo
			            vehiculos.add(vehiculo);
			        }
			        // Calcular y mostrar los tiempos promedio de los vehículos
			        System.out.println("\nTiempos promedio de los vehículos:");
			        System.out.println(pista.toString());
			        //System.out.println("PISTA => ID: " + idp + ", NOMBRE: " + nombre + ", LONGITUD: " + longitud);
			        for (int i = 0; i < vehiculos.size(); i++) {
			            Vehiculo vehiculo = vehiculos.get(i);
			            float vPromedio = longitud / vehiculo.gettTotal();
			            System.out.println("Vehiculo " + (i + 1) + ": ID: " + vehiculo.getId() + ", Marca: " + vehiculo.getMarca() + ", Velocidad promedio: " + vPromedio);
			        }
			        break;
    			case 2:
    				salir = 1;
    				System.out.println("Vuelve Pronto...");
    				break;
    			default:
    				System.out.println("Opción no valida");
    		}
    	}
    }
}

