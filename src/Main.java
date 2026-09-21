/*

TITULO: Sistema de getion de personajes

AUTOR: Emilia Veloz

FECHA: 20/09/2026

ENUNCIADO: Una academia de videojuegos necesita un programa para registrar personajes. Todos comparten un
identificador, un nombre y un nivel, pero cada tipo realiza una acción diferente. El sistema debe guardar los
objetos en una sola colección, mostrarlos y buscar uno por su identificador.

*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<Personaje> personajes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=========== SISTEMA DE PERSONAJES ===========");
            System.out.println("1. Registrar personaje");
            System.out.println("2. Mostrar personajes");
            System.out.println("3. Buscar personaje por ID");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("====Registrar Personaje====");
                    System.out.print("Tipo: 1 = Guerrero | 2 = Mago: ");
                    int tipo;
                    try {
                        tipo = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Tipo inválido, debe ser número.");
                        break;
                    }

                    if (tipo != 1 && tipo != 2) {
                        System.out.println("Solo elija 1 o 2.");
                        break;
                    }

                    
                    System.out.print("ID (mayor a 0): ");
                    int id;
                    try {
                        id = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID debe ser un número.");
                        break;
                    }
                    if (id <= 0) {
                        System.out.println("El ID debe ser mayor a 0.");
                        break;
                    }

                    
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine().trim();
                    if (nombre.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                        break;
                    }

                    
                    System.out.print("Nivel (1-100): ");
                    int nivel;
                    try {
                        nivel = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Nivel debe ser un número.");
                        break;
                    }
                    if (nivel < 1 || nivel > 100) {
                        System.out.println("El nivel debe estar entre 1 y 100.");
                        break;
                    }

                    // Crear y registrar
                    if (tipo == 1) {
                        personajes.add(new Guerrero(id, nombre, nivel));
                    } else {
                        personajes.add(new Mago(id, nombre, nivel));
                    }
                    System.out.println("Personaje registrado con éxito.");
                    break;

                case 2:
                    System.out.println("=== Lista de Personajes ===");
                    if (personajes.isEmpty()) {
                        System.out.println("No hay personajes registrados.");
                        break;
                    }
                    for (Personaje p : personajes) {
                        p.mostrarInfo();
                        System.out.println(p.mostrarAccion());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese ID a buscar: ");
                    int idBuscar;
                    try {
                        idBuscar = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID debe ser un número.");
                        break;
                    }

                    boolean encontrado = false;
                    for (Personaje p : personajes) {
                        if (p.getId() == idBuscar) {
                            System.out.println("Personaje encontrado:");
                            p.mostrarInfo();
                            System.out.println(p.mostrarAccion());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Personaje no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Use números del 1 al 4.");
            }
        } while (opcion != 4);

        scanner.close();
    }
        
    
}
