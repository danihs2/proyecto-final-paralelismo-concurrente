package com.mycompany.proyectofinal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author daniel hachac salas
 */

public class Tarjeta {
    private int id;
    private double saldo;
    private final Lock lock;

    public Tarjeta(int id, double saldoInicial) {
        this.id = id;
        this.saldo = saldoInicial;
        this.lock = new ReentrantLock();
    }

    // Operación para cargar saldo
    public void cargarSaldo(double monto) {
        lock.lock();
        try {
            if (monto > 0) {
                saldo += monto;
                System.out.println("Se han cargado $" + monto + " a la tarjeta " + id + ". Saldo actual: $" + saldo);
            } else {
                System.out.println("Monto inválido para cargar en la tarjeta " + id);
            }
        } finally {
            lock.unlock();
        }
    }
    
    public void cargarSaldo(String montoText){
        lock.lock();
        double monto = 0;
        try{
            monto = Double.parseDouble(montoText);
        }catch(Exception e){
            System.out.println("No has pasado un numero");
        }
        try {
            if (monto > 0) {
                saldo += monto;
                System.out.println("Se han cargado $" + monto + " a la tarjeta " + id + ". Saldo actual: $" + saldo);
            } else {
                System.out.println("Monto inválido para cargar en la tarjeta " + id);
            }
        } finally {
            lock.unlock();
        }
    }

    // Operación para realizar un pago
    public void realizarPago(double monto) {
        lock.lock();
        try {
            if (monto > 0 && saldo >= monto) {
                saldo -= monto;
                System.out.println("Se ha realizado un pago de $" + monto + " desde la tarjeta " + id + ". Saldo actual: $" + saldo);
            } else {
                System.out.println("Fondos insuficientes o monto inválido para la tarjeta " + id);
            }
        } finally {
            lock.unlock();
        }
    }

    // Operación para consultar saldo
    public double consultarSaldo() {
        lock.lock();
        try {
            return saldo;
        } finally {
            lock.unlock();
        }
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}