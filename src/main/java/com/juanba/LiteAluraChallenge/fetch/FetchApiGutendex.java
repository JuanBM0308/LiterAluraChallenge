package com.juanba.LiteAluraChallenge.fetch;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchApiGutendex {
    public String fetchData(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                return response.body();
            } else {
                System.err.println("Error al llamar a la API. Código de estado: " + response.statusCode());
                System.err.println("Cuerpo de la respuesta (puede contener información del error):\n" + response.body());
                return "";
            }

        } catch (IOException e) {
            System.err.println("Error de IO al llamar a la API: " + e.getMessage());
            return "";
        } catch (InterruptedException e) {
            System.err.println("La llamada a la API fue interrumpida: " + e.getMessage());
            return "";
        }
    }
}