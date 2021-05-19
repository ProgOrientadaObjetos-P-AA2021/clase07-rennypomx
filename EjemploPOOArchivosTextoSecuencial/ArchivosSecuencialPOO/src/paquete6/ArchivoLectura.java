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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class ArchivoLectura {

    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<Hospital> lista;

    public ArchivoLectura(String n) {
        nombreArchivo = n;

        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());
        File f = new File(rutaArchivo);
        if (f.exists()) {
            try {
                entrada = new Scanner(new File(rutaArchivo));
            } // fin de try
            catch (FileNotFoundException e) {
                System.err.println("Error al leer el archivo: " + e);
            } 
        }
    }
    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt",
                obtenerNombreArchivo());;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    public void establecerLista() {
        lista = new ArrayList<>();
        File f = new File(rutaArchivo);

        if (f.exists()) {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";")));
                String nombre = linea_partes.get(0);
                int numeroCamas = Integer.parseInt(linea_partes.get(1));
                double presupuesto = Double.parseDouble(linea_partes.get(2).replace(",", "."));

                Hospital hosp = new Hospital(nombre, numeroCamas, presupuesto);

                lista.add(hosp);
            } 
        }
    }
    public ArrayList<Hospital> obtenerLista() {

        return lista;
    }
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } 
    }
    @Override
    public String toString() {
        String cadena = "HOSPITALES\n";

        for (int i = 0; i < obtenerLista().size(); i++) {
            cadena = String.format("%sNombre: %s\nNumero Camas: %d\nPresupuesto: "
                    + "%.2f\n", cadena,
                    obtenerLista().get(i).obtenerNombre(),
                    obtenerLista().get(i).obtenerNumeroCamas(),
                    obtenerLista().get(i).obtenerPresupueto());
        }
        return cadena;
    }
}

