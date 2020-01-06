/*package ong.entreculturas;



import java.util.InputMismatchException;
import java.util.Scanner;
import ong.dao.DaoXmlOng;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    //Declaramos e instanciamos ONG, ya que contendrá toda las otras instancias de la aplicación.
    static ONG ong = new ONG();

    /**
     * Método para borrar la pantalla de la consola (multiplataforma)
     *
     */
    public static void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    } // fin del método clearScreen

    /**
     * Método que muestra el menú principal de la aplicación
     *
     */
    public static void mostrarMenu() {

        clearScreen();
        System.out.println( "-----------------  ENTRECULTURAS  ---------------" );
        System.out.println( "  ONG jesuíta para la educación y el desarrollo");
        System.out.println(  "-------------------------------------------------");
        System.out.println( "\n1 - Dar de alta un empleado" );
        System.out.println(  "2 - Dar de baja un empleado" );
        System.out.println(  "3 - Mostrar datos del sistema" );
        System.out.println(  "4 - Salir de la aplicación" );
        System.out.println(  "\nSeleccione una opción: ");
        seleccionarOpcionDeMenu();

    } // fin del método mostrarMenu

    /**
     * Método para seleccionar una opción del menú principal.
     * Llama a los métodos adecuados en función de la opción escogida.
     *
     */
    public static void seleccionarOpcionDeMenu() {

        Scanner entrada = new Scanner( System.in );
        boolean salir = false;

        while (!salir) {

            try {

                int opcion = entrada.nextInt();

                switch (opcion) {

                    case 1:
                        clearScreen();
                        seleccionarTipoEmpleado();
                        break;
                    case 2:
                        clearScreen();
                        System.out.println("Lo sentimos. Función no implementada.");
                        pulseEnterParaContinuar();
                        clearScreen();
                        mostrarMenu();
                        break;
                    case 3:
                        clearScreen();
                        seleccionarTipoListado();
                        break;
                    case 4:
                        System.out.println("\nSaliendo del programa. Gracias por usar nuestra aplicación.");
                        System.exit(0);
                    default:
                        System.out.print("Selección no válida. Pruebe de nuevo: ");
                } // fin de switch
            } catch ( InputMismatchException e ) {

                System.out.print( "Solo se aceptan las opciones indicadas. Pruebe de nuevo:  " );
                entrada.next();

            } // fin de try...catch

        } // fin de while

    } // fin del método seleccionarOpcionDeMenu

    /**
     * Método para seleccionar el tipo de empleado a dar de alta.
     * Según el tipo de empleado seleccionado, crea un objeto apropiado y llama
     * al método correspondiente.
     *
     */
    public static void seleccionarTipoEmpleado() {

        Scanner entrada = new Scanner( System.in );
        boolean salir = false;
        System.out.println( "Seleccione el tipo de empleado a dar de alta:" );
        System.out.println( "1 - Personal voluntario" );
        System.out.println( "2 - Personal voluntario internacional" );
        System.out.print(  "\nSu elección: ");

        while (!salir) {

            try {

                int opcion = entrada.nextInt();

                switch (opcion) {

                    case 1:
                        clearScreen();
                        PerVoluntario perVol = new PerVoluntario();
                        perVol.introducirDatosPersona();
                        // Mostramos los datos del empleado
                        System.out.println("\n" + perVol.toString());
                        //Añadimos el nuevo empleado a la ONG
                        ong.addEquipo(perVol);
                        pulseEnterParaContinuar();
                        clearScreen();
                        mostrarMenu();
                        break;
                    case 2:
                        clearScreen();
                        PerVolInternacional perVolInt = new PerVolInternacional();
                        perVolInt.introducirDatosPersona();
                        // Mostramos los datos del empleado
                        System.out.println("\n" + perVolInt.toString());
                        //Añadimos el nuevo empleado a la ONG
                        ong.addEquipo(perVolInt);
                        pulseEnterParaContinuar();
                        clearScreen();
                        mostrarMenu();
                        break;
                    default:
                        System.out.print("Selección no válida. Pruebe de nuevo: ");
                        opcion = entrada.nextInt();

                } // fin de switch

            } catch ( InputMismatchException e ) {

                System.out.print( "Solo se aceptan las opciones indicadas. Pruebe de nuevo:  " );
                entrada.next();

            } // fin de try...catch

        } // fin de while

    } // fin del método seleccionarTipoEmpleado

    /**
     * Método para seleccionar el tipo de empleado a dar de alta.
     * Según el tipo de empleado seleccionado, crea un objeto apropiado y llama
     * al método correspondiente.
     *
     */
    public static void seleccionarTipoListado() {

        Scanner entrada = new Scanner( System.in );
        boolean salir = false;
        System.out.println( "Seleccione los tipos de datos a consultar:" );
        System.out.println( "1 - Detalles ONG" );
        System.out.println( "2 - Listado de personal" );
        System.out.println( "3 - Volver al menú principal" );
        System.out.print(  "\nSu elección: ");

        while (!salir) {

            try {

                int opcion = entrada.nextInt();

                switch (opcion) {

                    case 1:
                        clearScreen();
                        System.out.printf("%s", ong.toString());
                        pulseEnterParaContinuar();
                        seleccionarTipoListado();
                        break;
                    case 2:
                        clearScreen();
                        //System.out.printf("%s", ong.lequipo.toString());
                        ong.lequipo.forEach(Personal -> System.out.printf(Personal.toString()+"\n"));
                        pulseEnterParaContinuar();
                        seleccionarTipoListado();
                        break;
                    case 3:
                        clearScreen();
                        mostrarMenu();
                        break;
                    default:
                        System.out.print("Selección no válida. Pruebe de nuevo: ");
                        opcion = entrada.nextInt();

                } // fin de switch

            } catch ( InputMismatchException e ) {

                System.out.print( "Solo se aceptan las opciones indicadas. Pruebe de nuevo:  " );
                entrada.next();

            } // fin de try...catch

        } // fin de while

    } // fin del método seleccionarTipoEmpleado

    /**
     * Método para continuar tras pulsar la tecla Enter.
     *
     */
    public static void pulseEnterParaContinuar() {

        String tecla;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Presione Enter para continuar...");

        try {

            tecla = teclado.nextLine();

        }

        catch(Exception e)

        {}

    } // fin del método pulseEnterParaContinuar

    // Variables de clase (eliminadas: no son necesarias)

    public static void main(String[] args) {

        //Precargamos datos existentes desde el XML
        ong = new DaoXmlOng().getONG();

        // Abrimos el menú principal de la aplicació
        mostrarMenu();

        //TODO Guardamos estado actual en el XML.


//        ONG ong = new DaoXmlOng().getONG();
//        System.out.println("IMPRIMIENDO DESDE INSTANCIA ONG ----> CIF: " + ong.getCIF());
//        System.out.println("IMPRIMIENDO DESDE INSTANCIA ONG ----> Nombre: " + ong.getNombre());


        // Si os parece, de momento voy a comentar esta parte (da error al compilar, quizá porque ya hay un main
        // antes)

        //public static void main(String[] args) throws IOException {
        //Proyecto proyecto;
        //System.out.println("Introduce el Id de Proyecto: ");
        //Scanner reader = new Scanner(System.in);
        //int id = reader.nextInt();
        //System.out.println("Introduce el pais del Proyecto: ");
        //String pais = reader.next();
        //System.out.println("Introduce la localizacion del Proyecto: ");
        //String localizacion = reader.next();
        //proyecto = new Proyecto(id, pais, localizacion);
        //System.out.println(proyecto.getPais());
        //System.out.println(proyecto.getLocalizacion());

        //Test
        //public void testSetAndGetDescription(id, pais, localizacion){
        //Proyecto proyecto;
        //proyecto = new Proyecto();
        //String testPais = "Pais";
        //assertNull(proyecto.getPais());
        //proyecto.setPais(testPais);
        //assertEquals(testPais, proyecto.getPais());
        //}
        //}
    } // fin de main


} // fin de la clase Main



//TODO: Implementar la funcionalidad de añadir y eliminar empleados a la lista de empleados.
//TODO: Añadir opción de menú de listar empleados, y quizá alguna opción extra.
//TODO: Revisar método crearID en subclases de Personal (¿bien implementado?)
*/