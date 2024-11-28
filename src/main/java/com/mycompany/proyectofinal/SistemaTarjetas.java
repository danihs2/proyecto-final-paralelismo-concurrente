package com.mycompany.proyectofinal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel hachac salas
 */
public class SistemaTarjetas {

    private List<Tarjeta> tarjetas;
    private List<Thread> usuarios;

    public SistemaTarjetas() {
        this.tarjetas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Crear tarjetas con saldos iniciales
    public void inicializarTarjetas(int cantidad) {
        for (int i = 1; i <= cantidad; i++) {
            tarjetas.add(new Tarjeta(i, 100.0)); // Cada tarjeta comienza con $100
        }
    }

    // Asignar usuarios a las tarjetas y crear hilos
    public void inicializarUsuarios(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Tarjeta tarjetaAsignada = tarjetas.get(i % tarjetas.size()); // Asignar tarjetas cíclicamente
            Usuario usuario = new Usuario("Usuario-" + (i + 1), tarjetaAsignada);
            usuarios.add(new Thread(usuario, "Hilo-" + (i + 1)));
        }
    }

    // Iniciar los hilos de usuarios
    public void iniciarSimulacion() {
        System.out.println("Iniciando simulación...");
        for (Thread usuario : usuarios) {
            usuario.start();
        }

        // Esperar a que terminen todos los hilos
        for (Thread usuario : usuarios) {
            try {
                usuario.join();
            } catch (InterruptedException e) {
                System.out.println(usuario.getName() + " fue interrumpido.");
            }
        }
        System.out.println("Simulación terminada.");
    }

}