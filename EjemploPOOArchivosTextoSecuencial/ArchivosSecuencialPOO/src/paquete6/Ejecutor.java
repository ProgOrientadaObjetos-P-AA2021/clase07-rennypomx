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
public class Ejecutor {

    public static void main(String[] args) {
        
        Hospital h1 = new Hospital("Clinica Mogrovejo", 20, 2013.159);
        Hospital h2 = new Hospital("Clinica San Jose", 30, 2011.456);
        Hospital h3 = new Hospital("Clínica San Agustin", 40, 2014.789);

        String nombreArchivo = "hospital.txt";

        Hospital[] lista = {h1, h2, h3};

        ArchivoEscritura archivo = new ArchivoEscritura(nombreArchivo);

        for (int i = 0; i < lista.length; i++) {     
            archivo.establecerRegistro(lista[i]);
            archivo.establecerSalida();
        }
        archivo.cerrarArchivo();
        
        ArchivoLectura lectura = new ArchivoLectura(nombreArchivo);
        lectura.establecerLista();
        System.out.println(lectura);
    }
}
