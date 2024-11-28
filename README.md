# Gestión de Tarjetas Electrónicas

Este proyecto simula la gestión de tarjetas electrónicas mediante una aplicación en consola desarrollada en **Java**. Implementa conceptos de **programación paralela y concurrente** para manejar múltiples hilos que representan usuarios interactuando con sus tarjetas.

## Descripción

El programa permite:
- **Cargar saldo**: Los usuarios pueden añadir fondos a su tarjeta.
- **Realizar pagos**: Los usuarios pueden realizar transacciones, descontando saldo.
- **Consultar saldo**: Los usuarios pueden verificar el saldo actual.

### Características
- Uso de hilos para representar múltiples usuarios realizando operaciones simultáneamente.
- Exclusión mutua implementada con `ReentrantLock` para garantizar la integridad de los datos y evitar condiciones de carrera.
- Simulación realista con operaciones y montos aleatorios.

## Estructura del Proyecto

1. **Clases Principales**:
   - `Tarjeta`: Representa las tarjetas electrónicas y maneja las operaciones básicas.
   - `Usuario`: Representa a un usuario que interactúa con una tarjeta en un hilo.
   - `SistemaTarjetas`: Coordina la simulación creando tarjetas, usuarios, y gestionando los hilos.

2. **Clase Principal**: 
   - `ProyectoFinal`: Contiene la función `main` que ejecuta la simulación.

## Requisitos

- **Java 8** o superior.
- NetBeans IDE (opcional, recomendado para simplificar la configuración del proyecto con Maven).

## Ejecución

1. Clona el repositorio y abre el proyecto en NetBeans.
2. Ejecuta la clase `ProyectoFinal` para iniciar la simulación.
3. Observa en la consola cómo los usuarios realizan operaciones concurrentes.

## Licencia

Este proyecto es de uso académico y puede ser utilizado para fines educativos.
