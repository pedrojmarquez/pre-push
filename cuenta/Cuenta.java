package cuenta;

import java.util.Scanner;

/**
 * Clase que representa una cuenta bancaria.
 */
public class Cuenta {
    // PROPIEDADES:

    private int identificador;
    private float saldo;

    // MÉTODOS:

    /**
     * Constructor para crear una cuenta sin saldo inicial.
     * @param identificador Número de identificación de la cuenta.
     */
    public Cuenta(int identificador) {
        this.identificador = identificador;
        this.saldo = 0f;
    }

    /**
     * Constructor para crear una cuenta con saldo inicial.
     * @param identificador Número de identificación de la cuenta.
     * @param saldo Saldo inicial de la cuenta.
     */
    public Cuenta(int identificador, float saldo) {
        this.identificador = identificador;
        this.saldo = saldo;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     * @return Saldo actual de la cuenta.
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Obtiene el identificador de la cuenta.
     * @return Número de identificación de la cuenta.
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Realiza un ingreso en la cuenta.
     * @param importe Monto a ingresar en la cuenta.
     * @return Nuevo saldo de la cuenta después del ingreso.
     */
    public float ingresar(float importe) {
        this.saldo = this.saldo + importe;
        return this.saldo;
    }

    /**
     * Realiza un retiro de la cuenta.
     * @param importe Monto a retirar de la cuenta.
     * @return Nuevo saldo de la cuenta después del retiro.
     */
    public float retirar(float importe) {
        if ((this.saldo - importe) < 0) {
            System.out.println("La cuenta se quedará en negativo!!!, ¿Estás seguro que quieres hacer esta operación? (escribe si o no)");
            Scanner src = new Scanner(System.in);
            String pregunta = src.nextLine();
            if (pregunta.toLowerCase().equals("si")) {
                this.saldo = this.saldo - importe;
                System.out.printf("El importe se ha realizado correctamente, tu saldo actual de la cuenta %d es de %.2f.", this.identificador, this.saldo);
            } else if (pregunta.toLowerCase().equals("no")) {
                System.out.println("El importe no se ha realizado.");
            }
        } else {
            this.saldo = this.saldo - importe;
            System.out.printf("El importe se ha realizado correctamente, el saldo actual de la cuenta %d es de %.2f.", this.identificador, this.saldo);
        }
        return this.saldo;
    }

    /**
     * Verifica si la cuenta está en mora (saldo negativo).
     * @return true si la cuenta está en mora, false en caso contrario.
     */
    public boolean esMorosa() {
        boolean morosa = false;
        if (this.saldo < 0) {
            System.out.printf("El cliente de la cuenta %d es un MOROSO.", this.identificador);
            morosa = true;
        } else {
            System.out.printf("El cliente de la cuenta %d NO es un MOROSO.", this.identificador);
        }
        return morosa;
    }
}

