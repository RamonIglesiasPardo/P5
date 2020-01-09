package ong.entreculturas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenusConsola {

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
    public void mostrarMenuPrincipal(ONG ong) {

        clearScreen();
        System.out.println( "-----------------  ENTRECULTURAS  ---------------" );
        System.out.println( "  ONG jesuíta para la educación y el desarrollo");
        System.out.println(  "-------------------------------------------------");
        System.out.println( "\n1 - Dar de alta un empleado" );
        System.out.println(  "2 - Dar de baja un empleado" );
        System.out.println(  "3 - Mostrar datos del sistema" );
        System.out.println(  "4 - Salir de la aplicación" );
        System.out.println(  "\nSeleccione una opción: ");
        seleccionarOpcionDeMenu(ong);

    } // fin del método mostrarMenu

    /**
     * Método para seleccionar una opción del menú principal.
     * Llama a los métodos adecuados en función de la opción escogida.
     *
     */
    public void seleccionarOpcionDeMenu(ONG ong) {

        Scanner entrada = new Scanner( System.in );
        boolean salir = false;

        while (!salir) {

            try {

                int opcion = entrada.nextInt();

                switch (opcion) {

                    case 1:
                        clearScreen();
                        seleccionarTipoEmpleado(ong);
                        salir = true;
                        break;
                    case 2:
                        clearScreen();
                        System.out.println("Lo sentimos. Función no implementada.");
                        pulseEnterParaContinuar();
                        clearScreen();
                        mostrarMenuPrincipal(ong);
                        salir = true;
                        break;
                    case 3:
                        clearScreen();
                        seleccionarTipoListado(ong);
                        salir = true;
                        break;
                    case 4:
                        System.out.println("\nSaliendo del programa. Gracias por usar nuestra aplicación.");
                        salir = true;
                        break;
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
    public void seleccionarTipoEmpleado(ONG ong) {

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
                        mostrarMenuPrincipal(ong);
                        salir = true;
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
                        mostrarMenuPrincipal(ong);
                        salir = true;
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
     * Método para seleccionar el tipo de listado a mostrar.
     * Según el tipo de listado, crea un objeto apropiado y llama
     * al método correspondiente.
     *
     */
    public void seleccionarTipoListado(ONG ong) {

        Scanner entrada = new Scanner( System.in );
        boolean salir = false;
        System.out.println( "Seleccione los tipos de datos a consultar:" );
        System.out.println( "1 - Detalles ONG" );
        System.out.println( "2 - Listado de personal" );
        System.out.println( "3 - Listado de proyectos" );
        System.out.println( "4 - Volver al menú principal" );
        System.out.print(  "\nSu elección: ");

        while (!salir) {

            try {

                int opcion = entrada.nextInt();

                switch (opcion) {

                    case 1:
                        clearScreen();
                        System.out.printf("%s", ong.toString());
                        pulseEnterParaContinuar();
                        seleccionarTipoListado(ong);
                        salir = true;
                        break;
                    case 2:
                        clearScreen();
                        ong.lequipo.forEach(Personal -> System.out.printf(Personal.toString()+"\n"));
                        pulseEnterParaContinuar();
                        seleccionarTipoListado(ong);
                        salir = true;
                        break;
                    case 3:
                        clearScreen();
                        ong.lproyectos.forEach(Proyecto -> System.out.printf(Proyecto.toString()+"\n"));
                        pulseEnterParaContinuar();
                        seleccionarTipoListado(ong);
                        salir = true;
                        break;
                    case 4:
                        clearScreen();
                        mostrarMenuPrincipal(ong);
                        salir = true;
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
    public void pulseEnterParaContinuar() {

        String tecla;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Presione Enter para continuar...");

        try {

            tecla = teclado.nextLine();

        }

        catch(Exception e)

        {}

    } // fin del método pulseEnterParaContinuar

}
