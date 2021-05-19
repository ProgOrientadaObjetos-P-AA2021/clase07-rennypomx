/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete6;

/**
 *
 * @author Renny
 */
public class Hospital {

    private String nombre;
    private int numCamas;
    private double presupuesto;

    public Hospital(String nom, int num, double presu) {
        nombre = nom;
        numCamas = num;
        presupuesto = presu;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public void establecerNumCamas(int n) {
        numCamas = n;
    }

    public void establecerPresopuesto(double n) {
        presupuesto = n;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerNumeroCamas() {
        return numCamas;
    }

    public double obtenerPresupueto() {
        return presupuesto;
    }

    // Agregar valor de objetos de tipo hospital a un archivo y leer archivo
}
