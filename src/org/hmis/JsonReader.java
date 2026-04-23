package org.hmis;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonReader {

	public static Coche[] leerCochesJSON (String archivo) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(archivo)) {
            // Parsear el archivo JSON en un objeto de la clase JsonObject
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            // Obtener el arreglo de objetos "coches"
            JsonArray cochesJson = jsonObject.getAsJsonArray("coches");

            if (cochesJson == null) {
                return new Coche[0];
            }

            // Crear un arreglo de la clase Coche y llenarlo con los objetos del archivo JSON
            Coche[] coches = gson.fromJson(cochesJson, Coche[].class);
            return coches != null ? coches : new Coche[0];

            
        } catch (Exception e) {
            return new Coche[0];
        }

	}
}
