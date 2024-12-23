package cryss.dev.author_api.application.adapters.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cryss.dev.author_api.domain.adapters.services.CreateNewAuthorSpring;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.model.AuthorResponse;
import org.openapitools.model.NewAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthorController.class)
class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;


    @MockBean
    private CreateNewAuthorSpring service;

    private MockHttpServletRequest request;

    @BeforeEach
    public void setup(){
        this.request = new MockHttpServletRequest ();
        this.request.setScheme("http");
        this.request.setServerName("localhost");
        this.request.setServerPort(-1);
        this.request.setRequestURI("/");
        this.request.setContextPath("/v1/api");
    }

    @Test
    void create_whenInvalidNewAuthor_willFail() throws JsonProcessingException, Exception {

        //Given /Arrange
        NewAuthor author = NewAuthor.builder ().build ();

        given (service.create (any (NewAuthor.class))).
                willAnswer ((invocation -> invocation.getArgument (0)));

        // When /Act
        ResultActions response =
                mockMvc
                        .perform (post ("/author")
                                .contentType (MediaType.APPLICATION_JSON)
                                .content (mapper.writeValueAsString (author)));


        // Then /Assert
        response.andDo (print ())
                .andExpect (status ().isBadRequest ());
    }

    @Test
    void create_whenValidNewAuthor_willSuccess() throws JsonProcessingException, Exception {

        //Given /Arrange
        NewAuthor author = NewAuthor
                .builder ()
                .name ("teste")
                .email ("teste@meil.com")
                .description ("description de teste")
                .build ();

        AuthorResponse authorResponse =
                AuthorResponse
                        .builder ()
                        .id (1L)
                        .name ("teste")
                        .email ("teste@meil.com")
                        .build ();

        when (service.create (any (NewAuthor.class))).thenReturn (authorResponse);

        // When /Act
        ResultActions response =
                mockMvc
                        .perform (post ("/author")
                                .contentType (MediaType.APPLICATION_JSON)
                                .content (mapper.writeValueAsString (author)));


        // Then /Assert
        response.andDo (print ())
                .andExpect (status ().isOk ())
                .andExpect (jsonPath ("$.name", is (authorResponse.getName ())))
                .andExpect (jsonPath ("$.email", is (authorResponse.getEmail ())));

    }

}