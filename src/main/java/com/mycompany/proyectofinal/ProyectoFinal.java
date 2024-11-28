package com.mycompany.proyectofinal;

/**
 *
 * @author daniel hachac salas
 */
public class ProyectoFinal {

    public static void main(String[] args) {
        // Crear instancia del sistema
        SistemaTarjetas sistema = new SistemaTarjetas();

        // Configurar número de tarjetas y usuarios
        int cantidadTarjetas = 3; 
        int cantidadUsuarios = 5;

        // Inicializar y ejecutar simulación
        sistema.inicializarTarjetas(cantidadTarjetas);
        sistema.inicializarUsuarios(cantidadUsuarios);
        sistema.iniciarSimulacion();

        System.out.println("Prueba completa.");
    }
}