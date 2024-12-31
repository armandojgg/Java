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

public class Estanquero extends Thread {
    
    /**
     * @param args the command line arguments
     */
    
    // Semaforos que controlaran la disponibilidad del tabaco, papel, cerillas y del estanquero.
    private final Semaphore tabaco;
    private final Semaphore papel;
    private final Semaphore cerillas;
    private final Semaphore estanquero;
    
    // Variable booleana que controlará si el estanquero está trabajando o no.
    private boolean trabajando;
    
    // Definimos el constructor del estanquero, pasandole los semaforos de tabaco, papel, cerillas y estanquero.
    public Estanquero(Semaphore tabaco, Semaphore papel, Semaphore cerillas, Semaphore estanquero) {
        this.tabaco = tabaco;
        this.papel = papel;
        this.cerillas = cerillas;
        this.estanquero = estanquero;
        this.trabajando = true;
    }

    @Override
    public void run() {
        while (trabajando) {
            try {
                estanquero.acquire();

                if (!trabajando) {
                    break;
                }

                // Utilizamos un Math.random() haciendo así que el estanquero cada segundo produzca un ingrediente diferente.
                int ingrediente = (int) (Math.random() * 3);
                switch (ingrediente) {
                    case 0:
                        System.out.println("El estanquero acaba de producir tabaco.");
                        tabaco.release();
                        break;
                    case 1:
                        System.out.println("El estanquero acaba de producir papel.");
                        papel.release();
                        break;
                    case 2:
                        System.out.println("El estanquero acaba de producir cerillas.");
                        cerillas.release();
                        break;
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Método que acaba la jornada laboral del estanquero.
    
    public void finalizacionJornadaLaboral() {
        trabajando = false;
        estanquero.release();
        System.out.println("");
        System.out.println("El estanquero ha terminado su jornada laboral. ¡Hasta mañana!");
    }
}
