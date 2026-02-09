package com.example.geminicall.service;

import com.example.geminicall.config.GeminiConfig;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class GeminiService {

    private final GeminiConfig geminiConfig;
    private final RestTemplate restTemplate = new RestTemplate();

    public GeminiService(GeminiConfig geminiConfig) {
        this.geminiConfig = geminiConfig;
    }

    public String getGeminiResponse(String prompt) {

        try {
            String url =
                    "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key="
                            + geminiConfig.getApiKey();

            Map<String, Object> body = Map.of(
                    "contents", List.of(
                            Map.of(
                                    "parts", List.of(
                                            Map.of("text", prompt)
                                    )
                            )
                    )
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> request =
                    new HttpEntity<>(body, headers);

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(url, request, Map.class);

            Map<String, Object> responseBody = response.getBody();

            if (responseBody == null) {
                return "No response from Gemini";
            }

            // 🔴 Handle Gemini error
            if (responseBody.containsKey("error")) {
                Map<String, Object> error =
                        (Map<String, Object>) responseBody.get("error");
                return "Gemini Error: " + error.get("message");
            }

            List<Map<String, Object>> candidates =
                    (List<Map<String, Object>>) responseBody.get("candidates");

            if (candidates == null || candidates.isEmpty()) {
                return "Gemini returned no candidates";
            }

            Map<String, Object> content =
                    (Map<String, Object>) candidates.get(0).get("content");

            List<Map<String, Object>> parts =
                    (List<Map<String, Object>>) content.get("parts");

            return parts.get(0).get("text").toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Server error while calling Gemini API";
        }
    }
}
