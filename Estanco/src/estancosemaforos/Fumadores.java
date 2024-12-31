/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estancosemaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Armando
 */
public class Fumadores extends Thread {

    /**
     * @param args the command line arguments
     */
    
    // Número que identificará al fumador en cuestión.
    
    private final int numerodelFumador;
    
    // Ingrediente necesario como su propio nombre indica para que el fumador pueda fumar.
    private final String ingredienteNecesario;
    
    // Semaforos que controlará la disponibilidad tanto del ingrediente necesario para que el fumador fume como del estanquero.
    private final Semaphore ingrediente;
    private final Semaphore estanquero;
    
    // Constructor del Fumador.
    public Fumadores(int numerodelFumador, String ingredienteNecesario, Semaphore ingrediente, Semaphore estanquero) {
        this.numerodelFumador = numerodelFumador;
        this.ingredienteNecesario = ingredienteNecesario;
        this.ingrediente = ingrediente;
        this.estanquero = estanquero;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ingrediente.acquire(); // Este esperará al ingrediente faltante.

                System.out.println("El fumador número: " + numerodelFumador + " ha conseguido el ingrediente que le hacía falta: " + ingredienteNecesario + " y va a fumar.");
                Thread.sleep(3000); // Un fumador tarda unos tres segundos en fumarse el cigarro.
                System.out.println("El fumador número: " + numerodelFumador + " termina de fumar.");
                System.out.println("");

                estanquero.release(); // Se avisa al estanquero de que el fumador necesita un ingrediente ya que ha agotado el suyo.
            } catch (InterruptedException e) {
                // System.out.println("El fumador número: " + identificacionFumador + " ha sido interrumpido.");
                return;
            }
        }
    }
}
