package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import modelo.Contacto;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManejadorJSON {

    public static ArrayList<Contacto> cargar(String archivo) {

        try(FileReader reader = new FileReader(archivo)) {

            Gson gson = new Gson();
            Type tipoLista = new TypeToken<ArrayList<Contacto>>(){}.getType();

            ArrayList<Contacto> lista = gson.fromJson(reader, tipoLista);

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

            File f = new File(archivo);

            if(f.exists()) {

                try(
                        FileInputStream in = new FileInputStream(f);
                        FileOutputStream out = new FileOutputStream(backup)
                ){
                    in.transferTo(out);
                }
            }

            try(FileWriter writer = new FileWriter(archivo)) {

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(contactos, writer);
            }

        } catch(Exception e) {

            System.out.println("Error al guardar JSON");
        }
    }
}