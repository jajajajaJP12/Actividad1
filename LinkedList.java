//LinkedList contiene las operaciones de las listas
/* 
Clase LinkedList (Lista Simplemente Enlazada)
Es la estructura estándar donde cada nodo apunta únicamente al siguiente.
*/
public class LinkedList {

    public enum Tipo {
        SIMPLE,
        DOBLE,
        CIRCULAR
    }

    protected Node cabeza;
    protected Node cola;
    protected int tamano;
    protected Tipo tipo;

    public LinkedList(Tipo tipo) {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
        this.tipo = tipo;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void insertarInicio(Object dato) {
        Node nuevoNodo = new Node(dato); // Declara nuevo objeto tipo Node
        if (estaVacia()) { //Verifica si la lista está vacía
            cabeza = nuevoNodo; // Si está vacía, el nuevo nodo se vuelve la cabeza de la lista
            cola = nuevoNodo; // Y como está vacia, el nuevo nodo, aparte de ser la cabeza, tmb es la cola
            if (tipo == Tipo.CIRCULAR) { //Si es una lista circular, la referencia "Siguiente" de la cola apunta a la cabeza
                cola.siguiente = cabeza;
            }
        } else {
            nuevoNodo.siguiente = cabeza; //En caso de que no esté vacía la lista, la cabeza de la lista se convierte en la referencia "Siguiente" del nuevo nodo
            
            if (tipo == Tipo.DOBLE) { //Si es una lista doble, la referencia "Anterior" de la cabeza actual se convierte en el nuevo nodo
                cabeza.anterior = nuevoNodo;
            }
            cabeza = nuevoNodo; //El nuevo nodo se convierte en la nueva cabeza de la lista

            if (tipo == Tipo.CIRCULAR) { //Si es una lista circular, la referencia "Siguiente" de la cola apunta a la cabeza
                cola.siguiente = cabeza;
            }
        }
        tamano++; //Se incrementa 1 al tamaño de la lista
    }

    public void insertarFinal(Object dato) {
        Node nuevoNodo = new Node(dato); // Declarar nuevo Node 

        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            if (tipo == Tipo.CIRCULAR) {
                cola.siguiente = cabeza; // En una lista circular, la cola apunta a la cabeza
            }
        } else {
            if (tipo == Tipo.CIRCULAR) {
            cola.siguiente = nuevoNodo; //Si la lista no está vacía, la referencia "Siguiente" de la cola actual se convierte en el nuevo nodo
            cola = nuevoNodo; //El nuevo nodo se convierte en la nueva cola de la lista
            cola.siguiente = cabeza; // En una lista circular, la nueva cola apunta a la cabeza
            } else {
                cola.siguiente = nuevoNodo; //Si la lista no está vacía, la referencia "Siguiente" de la cola actual se convierte en el nuevo nod0
                if (tipo == Tipo.DOBLE) { //Si es una lista doble, la referencia "Anterior" del nuevo nodo se convierte en la cola actual
                    nuevoNodo.anterior = cola;
                }
                
                cola = nuevoNodo; //El nuevo nodo se convierte en la nueva cola de la lista
            }
        }
        tamano++; //Se incrementa 1 al tamaño de la lista
    }

    public boolean buscar(Object datoBuscado) {
        if (estaVacia()) {
            return false; //Si la lista está vacía, retorna false
        }
        Node actualNodo = cabeza; //Se declara un objeto tipo Node llamado actual, que apunta a la cabeza de la lista
        if (tipo == Tipo.CIRCULAR) { //Si la lista es circular, se recorre hasta llegar a la cabeza nuevamente
            do {
                if (actualNodo.dato.equals(datoBuscado)) {
                    return true; //Si se encuentra el dato, retorna true
                }
                actualNodo = actualNodo.siguiente;
            } while (actualNodo != cabeza);
        } else { //Si la lista no es circular, se recorre hasta llegar al final (nodo nulo)
            while (actualNodo != null) {
                if (actualNodo.dato.equals(datoBuscado)) {
                    return true; //Si se encuentra el dato, retorna true
                }
                actualNodo = actualNodo.siguiente;
            }
        }
        return false; //Si no se encuentra el dato, retorna false
    }

