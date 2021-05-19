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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

public class ArchivoEscritura {

    private String nomArchivo;
    private String rutaArchivo;
    private Hospital registro;
    private Formatter salidaArchivo;

    public ArchivoEscritura(String n) {
        nomArchivo = n;
        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());

        establecerInformacionAnterior();

    }
    public void establecerInformacionAnterior() {

        ArchivoLectura lectura = new ArchivoLectura(nomArchivo);
        lectura.establecerLista();
        ArrayList<Hospital> lista = lectura.obtenerLista();

        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {

                if (lista.size() > 0) {
                    for (int i = 0; i < lista.size(); i++) {

                        establecerRegistro(lista.get(i));
                        establecerSalida();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer del archivo: " + e);

        } 
    }

    public void establecerNombreArchivo(String n) {
        nomArchivo = n;
    }

    public void establecerRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt",
                obtenerNombreArchivo());;
    }

    public void establecerRegistro(Hospital n) {
        registro = n;
    }

    public String obtenerNombreArchivo() {
        return nomArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    public Hospital obtenerRegistro() {
        return registro;
    }
    
    public void establecerSalida() {
        try {
            Hospital p = obtenerRegistro();
            String cadenaRegistro = String.format("%s;%d;%.2f",
                    p.obtenerNombre(),
                    p.obtenerNumeroCamas(),
                    p.obtenerPresupueto());
            salidaArchivo.format("%s\n", cadenaRegistro);

        } catch (Exception e) {
            System.err.println("Error al crear el archivo.");
            System.err.println(e);
        }
    }
    public void cerrarArchivo() {
        if (salidaArchivo != null) {
            salidaArchivo.close();
        } 
    }
}

