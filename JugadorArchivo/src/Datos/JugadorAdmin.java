/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.JugadorModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc12
 */
public class JugadorAdmin {
    
    public void Guardar(JugadorModel modelo) {
    
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\archivos\\jugador.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(modelo.getNombre()+ "," + modelo.getJuego()+ "," + modelo.getEdad());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
         
    }
    
    public List<JugadorModel>Mostrar() {
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        List<JugadorModel> lista = new ArrayList<>();
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("C:\\archivos\\jugador.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;           
            while ((linea = br.readLine()) != null) { //mientras haya linea mostramos
                JugadorModel modelo = new JugadorModel();
                String arreglo[] = linea.split(",");// metodo para partir un caracter !!! metodo CSV
                modelo.setNombre(arreglo[0]);
                modelo.setJuego(arreglo[1]);
                modelo.setEdad(Integer.parseInt(arreglo[2]));
                
                lista.add(modelo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
    
    
}
        
        return lista;
        
}
    
}

    

    

    

