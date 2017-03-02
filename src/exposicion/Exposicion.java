/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exposicion;

/**
 *
 * @author acomesanavila
 */
public class Exposicion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos met = new Metodos();
        met.llenarBaraja("");
        met.amosarManoJugador();
        met.cargarArray();
        met.turnos();
        met.ganador();
    }
    
}
