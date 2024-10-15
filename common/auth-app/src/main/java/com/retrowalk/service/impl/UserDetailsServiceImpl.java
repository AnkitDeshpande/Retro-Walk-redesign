package com.retrowalk.service.impl;

import com.retrowalk.dto.requestDto.AddressRequestDto;
import com.retrowalk.entities.Address;
import com.retrowalk.entities.User;
import com.retrowalk.exception.RetrowalkException;
import com.retrowalk.models.AddressRequest;
import com.retrowalk.models.request.SignUpRequest;
import com.retrowalk.repository.UserRepository;
import com.retrowalk.service.UserService;
import com.retrowalk.utility.Mapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Implementation of the {@link UserDetailsService} interface to load user-specific data.
 * This service fetches user details from the database.
 */

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;

    private final Mapper mapper = new Mapper();

    /**
     * Loads user details by username.
     *
     * @param username the username of the user
     * @return UserDetails object containing user information
     * @throws UsernameNotFoundException if the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return user;
    }

    /**
     * Registers a new user.
     *
     * @param signUpRequest the sign-up request data transfer object
     * @return the registered User
     */
    @Override
    @Transactional
    public User saveUser(SignUpRequest signUpRequest) {
        User userToSave;

        if (Objects.nonNull(signUpRequest.getId())) {

            userToSave = userRepository.findById(signUpRequest.getId())
                    .orElseThrow(() -> new RetrowalkException(404, "User not found with ID: " + signUpRequest.getId()));

        } else {

            if (userRepository.existsByUsername(signUpRequest.getUsername())) {
                throw new RetrowalkException(500, "User already exists with the username: " + signUpRequest.getUsername());
            }

            if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                throw new RetrowalkException(500, "Email already in use: " + signUpRequest.getEmail());
            }

            userToSave = new User();
        }

        userToSave.setUsername(signUpRequest.getUsername());
        userToSave.setEmail(signUpRequest.getEmail());
        userToSave.setFirstName(signUpRequest.getFirstName());
        userToSave.setLastName(signUpRequest.getLastName());
        userToSave.setPhoneNumber(signUpRequest.getPhoneNumber());
        userToSave.setDateOfBirth(signUpRequest.getDateOfBirth());
        userToSave.setProfilePictureUrl(signUpRequest.getProfilePictureUrl());

        User savedUser = userRepository.save(userToSave);

        if (Objects.nonNull(signUpRequest.getAddresses())) {
            Set<Address> existingAddresses = new HashSet<>(savedUser.getAddresses());

            for (AddressRequest addressDTO : signUpRequest.getAddresses()) {
                if (addressDTO.getId() != null) {
                    Address existingAddress = existingAddresses.stream()
                            .filter(address -> address.getId().equals(addressDTO.getId()))
                            .findFirst()
                            .orElseThrow(() -> new RetrowalkException(404, "Address not found"));

                    existingAddress.setStreet(addressDTO.getStreet());
                    existingAddress.setCity(addressDTO.getCity());
                    existingAddress.setState(addressDTO.getState());
                    existingAddress.setCountry(addressDTO.getCountry());
                    existingAddress.setZipCode(addressDTO.getZipCode());

                    existingAddresses.remove(existingAddress);
                    savedUser.getAddresses().add(existingAddress);
                } else {
                    Address newAddress = mapper.convert(addressDTO, Address.class);
                    newAddress.setUser(savedUser);
                    savedUser.getAddresses().add(newAddress);
                }
            }

            for (Address addressToRemove : existingAddresses) {
                savedUser.getAddresses().remove(addressToRemove);
            }
        }

        return userRepository.save(savedUser);
    }
}
