//Node representa los nodos
public class Node {
    public Object dato;
    public Node siguiente;
    public Node anterior;

    public Node(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}