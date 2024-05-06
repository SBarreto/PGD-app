package com.pgd.app.dto.chatgpt;

import java.util.ArrayList;
import java.util.List;

public record ChatGPTRequest(
        String model,
        List<Message> messages,
        double temperature,
        int max_tokens ) {

    public ChatGPTRequest(String model, String prompt, double temperature, int max_tokens) {
        this(model, new ArrayList<>(), temperature, max_tokens);
        this.messages.add(new Message("user", prompt));
    }

}
