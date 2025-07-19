package com.mantra.service;

import com.mantra.dto.chatbot.ChatbotRequest;
import com.mantra.dto.chatbot.ChatbotResponse;
import com.mantra.service.impl.ChatbotServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChatbotServiceTest {

    @InjectMocks
    private ChatbotServiceImpl chatbotService;

    private ChatbotRequest chatbotRequest;

    @BeforeEach
    void setUp() {
        chatbotRequest = new ChatbotRequest();
    }

    @Test
    void processMessage_StressKeyword_ReturnsStressResponse() {
        // Given
        chatbotRequest.setMessage("I'm feeling very stressed about work");

        // When
        ChatbotResponse response = chatbotService.processMessage(chatbotRequest);

        // Then
        assertNotNull(response);
        assertNotNull(response.getResponse());
        assertNotNull(response.getTimestamp());
        assertTrue(response.getResponse().toLowerCase().contains("stress"));
    }

    @Test
    void processMessage_AnxietyKeyword_ReturnsAnxietyResponse() {
        // Given
        chatbotRequest.setMessage("I have anxiety about the future");

        // When
        ChatbotResponse response = chatbotService.processMessage(chatbotRequest);

        // Then
        assertNotNull(response);
        assertNotNull(response.getResponse());
        assertNotNull(response.getTimestamp());
        assertTrue(response.getResponse().toLowerCase().contains("anxiety"));
    }

    @Test
    void processMessage_SadKeyword_ReturnsSadResponse() {
        // Given
        chatbotRequest.setMessage("I'm feeling really sad today");

        // When
        ChatbotResponse response = chatbotService.processMessage(chatbotRequest);

        // Then
        assertNotNull(response);
        assertNotNull(response.getResponse());
        assertNotNull(response.getTimestamp());
        assertTrue(response.getResponse().toLowerCase().contains("sad") || 
                   response.getResponse().toLowerCase().contains("feeling"));
    }

    @Test
    void processMessage_HelpKeyword_ReturnsHelpResponse() {
        // Given
        chatbotRequest.setMessage("I need help with my mental health");

        // When
        ChatbotResponse response = chatbotService.processMessage(chatbotRequest);

        // Then
        assertNotNull(response);
        assertNotNull(response.getResponse());
        assertNotNull(response.getTimestamp());
        assertTrue(response.getResponse().toLowerCase().contains("help") || 
                   response.getResponse().toLowerCase().contains("support"));
    }

    @Test
    void processMessage_GeneralMessage_ReturnsGeneralResponse() {
        // Given
        chatbotRequest.setMessage("Hello, how are you?");

        // When
        ChatbotResponse response = chatbotService.processMessage(chatbotRequest);

        // Then
        assertNotNull(response);
        assertNotNull(response.getResponse());
        assertNotNull(response.getTimestamp());
        assertTrue(response.getResponse().toLowerCase().contains("mental health"));
    }
}