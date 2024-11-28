package com.mycompany.proyectofinal;
import java.util.Random;

/**
 *
 * @author ddaniel hachac salas
 */
public class Usuario implements Runnable {
    private String nombre;
    private Tarjeta tarjeta;

    public Usuario(String nombre, Tarjeta tarjeta) {
        this.nombre = nombre;
        this.tarjeta = tarjeta;
    }

    @Override
    public void run() {
        Random random = new Random();

        // Simular operaciones aleatorias
        for (int i = 0; i < 5; i++) { // Cada usuario realiza 5 operaciones
            int operacion = random.nextInt(3); // 0: cargar, 1: pagar, 2: consultar
            double monto = random.nextInt(100) + 1; // Generar un monto entre 1 y 100

            switch (operacion) {
                case 0: // Cargar saldo
                    System.out.println(nombre + " intenta cargar $" + monto);
                    tarjeta.cargarSaldo(monto);
                    break;
                case 1: // Realizar pago
                    System.out.println(nombre + " intenta pagar $" + monto);
                    tarjeta.realizarPago(monto);
                    break;
                case 2: // Consultar saldo
                    System.out.println(nombre + " consulta el saldo. Saldo actual: $" + tarjeta.consultarSaldo());
                    break;
            }

            try {
                Thread.sleep(random.nextInt(500)); // Pausa aleatoria entre operaciones
            } catch (InterruptedException e) {
                System.out.println(nombre + " fue interrumpido.");
            }
        }
    }

    // Getters y setters (opcional)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}