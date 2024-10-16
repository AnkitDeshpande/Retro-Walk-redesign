package com.retrowalk.repository;

import com.retrowalk.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

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

    /**
     * Checks if a user exists by their username.
     *
     * @param username the username to check
     * @return true if the user exists, false otherwise
     */
    boolean existsByUsername(String username);

    /**
     * Checks if a user exists by their email.
     *
     * @param email the email to check
     * @return true if the user exists, false otherwise
     */
    boolean existsByEmail(String email);

    /**
     * Finds a user by their email.
     *
     * @param email the email of the user
     * @return an Optional containing the User entity, or empty if not found
     */
    Optional<User> findByEmail(String email);
}
