package com.lfelipe.alura.music.network.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class GroqApi {

    @Value("${api.key.groq}")
    private String apiKey;
    @Value("${api.url.groq}")
    private String url;
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final String CONTENT_TYPE = "application/json";


    public String post(String busca, String endPoint) throws Exception {
        String body = "{ \"model\": \"meta-llama/llama-4-scout-17b-16e-instruct\", " +
                "\"messages\": [{ \"role\": \"user\", \"content\": \""+ busca +"\" }] }";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + endPoint))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", CONTENT_TYPE)
                .header("Authorization","Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
