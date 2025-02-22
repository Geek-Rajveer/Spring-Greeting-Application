package greetingapp.controller;

import greetingapp.dto.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    // GET Method: Returns a greeting message
    @GetMapping
    public String getGreeting() {
        return "{\"message\": \"Hello, world!\"}";
    }

    // POST Method: Accepts a name and returns a personalized greeting
    @PostMapping
    public String postGreeting(@RequestBody Greeting greeting) {
        return "{\"message\": \"Hello, " + greeting.getName() + "!\"}";
    }

    // PUT Method: Accepts a name and updates the greeting
    @PutMapping
    public String putGreeting(@RequestBody Greeting greeting) {
        return "{\"message\": \"Updated greeting for: " + greeting.getName() + "\"}";
    }


    // DELETE Method: Deletes a greeting and returns confirmation
    @DeleteMapping
    public String deleteGreeting() {
        return "{\"message\": \"Greeting deleted.\"}";
    }
}
