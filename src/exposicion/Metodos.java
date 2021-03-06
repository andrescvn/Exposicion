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
import operacions.calculos;

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

    public void amosarManoJugador(ArrayList<Carta> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));//Mano del jugador 1
        }
    }

    public void cargarArray() {//se llenan los array de cada jugador con una porcion del array baraja
        Collections.shuffle(baraja);
        Jugador ju1 = new Jugador(calculos.pedirString(), jugador1 = new ArrayList(baraja.subList(0, 20)));// 0= posicion inicial y final en el array 
        Jugador ju2 = new Jugador(calculos.pedirString(), jugador2 = new ArrayList(baraja.subList(21, 39)));
    }

    public void pares(List<Carta> jugador) {
        Carta aux = null;
        for (int j = 0; j < jugador.size(); j++) {//carta a comparar
            aux = jugador.get(j);
            for (int i = 0; i < jugador.size(); i++) {//comparacion con el resto de la mano
                if ( aux.getNumero()==jugador.get(i).getNumero()&& !(aux == jugador.get(i))) {
                    jugador.remove(i);
                    jugador.remove(j);
                        }                                    
            }
        }
    }


    public void robar(ArrayList<Carta> lista, ArrayList<Carta> lista2) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Numero carta"));
        try {
            lista.add(lista2.get(num));
        } catch (Exception ex) {
            System.out.println("error:" + ex.getMessage());
        }
        lista.remove(num);
        pares(lista);
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

            robar(jugador1, jugador2);
            amosarManoJugador(jugador1);
            robar(jugador2, jugador1);
            amosarManoJugador(jugador2);
        } while (jugador1.isEmpty() == false || jugador2.isEmpty() == false);

    }



    public void llenarBaraja(String nomFich) {
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
