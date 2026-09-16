package controller;

import com.google.gson.Gson;
import model.Libros;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class APIController {
    HttpClient client;
    HttpRequest request;
    HttpResponse response;
    FileWriter fileWriter;
    String url = "https://stephen-king-api.onrender.com/api/books";



    public void AllAPI(){
        Gson gson = new Gson();
        try {
            client = HttpClient.newHttpClient();
            request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String productosSTR = (String) response.body();
            JSONObject productosJSON = new JSONObject(productosSTR);
            JSONArray productsArray = productosJSON.getJSONArray("books");

            for (int i = 0; i < productsArray.length(); i++) {
                JSONObject productJSON = productsArray.getJSONObject(i);

                Libros libros = gson.fromJson(productJSON.toString(), Libros.class);
                System.out.println(libros.getTitle() + " " + libros.getPages());
            }

        } catch (Exception e) {
            System.out.println("Error en la peticion HTTP");
        }
    }

    public Libros buscarID(int id){
        Gson gson = new Gson();
        Libros libros = null;

        try {
            String urlLibro = url + "/" + id;
            client = HttpClient.newHttpClient();
            request = HttpRequest.newBuilder().GET().uri(URI.create(urlLibro)).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String productosSTR = (String) response.body();
            System.out.println(productosSTR);
            JSONObject object = new JSONObject(productosSTR);
            libros = gson.fromJson(object.toString(), Libros.class);

        } catch (Exception e) {
            System.out.println("Error en la peticion HTTP");
        }
        return libros;
    }

   /* public Libros masPaginas(ArrayList<Libros> libros){
        if (libros.isEmpty()){
           return null;
        }
       Libros libros1 = libros.get(0);
       for (Libros item : libros1){
            item.getPages() > masPaginas()
       }
       return libros1;
    }

    */
    public void AnidirFav(int id){
        try {
            fileWriter = new FileWriter(new File("src/main/java/files/favoritos.obj"));
            fileWriter.write(id);
        } catch (IOException e) {
            System.out.println("Error en la ruta");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error al cerrado de fichero");
            }
        }
    }
}
