/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exposicion;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author acomesanavila
 */
public class Metodos {

    ArrayList<Carta> baraja = new ArrayList();//llenar con todas las cartas
    ArrayList<Carta> jugador1;
    ArrayList<Carta> jugador2;

    public void barajar() {//con random

    }

    public void cargarArray() {//se llenan los array de cada jugador con una porcion del array baraja
        jugador1 = new ArrayList(baraja.subList(0, 0));// 0= posicion inicial y final en el array baraja
        jugador2 = new ArrayList(baraja.subList(0, 0));
    }

    public void pares() {
        for (int i = 0; i < jugador1.size(); i++) {
            if (jugador1.equals(jugador1.get(i))) {
                jugador1.remove(i);
            }
        }
    }

    public void pares2() {
        for (int i = 0; i < jugador2.size(); i++) {
            if (jugador2.equals(jugador2.get(i))) {
                jugador2.remove(i);
            }
        }
    }

    public void robar() {
        Object num = Integer.parseInt(JOptionPane.showInputDialog("Numero carta"));
        jugador1.add((Carta) num);
        jugador2.remove(num);
        pares();
    }

    public void robar2() {
        Object num = Integer.parseInt(JOptionPane.showInputDialog("Numero carta"));
        jugador2.add((Carta) num);
        jugador1.remove(num);
        pares2();
    }

    public void ganador() {
        if (jugador1.isEmpty() == true) {
            System.out.println("Jugador1 gana");
        } else {
            System.out.println("jugador 2 gana");
        }
    }

    public void turnos() {
        do {
            robar();
            robar2();
        } while (jugador1.isEmpty() == true || jugador2.isEmpty() == true);
    }
}