    public void eliminarInicio() {
        if (estaVacia()) return; //Verifica si la lista está vacía, y en caso de estarlo se interrumple el proceso
        if (cabeza == cola) { //Verifica si la cabeza y la cola de la lista son iguales, es decir, si solo 1 nodo
            cabeza = null; // En caso de ser solo un nodo, se elimina la cabeza
            cola = null; // Se elimina la cola y la lista queda vacía
        } else { //En caso de que no haya solo 1 elemento
            cabeza = cabeza.siguiente; // la cabeza se elimina asignando la referencia siguiente como cabeza de la lista
        }
        tamano--; //Se decrementa en 1 el tamaño de la lista 
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("[] (lista vacía)");
            return;
        }
        System.out.print("[ ");
        Node actualNodo = cabeza; //Se declara un objeto tipo Node llamado actual, que apunta a la cabeza de la lista
        if (tipo == Tipo.CIRCULAR) { //Si la lista es circular, se recorre hasta llegar a la cabeza nuevamente
            do {
                System.out.print(actualNodo.dato);
                actualNodo = actualNodo.siguiente;
                if (actualNodo != cabeza) {
                    System.out.print(" -> ");
                }
            } while (actualNodo != cabeza);

            System.out.println(" -> (regresa al inicio) ]");
        
        } else { //Si la lista no es circular, se recorre hasta llegar al final (nodo nulo)
            while (actualNodo != null) {
                System.out.print(actualNodo.dato);

                if (actualNodo.siguiente != null) {
                    System.out.print(" -> ");
                }

                actualNodo = actualNodo.siguiente;
            }
            
            System.out.println(" ]");
        }
    }

    public void eliminar(Object datoEliminar) {

        if (estaVacia()) {
            System.out.println("La lista esta vacia.");
            return;
        }

        //LISTA CIRCULAR
        if (tipo == Tipo.CIRCULAR) {
            Node actualNodo = cabeza;
            Node anteriorNodo = cola; // Inicializamos el nodo anterior como la cola para mantener la circularidad

            do {
                if (actualNodo.dato.equals(datoEliminar)) {

                    //Si solo existe un nodo
                    if (cabeza == cola) {
                        cabeza = null;
                        cola = null;
                    }

                    //si eliminamos la cabeza
                    else if (actualNodo == cabeza) {
                        cabeza = cabeza.siguiente;
                        cola.siguiente = cabeza; // Mantener la circularidad
                    }

                    //si eliminamos cualquier otro nodo
                    else {
                        anteriorNodo.siguiente = actualNodo.siguiente;

                        //si eliminamos la cola
                        if (actualNodo == cola) {
                            cola = anteriorNodo;
                        }
                        cola.siguiente = cabeza; // Mantener la circularidad
                    }
                    
                    tamano--;
                    System.out.println("Elemento eliminado.");
                    return;
                }
                anteriorNodo = actualNodo;
                actualNodo = actualNodo.siguiente;
            
            } while (actualNodo != cabeza);

            System.out.println("Elemento no encontrado.");
            return;
        }
        
        //LISTA SIMPLE Y LISTA DOBLE
        // Si el dato esta en la cabeza
        if (cabeza.dato.equals(datoEliminar)) {
            cabeza = cabeza.siguiente;

            if (cabeza == null) { // Si la lista queda vacía, actualizamos la cola también
                cola = null;
            } else if (tipo == Tipo.DOBLE) { // Si es una lista doble, actualizamos la referencia "Anterior" de la nueva cabeza
                cabeza.anterior = null;
            }
            tamano--;

            System.out.println("Elemento eliminado.");
            return;
        }

        Node actualNodo = cabeza;

        while (actualNodo.siguiente != null) {
            if (actualNodo.siguiente.dato.equals(datoEliminar)) {

                Node nodoEliminar = actualNodo.siguiente; // Nodo a eliminar
                actualNodo.siguiente = nodoEliminar.siguiente; // Saltamos el nodo a eliminar

                if (nodoEliminar == cola) { // Si el nodo a eliminar es la cola, actualizamos la referencia de la cola
                    cola = actualNodo;
                }
                if (tipo == Tipo.DOBLE && actualNodo.siguiente != null) { // Si es una lista doble y hay un nodo siguiente, actualizamos la referencia "Anterior"
                    actualNodo.siguiente.anterior = actualNodo;
                }
                
                tamano--;

                System.out.println("Elemento eliminado.");
                return;
            }

            actualNodo = actualNodo.siguiente;
        }

        System.out.println("Elemento no encontrado.");
    }

    public void mostrarReversa() {
        if (estaVacia()) {
            System.out.println("[] (lista vacía)");
            return;
        }

        if (tipo != Tipo.DOBLE) {
            System.out.println("esta opcion solo aplica para listas dobles.");
            return;
        }

        Node actualNodo = cola; // Comenzamos desde la cola
        System.out.print("[ ");
        while (actualNodo != null) {
            System.out.print(actualNodo.dato);

            if (actualNodo.anterior != null) {
                System.out.print(" <- ");
            }
            actualNodo = actualNodo.anterior; // Avanzamos al nodo anterior
        }

        System.out.println(" ]"); 
    }
}