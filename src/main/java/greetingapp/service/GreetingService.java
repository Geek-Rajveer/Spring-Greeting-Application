package greetingapp.service;

import greetingapp.dto.Greeting;
import greetingapp.entity.GreetingEntity;
import greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    // Method to save the Greeting to the database
    public String saveGreeting(Greeting greetingDto) {
        // Map the Greeting DTO to the GreetingEntity
        GreetingEntity greetingEntity = new GreetingEntity();
        greetingEntity.setFirstName(greetingDto.getName());  // Use the 'name' field for firstName

        // Save the GreetingEntity in the database
        greetingRepository.save(greetingEntity);

        return "{\"message\": \"Greeting saved for " + greetingDto.getName() + "\"}";
    }

    // Method to get a greeting message
    public String getGreetingMessage(String firstName, String lastName) {
        return "Hello, " + (firstName != null ? firstName : "World") + (lastName != null ? " " + lastName : "");
    }

    // Method to get a greeting message by ID
    public String getGreetingById(Long id) {
        Optional<GreetingEntity> greeting = greetingRepository.findById(id);
        if (greeting.isPresent()) {
            GreetingEntity greetingEntity = greeting.get();
            return "Hello, " + greetingEntity.getFirstName() + "!";
        } else {
            return "Greeting not found!";
        }
    }

    // Method to get all greetings from the repository
    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // Method to update a greeting message by ID
    public String updateGreeting(Long id, Greeting greetingDto) {
        Optional<GreetingEntity> greeting = greetingRepository.findById(id);

        if (greeting.isPresent()) {
            // Retrieve the existing GreetingEntity
            GreetingEntity greetingEntity = greeting.get();

            // Update the firstName and lastName with the new values
            greetingEntity.setFirstName(greetingDto.getName());  // Assuming 'name' is used for firstName

            // Save the updated entity back to the database
            greetingRepository.save(greetingEntity);

            return "{\"message\": \"Greeting updated for " + greetingDto.getName() + "\"}";
        } else {
            return "{\"message\": \"Greeting not found!\"}";
        }
    }

}
