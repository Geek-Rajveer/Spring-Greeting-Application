package greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    // Method to return the appropriate greeting message based on input
    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "{\"message\": \"Hello, " + firstName + " " + lastName + "!\"}";
        } else if (firstName != null) {
            return "{\"message\": \"Hello, " + firstName + "!\"}";
        } else if (lastName != null) {
            return "{\"message\": \"Hello, Mr/Ms " + lastName + "!\"}";
        } else {
            return "{\"message\": \"Hello, world!\"}";
        }
    }
}
