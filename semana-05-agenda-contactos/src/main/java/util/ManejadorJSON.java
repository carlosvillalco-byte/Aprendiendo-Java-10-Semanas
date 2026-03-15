package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modelo.Contacto;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ManejadorJSON {

    private static final String ARCHIVO = "data/contactos.json";

    public static List<Contacto> leerContactos() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(ARCHIVO);

            Type tipoLista = new TypeToken<List<Contacto>>(){}.getType();

            List<Contacto> contactos = gson.fromJson(reader, tipoLista);

            reader.close();

            if(contactos == null){
                contactos = new ArrayList<>();
            }

            return contactos;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void guardarContactos(List<Contacto> contactos) {
        try {

            Gson gson = new Gson();

            FileWriter writer = new FileWriter(ARCHIVO);

            gson.toJson(contactos, writer);

            writer.flush();
            writer.close();

        } catch (Exception e) {
            System.out.println("Error al guardar contactos");
        }
    }

}