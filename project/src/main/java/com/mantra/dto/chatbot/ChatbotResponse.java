package com.mantra.dto.chatbot;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatbotResponse {
    private String response;
    private String timestamp;
}