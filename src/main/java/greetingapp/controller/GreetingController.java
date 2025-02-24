package greetingapp.controller;

import greetingapp.dto.Greeting;
import greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    // GET Method: Returns a greeting message (using optional firstName and lastName params)
    @GetMapping
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
    }

    // POST Method: Accepts a name and saves the greeting in the database
    @PostMapping
    public String postGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting);
    }

    // PUT Method: Accepts a name and updates the greeting (you can modify this later)
    @PutMapping
    public String putGreeting(@RequestBody Greeting greeting) {
        return "{\"message\": \"Updated greeting for: " + greeting.getName() + "\"}";
    }

    // DELETE Method: Deletes a greeting and returns confirmation (you can implement actual delete logic)
    @DeleteMapping
    public String deleteGreeting() {
        return "{\"message\": \"Greeting deleted.\"}";
    }
}
