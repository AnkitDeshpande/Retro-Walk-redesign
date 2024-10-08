package com.retrowalk.repository;

import com.retrowalk.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing User data.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user
     * @return the User entity, or null if not found
     */
    User findByUsername(String username);
}
