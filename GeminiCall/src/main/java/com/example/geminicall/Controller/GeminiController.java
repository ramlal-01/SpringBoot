package com.example.geminicall.controller;

import com.example.geminicall.model.GeminiRequest;
import com.example.geminicall.model.GeminiResponse;
import com.example.geminicall.service.GeminiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GeminiController {

    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/ask")
    public GeminiResponse askGemini(@RequestBody GeminiRequest request) {

        String reply = geminiService.getGeminiResponse(request.getPrompt());
        return new GeminiResponse(reply);
    }
}
