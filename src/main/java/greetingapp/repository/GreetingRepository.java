package greetingapp.repository;

import greetingapp.entity.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<GreetingEntity, Long> {
    // The repository will provide standard CRUD methods (e.g., save, findAll, findById)
}
