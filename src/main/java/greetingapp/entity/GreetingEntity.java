package greetingapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GreetingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate ID
    private Long id;
    private String firstName;  // Used for storing the name

    // Getter and Setter for 'id' and 'firstName'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
