/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exposicion;

import exposicion.objetos.Carta;
import exposicion.objetos.Jugador;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author acomesanavila
 */
public class Metodos {

    ArrayList<Carta> baraja = new ArrayList();//llenar con todas las cartas
    ArrayList<Carta> jugador1;
    ArrayList<Carta> jugador2;
    Scanner sc;

    public void amosar() {
        for (int i = 0; i < baraja.size(); i++) {
            System.out.println(baraja.get(i));//Comprobacion del orden de la baraja
        }
    }

    public void amosarManoJugador() {
        int op = Integer.parseInt(JOptionPane.showInputDialog("jugador 1 o 2?"));
        if (op == 1) {
            for (int i = 0; i < jugador1.size(); i++) {
                System.out.println(jugador1.get(i));//Mano del jugador 1
            }
        } else {
            for (int i = 0; i < jugador2.size(); i++) {
                System.out.println(jugador2.get(i));//Mano del jugador 2
            }
        }
    }

    public void cargarArray() {//se llenan los array de cada jugador con una porcion del array baraja
        Collections.shuffle(baraja);
        Jugador ju1 = new Jugador(pedirNombre(),jugador1 = new ArrayList(baraja.subList(0, 0)));// 0= posicion inicial y final en el array 
        Jugador ju2 = new Jugador(pedirNombre(),jugador2 = new ArrayList(baraja.subList(0, 0)));
    }

    public void pares(List<Carta> jugador) {
        Object aux = null;
        for (int j = 0; j < jugador.size(); j++) {//carta a comparar
            aux = jugador.get(j);
            for (int i = 0; i < jugador.size(); i++) {//comparacion con el resto de la mano
                if (aux.equals(jugador.get(i)) && !(aux == jugador.get(i))) {
                    jugador.remove(i);
                    jugador.remove(aux);
                }
            }
        }
    }

    public void robar(int turno) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Numero carta"));
        if (turno == 1) {
            jugador1.add(jugador2.get(num));
            jugador2.remove(num);
            pares(jugador1);
        } else {
            jugador2.add(jugador1.get(num));
            jugador1.remove(num);
            pares(jugador2);
        }
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
            robar(1);
            robar(2);
        } while (jugador1.isEmpty() == true || jugador2.isEmpty() == true);
    }

    public String pedirNombre() {
        return JOptionPane.showInputDialog("Nombre?");
    }
    public void llenarBaraja(String nomFich){
        String[] aux;
     try {
            sc = new Scanner(new File(nomFich));
            while (sc.hasNextLine()) {
                aux = sc.nextLine().split(",");
                Carta cart = new Carta(Integer.parseInt(aux[0]), aux[1]);
                baraja.add(cart);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            sc.close();
        }
    }
}
