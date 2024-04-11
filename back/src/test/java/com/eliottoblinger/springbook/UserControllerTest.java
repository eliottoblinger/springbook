package com.eliottoblinger.springbook;

import com.eliottoblinger.springbook.model.User;
import com.eliottoblinger.springbook.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.eliottoblinger.springbook.controller.UserController;
import com.eliottoblinger.springbook.dto.UserRequest;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetUserById() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("Test User");

        when(userService.getById(1L)).thenReturn(user);

        mockMvc.perform(get("/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("Test User"));
    }

    @Test
    public void testCreateUser() throws Exception {
        UserRequest request = new UserRequest();
        request.setUsername("New User");
        request.setReservations(Set.of());

        User newUser = new User();
        newUser.setId(1L);
        newUser.setUsername("New User");

        userService.save(newUser);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/users/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"New User\", \"reservations\": [] }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("New User"));


       verify(userService, times(1)).save(newUser);
    }

    @Test
    public void testUpdateUser() throws Exception {
        UserRequest request = new UserRequest();
        request.setUsername("Updated User");
        request.setReservations(Set.of());

        User user = new User();
        user.setId(1L);
        user.setUsername("Test User");

        when(userService.getById(1L)).thenReturn(user);

        mockMvc.perform(patch("/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"username\": \"Updated User\", \"reservations\": [] }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("Updated User"));
    }
}