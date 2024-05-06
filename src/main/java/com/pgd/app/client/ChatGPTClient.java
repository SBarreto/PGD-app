package com.pgd.app.client;

import com.pgd.app.dto.chatgpt.ChatGPTRequest;
import com.pgd.app.dto.chatgpt.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatGPTClient {

    private final RestTemplate restTemplate;
    @Value("${openai.chatgtp.model}")
    private String model;

    @Value("${openai.chatgtp.temperature}")
    private double temperature;

    @Value("${openai.chatgtp.max_tokens}")
    private int maxTokens;

    @Value("${openai.chatgtp.api.url}")
    private String apiUrl;

    public ChatGPTClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String promptObservaciones(String prompt) {
        ChatGPTRequest request = new ChatGPTRequest(model, prompt, temperature, maxTokens);
        ChatGPTResponse chatGPTResponse = restTemplate.postForObject(apiUrl, request, ChatGPTResponse.class);
        return chatGPTResponse.choices().get(0).message().content();
    }
}