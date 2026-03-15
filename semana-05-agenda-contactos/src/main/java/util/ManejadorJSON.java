package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import modelo.Contacto;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManejadorJSON {

    public static ArrayList<Contacto> cargar(String archivo) {

        try {

            Gson gson = new Gson();

            FileReader reader = new FileReader(archivo);

            Type tipoLista = new TypeToken<ArrayList<Contacto>>(){}.getType();

            ArrayList<Contacto> lista = gson.fromJson(reader, tipoLista);

            reader.close();

            if(lista == null)
                lista = new ArrayList<>();

            return lista;

        } catch(Exception e) {

            return new ArrayList<>();
        }
    }

    public static void guardarConBackup(ArrayList<Contacto> contactos,
                                        String archivo,
                                        String backup) {

        try {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            FileWriter writer = new FileWriter(archivo);

            gson.toJson(contactos, writer);

            writer.close();

        } catch(Exception e) {

            System.out.println("Error al guardar archivo JSON");
        }
    }
}