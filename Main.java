//Main se encargará de interactuar con el usuario mediante los menús
/* 
Clase Main
Punto de entrada interactivo que ofrece un menú en consola 
para que el usuario elija qué tipo de lista crear y cómo interactuar con ella.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataTypeExamples ejemplos = new DataTypeExamples();

        int opcionPrincipal;
        do{
            System.out.println("\n=============================");
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("=============================");
            System.out.println("1. Lista Simple");
            System.out.println("2. Lista Doble");
            System.out.println("3. Lista Circular");
            System.out.println("4. Ejemplo de Tipos de Datos");
            System.out.println("5. Gestion de Contactos");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            opcionPrincipal = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcionPrincipal) {
                case 1:
                    probarListaSimple(scanner, ejemplos);
                    break;
                case 2:
                    probarListaDoble(scanner);
                    break;
                case 3:
                    probarListaCircular(scanner);
                    break;
                case 4:
                    ejemplos.mostrarEjemplos();
                    break;
                case 5:
                    probarContactos(scanner);
                    break;
                case 6:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcionPrincipal != 6);

        scanner.close();
    }
    // --- MENÚ PARA LISTA SIMPLE ---
    private static void probarListaSimple(Scanner scanner, DataTypeExamples ejemplos) {
        LinkedList lista = new LinkedList(LinkedList.Tipo.SIMPLE);
        lista.insertarFinal("Nodo 1");
        lista.insertarFinal("Nodo 2");
        lista.insertarFinal("Nodo 3");
        lista.insertarFinal("Nodo 4");
        lista.insertarFinal("Nodo 5");
        lista.insertarFinal("Nodo 6");
        lista.insertarFinal("Nodo 7");
        lista.insertarFinal("Nodo 8");
        lista.insertarFinal("Nodo 9");
        lista.insertarFinal("Nodo 10");
        int opcion;
        do {
            System.out.println("\n--- MENÚ: LISTA SIMPLE ---");
            System.out.println("1. Insertar al inicio (Texto)");
            System.out.println("2. Insertar al final (Texto)");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Buscar elemento");
            System.out.println("5. Mostrar lista");
            System.out.println("6. Regresar/Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Texto a iniciar: ");
                    lista.insertarInicio(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Texto a la cola: ");
                    lista.insertarFinal(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Ingresa el elemento a eliminar: ");
                    String datoEliminar = scanner.nextLine();
                    lista.eliminar(datoEliminar);
                    break;
                case 4:
                    System.out.print("Ingresa el elemento a buscar: ");
                    String datoBuscado = scanner.nextLine();

                    if (lista.buscar(datoBuscado)) {
                        System.out.println("Elemento encontrado.");
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;
                case 5:
                    lista.mostrar();
                    break;
            }
        } while (opcion != 6);
    }

    // --- MENÚ PARA LISTA DOBLE ---
    private static void probarListaDoble(Scanner scanner) {

        LinkedList lista = new LinkedList(LinkedList.Tipo.DOBLE);
        lista.insertarFinal("Nodo 1");
        lista.insertarFinal("Nodo 2");
        lista.insertarFinal("Nodo 3");
        lista.insertarFinal("Nodo 4");
        lista.insertarFinal("Nodo 5");
        lista.insertarFinal("Nodo 6");
        lista.insertarFinal("Nodo 7");
        lista.insertarFinal("Nodo 8");
        lista.insertarFinal("Nodo 9");
        lista.insertarFinal("Nodo 10");
        int opcion;
        do {
            System.out.println("\n--- MENÚ: LISTA DOBLE ---");
            System.out.println("1. Insertar al inicio (Texto)");
            System.out.println("2. Insertar al final (Texto)");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Buscar elemento");
            System.out.println("5. Mostrar lista");
            System.out.println("6. Mostrar lista en reversa");
            System.out.println("7. Regresar/Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Texto a insertar al inicio: ");
                    lista.insertarInicio(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Texto a insertar al final: ");
                    lista.insertarFinal(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Ingresa el elemento a eliminar: ");
                    String datoEliminar = scanner.nextLine();
                    lista.eliminar(datoEliminar);
                    break;
                case 4:
                    System.out.print("Ingresa el elemento a buscar: ");
                    String datoBuscado = scanner.nextLine();

                    if (lista.buscar(datoBuscado)) {
                        System.out.println("Elemento encontrado.");
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;
                case 5:
                    lista.mostrar();
                    break;
                case 6:
                    lista.mostrarReversa();
                    break;
            }

        } while (opcion != 7);
    }

    // --- MENÚ PARA LISTA CIRCULAR ---
    private static void probarListaCircular(Scanner scanner) {
        LinkedList lista = new LinkedList(LinkedList.Tipo.CIRCULAR);
        lista.insertarFinal("Nodo 1");
        lista.insertarFinal("Nodo 2");
        lista.insertarFinal("Nodo 3");
        lista.insertarFinal("Nodo 4");
        lista.insertarFinal("Nodo 5");
        lista.insertarFinal("Nodo 6");
        lista.insertarFinal("Nodo 7");
        lista.insertarFinal("Nodo 8");
        lista.insertarFinal("Nodo 9");
        lista.insertarFinal("Nodo 10");
        int opcion;
        do {
            System.out.println("\n--- MENÚ: LISTA CIRCULAR ---");
            System.out.println("1. Insertar al inicio (Texto)");
            System.out.println("2. Insertar al final (Texto)");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Buscar elemento");
            System.out.println("5. Mostrar lista");
            System.out.println("6. Regresar/Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Texto a insertar al inicio: ");
                    lista.insertarInicio(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Texto a insertar al final: ");
                    lista.insertarFinal(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Ingresa el elemento a eliminar: ");
                    String datoEliminar = scanner.nextLine();
                    lista.eliminar(datoEliminar);
                    break;
                case 4:
                    System.out.print("Ingresa el elemento a buscar: ");
                    String datoBuscado = scanner.nextLine();

                    if (lista.buscar(datoBuscado)) {
                        System.out.println("Elemento encontrado.");
                    } else {
                        System.out.println("Elemento no encontrado.");
                    }
                    break;
                case 5:
                    lista.mostrar();
                    break;
            }

        } while (opcion != 6);
    }

    //Metodo para mostrar el menú de gestión de contactos
    private static void probarContactos(Scanner scanner) {
        LinkedList lista = new LinkedList(LinkedList.Tipo.SIMPLE);

        lista.insertarFinal(new Contacto(
        "Jorge Pardo",
        "Culiacán",
        "6671234567"));

        lista.insertarFinal(new Contacto(
        "Ana López",
        "Mazatlán",
        "6699876543"));

        lista.insertarFinal(new Contacto(
        "Carlos Ruiz",
        "Los Mochis",
        "6685554444"));

        int opcion;
        do {
            System.out.println("\n--- MENÚ: GESTIÓN DE CONTACTOS ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Mostrar contactos");
            System.out.println("5. Regresar");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    Contacto nuevoContacto = new Contacto(nombre, direccion, telefono);
                    lista.insertarFinal(nuevoContacto);
                    System.out.println("Contacto agregado correctamente.");
                    break;
                case 2:
                    System.out.print("Ingresa el nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Node actual = lista.cabeza;
                    boolean encontrado = false;

                    while (actual != null) {
                        Contacto contacto = (Contacto) actual.dato;
                        if (contacto.getNombre().equalsIgnoreCase(nombreBuscar)) {
                            System.out.println("Contacto encontrado: ");
                            System.out.println(contacto);
                            encontrado = true;
                            break;
                        }
                        
                        actual = actual.siguiente;
                    }
                    if (!encontrado) {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingresa el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    
                    Node nodoActual = lista.cabeza;
                    Contacto contactoEliminar = null;

                    while (nodoActual != null) {
                        Contacto contacto = (Contacto) nodoActual.dato;
                        if (contacto.getNombre().equalsIgnoreCase(nombreEliminar)) {
                            contactoEliminar = contacto;
                            break;
                        }
                        nodoActual = nodoActual.siguiente;
                        
                    }

                    if (contactoEliminar != null) {
                        lista.eliminar(contactoEliminar);
                    }else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Lista de contactos:");
                    lista.mostrar();
                    break;
                
                case 5:
                    System.out.println("Regresando al menú principal.");
                    break;
                
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }while (opcion != 5);
    }
}