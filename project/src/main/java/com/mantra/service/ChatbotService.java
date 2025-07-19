package com.mantra.service;

import com.mantra.dto.chatbot.ChatbotRequest;
import com.mantra.dto.chatbot.ChatbotResponse;

public interface ChatbotService {
    ChatbotResponse processMessage(ChatbotRequest request);
}