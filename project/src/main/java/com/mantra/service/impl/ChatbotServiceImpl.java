package com.mantra.service.impl;

import com.mantra.dto.chatbot.ChatbotRequest;
import com.mantra.dto.chatbot.ChatbotResponse;
import com.mantra.service.ChatbotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ChatbotServiceImpl implements ChatbotService {

    @Override
    public ChatbotResponse processMessage(ChatbotRequest request) {
        // This is a placeholder implementation
        // In a real application, you would integrate with OpenAI API or another AI service
        String response = generateMentalHealthResponse(request.getMessage());
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        
        return new ChatbotResponse(response, timestamp);
    }

    private String generateMentalHealthResponse(String message) {
        // Simple rule-based responses for demonstration
        // In production, this would be replaced with actual AI integration
        String lowerMessage = message.toLowerCase();
        
        if (lowerMessage.contains("stress") || lowerMessage.contains("stressed")) {
            return "I understand you're feeling stressed. Here are some techniques that might help: " +
                   "1. Take deep breaths - inhale for 4 counts, hold for 4, exhale for 4. " +
                   "2. Try progressive muscle relaxation. " +
                   "3. Consider taking a short walk or doing light exercise. " +
                   "Remember, it's okay to feel stressed sometimes. If these feelings persist, consider speaking with a mental health professional.";
        } else if (lowerMessage.contains("anxiety") || lowerMessage.contains("anxious")) {
            return "Anxiety can be challenging, but there are ways to manage it: " +
                   "1. Ground yourself using the 5-4-3-2-1 technique (5 things you can see, 4 you can touch, 3 you can hear, 2 you can smell, 1 you can taste). " +
                   "2. Practice mindfulness or meditation. " +
                   "3. Challenge negative thoughts with evidence-based thinking. " +
                   "You're not alone in this. Professional support is available if you need it.";
        } else if (lowerMessage.contains("sad") || lowerMessage.contains("depressed")) {
            return "I'm sorry you're feeling this way. Your feelings are valid. Some things that might help: " +
                   "1. Reach out to someone you trust. " +
                   "2. Engage in activities you usually enjoy, even if they don't feel appealing right now. " +
                   "3. Maintain a regular sleep schedule and eat nutritious meals. " +
                   "If these feelings persist or worsen, please consider speaking with a mental health professional.";
        } else if (lowerMessage.contains("help") || lowerMessage.contains("support")) {
            return "I'm here to support you. You can explore our meditation resources, book a session with one of our therapists, " +
                   "or connect with our community forum. Remember, seeking help is a sign of strength, not weakness.";
        } else {
            return "Thank you for sharing with me. Mental health is important, and I'm here to support you. " +
                   "Can you tell me more about what's on your mind? I'm here to listen and provide helpful resources.";
        }
    }
}