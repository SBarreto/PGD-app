package com.pgd.app.dto.chatgpt;

import java.util.List;

public record ChatGPTResponse(
        List<Choice> choices) { }
