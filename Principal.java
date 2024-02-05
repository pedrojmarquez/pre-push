import cuenta.Cuenta;
import java.util.Scanner;

/**
 * Clase principal que contiene el método main para interactuar con las cuentas bancarias.
 */
public class Principal {

    /**
     * Método principal que ejecuta las operaciones bancarias.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        // Crear un array para almacenar cuentas bancarias
        Cuenta[] cuentasBanco = new Cuenta[10];
        Scanner src = new Scanner(System.in);
        int menu = 0, numcuenta = 0, contador = 0;
        float saldo = 0f, importe = 0f;
        boolean existe = false;

        // Menú de operaciones
        System.out.println("|  MENÚ  |");
        System.out.println("1. Abrir cuenta.");
        System.out.println("2. Abrir cuenta CON saldo.");
        System.out.println("3. Consultar saldo.");
        System.out.println("4. Ingresar dinero.");
        System.out.println("5. Retirar dinero.");
        System.out.println("6. Consultar morosidad.");
        System.out.println("7. Salir.");

        // Loop principal del programa
        do {
            System.out.println("\n¿Qué operación deseas realizar?");
            menu = src.nextInt();
            src.nextLine();

            switch (menu) {
                case 1:
                    // Abrir cuenta
                    existe = false;
                    System.out.print("Introduce un numero de cuenta (tres cifras): ");
                    numcuenta = src.nextInt();
                    src.nextLine();
                    for (int i = 0; i < contador && !existe; i++) {
                        if (numcuenta == cuentasBanco[i].getIdentificador()) {
                            System.out.printf("Lo siento pero esa cuenta ya existe.");
                            existe = true;
                        }
                    }
                    if (!existe) {
                        cuentasBanco[contador] = new Cuenta(numcuenta);
                        contador++;
                    }
                    break;

                case 2:
                    // Abrir cuenta con saldo inicial
                    existe = false;
                    System.out.print("Introduce un numero de cuenta (tres cifras): ");
                    numcuenta = src.nextInt();
                    for (int i = 0; i < contador && !existe; i++) {
                        if (numcuenta == cuentasBanco[i].getIdentificador()) {
                            System.out.printf("Lo siento pero esa cuenta ya existe.");
                            existe = true;
                        }
                    }
                    if (!existe) {
                        System.out.print("Con cuanto dinero quieres empezar la cuenta? ");
                        saldo = src.nextFloat();
                        cuentasBanco[contador] = new Cuenta(numcuenta, saldo);
                        contador++;
                    }
                    break;

                case 3:
                    // Consultar saldo
                    existe = false;
                    System.out.println("Introduzca el numero de cuenta que quieres consultar: ");
                    numcuenta = src.nextInt();
                    for (int i = 0; i < contador && !existe; i++) {
                        if (numcuenta == cuentasBanco[i].getIdentificador()) {
                            System.out.printf("El saldo de la cuenta %d es %.2f€", cuentasBanco[i].getIdentificador(), cuentasBanco[i].getSaldo());
                            existe = true;
                        }
                    }
                    if (!existe) {
                        System.out.println("Lo siento pero ese numero de cuenta no existe.");
                    }
                    break;

                case 4:
                    // Ingresar dinero
                    existe = false;
                    System.out.print("Introduce el numero de cuenta en el que quieres ingresar el dinero:");
                    numcuenta = src.nextInt();
                    for (int i = 0; i < contador && !existe; i++) {
                        if (numcuenta == cuentasBanco[i].getIdentificador()) {
                            System.out.printf("Introduce el importe que quires ingresar:");
                            importe = src.nextFloat();
                            System.out.printf("El nuevo saldo de la cuenta es: %.2f€", cuentasBanco[i].ingresar(importe));
                            existe = true;
                        }
                    }
                    if (!existe) {
                        System.out.print("Lo siento pero ese numero de cuenta no existe.");
                    }
                    break;

                case 5:
                    // Retirar dinero
                    existe = false;
                    System.out.print("Introduce el numero de cuenta en el que quieres retirar el dinero:");
                    numcuenta = src.nextInt();
                    for (int i = 0; i < contador && !existe; i++) {
                        if (numcuenta == cuentasBanco[i].getIdentificador()) {
                            System.out.printf("Introduce el importe que quires retirar:");
                            importe = src.nextFloat();
                            cuentasBanco[i].retirar(importe);
                            existe = true;
                        }
                    }
                    if (!existe) {
                        System.out.print("Lo siento pero ese numero de cuenta no existe.");
                    }
                    break;

                case 6:
                    // Consultar morosidad
                    existe = false;
                    System.out.print("Introduce el numero de cuenta en el que quieres comprobar la morosidad:");
                    numcuenta = src.nextInt();
                    for (int i = 0; i < contador && !existe; i++) {
                        if (numcuenta == cuentasBanco[i].getIdentificador()) {
                            System.out.println("| MOROSIDAD |:" + cuentasBanco[i].esMorosa());
                            existe = true;
                        }
                    }
                    if (!existe) {
                        System.out.print("Lo siento pero ese numero de cuenta no existe.");
                    }
                    break;
            }
        } while (menu != 7);

    }
}

