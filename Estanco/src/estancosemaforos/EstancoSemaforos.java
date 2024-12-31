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

public class EstancoSemaforos {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        // Creamos un semaforo por cada ingrediente necesario y otro para el estanquero.
        Semaphore semTabaco = new Semaphore(0);
        Semaphore semPapel = new Semaphore(0);
        Semaphore semCerillas = new Semaphore(0);
        Semaphore semEstanquero = new Semaphore(1);

        // Instanciamos el estanquero.
        Estanquero estanquero = new Estanquero(semTabaco, semPapel, semCerillas, semEstanquero);

        // Creamos e iniciamos cada fumador con ingredientes diferentes, se puede cambiar dependiendo del ingrediente que queramos que necesite.
        Fumadores primerFumador = new Fumadores(1, "Tabaco", semTabaco, semEstanquero);
        Fumadores segundoFumador = new Fumadores(2, "Papel", semPapel, semEstanquero);
        Fumadores tercerFumador = new Fumadores(3, "Cerillas", semCerillas, semEstanquero);

        primerFumador.start();
        segundoFumador.start();
        tercerFumador.start();

        // A continuación iniciamos el hilo del estanquero.
        estanquero.start();

        // El programa durará unos 30 segundos.
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Al finalizar su jornada, finaliza el programa.
        estanquero.finalizacionJornadaLaboral();

        // Esperamos a que todos los hilos hayan finalizado para acabar el programa.
        try {
            estanquero.join();
            primerFumador.interrupt();
            segundoFumador.interrupt();
            tercerFumador.interrupt();
            primerFumador.join();
            segundoFumador.join();
            tercerFumador.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
