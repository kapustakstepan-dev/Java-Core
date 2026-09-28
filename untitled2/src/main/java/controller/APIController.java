package controller;

import com.google.gson.Gson;
import model.Auto;
import model.Car;
import model.Owner;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class APIController {
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    private String get(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public ArrayList<Auto> getVehicles(){
        ArrayList<Auto> list = new ArrayList<>();
        try {
            String json = get("https://dummyjson.com/products/category/vehicle");
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = jsonObject.getJSONArray("products");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject p = jsonArray.getJSONObject(i);
                Car car = new Car("API - "
                        + p.getInt( "id"),2024, 150, p.optString("brand"),"black",500000,
                        new Owner("Owner", "API", "correo@gmial.com", null),
                        p.getDouble("price"), 5);
                car.setPrice(p.getDouble("price"));
                list.add(car);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

}
