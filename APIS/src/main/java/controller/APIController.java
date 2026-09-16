package controller;


import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class APIController {
    private String url = "https://api.el-tiempo.net/json/v3/general";
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;
    private FileWriter writer;
    private Scanner scanner;

    public void busquedaGeneral(){

        try {
            client = HttpClient.newHttpClient();
            request = HttpRequest
                    .newBuilder()
                    .GET()
                    .uri(URI.create(url))
                    .build();
            response = client.send(request , HttpResponse.BodyHandlers.ofString());
            String datosStr = response.body();
            JSONObject datosJSON = new JSONObject(datosStr);
            JSONArray datosArray = datosJSON.getJSONArray("provincias");

            System.out.println("\nLista de provincias");

            for (int i = 0; i < datosArray.length(); i++) {
                JSONObject datosProv = datosArray.getJSONObject(i);

                String codigo = datosProv.getString("CODPROV");
                String nombre = datosProv.getString("NOMBRE_PROVINCIA");

                System.out.println(codigo+ " -> "+ nombre);

            }

        } catch (IOException e) {
            System.out.println("Error en la peticionde HTTPS");
        } catch (InterruptedException e) {
            System.out.println("Error en " + e.getMessage());
        }
    }

    public void busquedaParticular(String busqueda){
        try {
            client = HttpClient.newHttpClient();
            request = HttpRequest
                    .newBuilder()
                    .GET()
                    .uri(URI.create(url))
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String datosStr = response.body();
            JSONObject datosJSON = new JSONObject(datosStr);
            JSONArray datosArray = datosJSON.getJSONArray("provincias");

            boolean provEncontrada = false;
            for (int i = 0; i <datosArray.length() ; i++) {
                JSONObject datosProv= datosArray.getJSONObject(i);

                String nombre = datosProv.getString("NOMBRE_PROVINCIA");
                String codigo = datosProv.getString("CODPROV");
                String codComAut = datosProv.getString("CODAUTON");
                String comCiuAut = datosProv.getString("COMUNIDAD_CIUDAD_AUTONOMA");
                String capProv = datosProv.getString("CAPITAL_PROVINCIA");

                if (nombre.toLowerCase().contains(busqueda.toLowerCase()) || codigo.equals(busqueda)){
                    System.out.printf("\n\tBuscando %s salen los datos siguientes: " +
                            "\nCodigo de provincia -> %s " +
                            "\nCodigo de comunidad autonoma -> %s " +
                            "\nComunidad autonoma -> %s" +
                            "\nCapital de provincia -> %s",
                            nombre, codigo, codComAut, comCiuAut,capProv);
                    provEncontrada = true;
                }
            }
            if (!provEncontrada){
                System.out.println("Provincia que has buscando no se encuentra ");
            }

        } catch (Exception e) {
            System.out.println("Error en la peticion HTTP");
        }
    }

    public void exportToFile() {

        try {
            client = HttpClient.newHttpClient();
            request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String datos = response.body();

            JSONObject datosJSON = new JSONObject(datos);

            writer = new FileWriter("src/main/java/ficheros/General.txt");
            writer.write(datosJSON.toString(3));

        } catch (Exception e) {
            System.out.println("Error en la peticion");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Error en el serado del cerrado");
            }
        }
    }
    public void setUrl(String nuevaUrl) {
        this.url = nuevaUrl;
        System.out.println("\nURL actualizada" + url);
    }

    private String nombreProv(String codProv){
        String nombre = "";


        try {
            client = HttpClient.newHttpClient();
            request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String datosStr = response.body();
            JSONObject datosJSON = new JSONObject(datosStr);
            JSONArray datosArray = datosJSON.getJSONArray("provincias");

            for (int i = 0; i < datosArray.length(); i++) {
                JSONObject nomProv = datosArray.getJSONObject(i);
                String codigo = nomProv.getString("CODPROV");
                if (codigo.equals(codProv)){
                    nombre = nomProv.getString("NOMBRE_PROVINCIA");
                }
            }
        } catch (IOException e) {
            System.out.println("Error en la peticionde HTTPS");
        } catch (InterruptedException e) {
            System.out.println("Error en " + e.getMessage());
        }

        return nombre;
    }

    public void menuProvinvias(String codProv){
        String urlCiud = "https://api.el-tiempo.net/json/v3/provincias/" + codProv + "/municipios";
        scanner = new Scanner(System.in);
        JSONObject datosJSON;
        JSONArray datosARRAY;
        int opcion;


        String nombre = nombreProv(codProv);

        try {
            client = HttpClient.newHttpClient();
            request = HttpRequest.newBuilder().GET().uri(URI.create(urlCiud)).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String datosStr = response.body();
            datosJSON = new JSONObject(datosStr);

            if (datosJSON.has("municipios")) {
                datosARRAY = datosJSON.getJSONArray("municipios");
            } else {
                datosARRAY = new JSONArray();
                System.out.println("Provincia elegida no tiene municipios en JSON");
            }
        } catch (IOException e) {
            System.out.println("Error en la peticionde HTTPS");
            return;
        } catch (InterruptedException e) {
            System.out.println("Error en " + e.getMessage());
            return;
        }


        do {
            System.out.println();
            System.out.println("\n\tMenu Provincia -> "+ codProv+ " - "+ nombre);
            System.out.println("1 Informacion basica");
            System.out.println("2 Datos demograficos");
            System.out.println("3 Datos geográficos");
            System.out.println("4 Coordenadas");
            System.out.println("5 Exportar datos a fichero");
            System.out.println("6 Volver al menu principal");
            System.out.print("\tElige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion){
                case 1->{
                    System.out.print("Codigo, Nombre");
                    for (int i = 0; i < datosARRAY.length(); i++) {
                        JSONObject datos = datosARRAY.getJSONObject(i);
                        System.out.println(datos.getString("COD_GEO") + " " + datos.getString("NOMBRE"));
                    }
                }
                case 2->{
                    System.out.println("\nIntroduzca nombre de cuidad o codigo geo para sacar una info");
                    String busqueda = scanner.nextLine().trim().toLowerCase();
                    for (int i = 0; i < datosARRAY.length(); i++) {
                        JSONObject datos = datosARRAY.getJSONObject(i);
                        String nombreCiud = datos.getString("NOMBRE").toLowerCase();
                        String codigoCiud = datos.getString("COD_GEO");
                        if (nombreCiud.contains(busqueda) || codigoCiud.equals(busqueda)) {
                            System.out.println("\nPoblacion -> " + datos.getInt("POBLACION_MUNI"));
                        }
                    }
                }
                case 3->{
                    System.out.println("\nIntroduzca nombre de cuidad o codigo geo para saacr una info");
                    String busqueda = scanner.nextLine().trim().toLowerCase();
                    for (int i = 0; i < datosARRAY.length(); i++) {
                        JSONObject datos = datosARRAY.getJSONObject(i);
                        String nombreCiud = datos.getString("NOMBRE").toLowerCase();
                        String codigoCiud = datos.getString("COD_GEO");
                        if (nombreCiud.contains(busqueda) || codigoCiud.equals(busqueda)) {
                            System.out.printf("\nSuperficie -> %.2f km2, Perimetro -> %d m, Altitud -> %d m/n",
                                    datos.getDouble("SUPERFICIE"), datos.getInt("PERIMETRO"), datos.getInt("ALTITUD"));
                        }
                    }
                }
                case 4->{
                    System.out.println("\nIntroduzca nombre de cuidad o codigo geo para saacr una info");
                    String busqueda = scanner.nextLine().trim().toLowerCase();
                    for (int i = 0; i < datosARRAY.length(); i++) {
                        JSONObject datos = datosARRAY.getJSONObject(i);
                        String nombreCiud = datos.getString("NOMBRE").toLowerCase();
                        String codigoCiud = datos.getString("COD_GEO");
                        if (nombreCiud.contains(busqueda) || codigoCiud.equals(busqueda)) {
                            System.out.printf("\nLatitud -> %.6f, Longitud -> %.6f",
                                    datos.getDouble("LATITUD_ETRS89_REGCAN95"), datos.getDouble("LONGITUD_ETRS89_REGCAN95"));
                        }
                    }
                }
                case 5->{
                    try {
                        writer = new FileWriter("src/main/java/ficheros/Info sobre Provincias "+ codProv+ ".txt", true);
                        writer.write(datosJSON.toString(3));

                    } catch (IOException e) {
                        System.out.println("Error en la ruta de fichero");
                    } finally {
                        try {
                            writer.close();
                        } catch (IOException e) {
                            System.out.println("Error al cerrado del fichero");
                        }
                    }
                }
                case 6->{
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Opcion no valida");
                }
            }
        } while (opcion!=6);
    }


}
