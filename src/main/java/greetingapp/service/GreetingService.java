package greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    // Method to return the simple greeting message
    public String getGreetingMessage() {
        return "{\"message\": \"Hello, world!\"}";
    }
}
