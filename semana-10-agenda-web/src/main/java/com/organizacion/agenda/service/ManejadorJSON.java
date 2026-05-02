package com.organizacion.agenda.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.organizacion.agenda.modelo.Contacto;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ManejadorJSON {
    private String archivo;
    public ManejadorJSON(String archivo) 
    {
        this.archivo = archivo;
    }
    public List<Contacto> cargar() 
    {
        try (FileReader reader = new FileReader(archivo))
         {
            Gson gson = new Gson();
            Type tipoLista = new TypeToken<ArrayList<Contacto>>(){}.getType();
            List<Contacto> lista = gson.fromJson(reader, tipoLista);
            return lista != null ? lista : new ArrayList<>();
        } catch (Exception e) 
        {
            return new ArrayList<>();
        }
    }
    public void guardar(List<Contacto> contactos) {
        try (FileWriter writer = new FileWriter(archivo)) 
        {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(contactos, writer);
        } catch (Exception e) 
        {
            System.out.println("Error al guardar JSON");
        }
    }
}