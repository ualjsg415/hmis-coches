package org.hmis;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path rutaPath = Path.of("data", "coches.json");
        if (!Files.exists(rutaPath)) {
        	rutaPath = Path.of("hmis-coches", "data", "coches.json");
        }
        String ruta = rutaPath.toAbsolutePath().normalize().toString();
        System.out.println("Direccion del archivo: " + ruta);

    	Coche[] coches = JsonReader.leerCochesJSON(ruta);
    	
    	// Imprimir los objetos del arreglo
        for (Coche coche : coches) {
            System.out.println(coche);
        }
    }
}

