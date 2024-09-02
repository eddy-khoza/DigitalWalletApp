package com.example.DigitalWalletApp.controller;

import com.example.DigitalWalletApp.model.User;
import com.example.DigitalWalletApp.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRegisterUser() throws Exception {
        String userJson = "{ \"username\": \"testUser\", \"email\": \"test@example.com\", \"password\": \"password\" }";

        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void testLoginUser() throws Exception {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password");
        userRepository.save(user);

        mockMvc.perform(post("/api/users/login")
                        .param("username", "testUser")
                        .param("password", "password"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("testUser"))
                .andDo(print());
    }
}
