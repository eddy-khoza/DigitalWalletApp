package com.example.DigitalWalletApp.service;

import com.example.DigitalWalletApp.model.User;
import com.example.DigitalWalletApp.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setPassword("password");

        when(userRepository.save(user)).thenReturn(user);

        User registeredUser = userService.registerUser(user);

        assertEquals(user.getUsername(), registeredUser.getUsername());
        assertEquals(user.getEmail(), registeredUser.getEmail());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testLoginUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password");

        when(userRepository.findByUsername("testUser")).thenReturn(user);

        User loggedInUser = userService.loginUser("testUser", "password");

        assertEquals(user.getUsername(), loggedInUser.getUsername());
        verify(userRepository, times(1)).findByUsername("testUser");
    }
}
