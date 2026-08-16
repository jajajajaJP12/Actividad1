//DataTypeExamples mostrará el uso de diferentes tipos de datos
public class DataTypeExamples {

    public void mostrarEjemplos() {

        System.out.println("\n================================");
        System.out.println("     EJEMPLOS DE TIPOS DE DATOS");
        System.out.println("================================");

        String texto = "Hola Mundo";
        Integer numeroEntero = 25;
        Double numeroDecimal = 19.5;
        Boolean valorBooleano = true;

        System.out.println("String: " + texto);
        System.out.println("Integer: " + numeroEntero);
        System.out.println("Double: " + numeroDecimal);
        System.out.println("Boolean: " + valorBooleano);

        LinkedList listaDatos = new LinkedList(LinkedList.Tipo.SIMPLE);

        listaDatos.insertarFinal(texto);
        listaDatos.insertarFinal(numeroEntero);
        listaDatos.insertarFinal(numeroDecimal);
        listaDatos.insertarFinal(valorBooleano);

        System.out.println("\nDatos almacenados dentro de una lista:");
        listaDatos.mostrar();
    }
}