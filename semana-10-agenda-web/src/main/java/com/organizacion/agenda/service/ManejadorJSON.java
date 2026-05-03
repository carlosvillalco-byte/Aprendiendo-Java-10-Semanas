package com.organizacion.agenda.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ManejadorJSON<T> {

    private final String archivo;
    private final Type tipoLista;
    public ManejadorJSON(Class<T> clase, String archivo)
    {
        this.archivo = archivo;
        this.tipoLista =TypeToken.getParameterized(List.class, clase).getType();
    }
    public List<T> cargar()
    {
        try (FileReader reader = new FileReader(archivo))
        {
            Gson gson = new Gson();
            List<T> lista = gson.fromJson(reader, tipoLista);
            return lista != null
                    ? lista
                    : new ArrayList<>();

        }
        catch (Exception e)
        {
            return new ArrayList<>();
        }
    }

    public void guardar(List<T> lista)
    {
        try (FileWriter writer = new FileWriter(archivo))
        {
            Gson gson =new GsonBuilder()
                            .setPrettyPrinting()
                            .create();

            gson.toJson(lista, writer);

        }
        catch (Exception e)
        {
            System.out.println("Error al guardar JSON");
        }
    }
}