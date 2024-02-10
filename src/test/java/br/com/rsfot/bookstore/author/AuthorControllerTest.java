package br.com.rsfot.bookstore.author;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthorControllerTest {
    private AuthorRepository authorRepository;
    private AuthorController authorController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        authorRepository = mock(AuthorRepository.class);
        authorController = new AuthorController(authorRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();
    }

    @Test
    @DisplayName("api s")
    void create__should_return_bad_request_when_email_is_duplicated() throws Exception {
        String authorJson = """
                {
                    "name": "Author Name",
                    "email": "duplicatedemail@gmail.com"
                }
                """;

        Mockito.when(authorRepository.existsByEmail("duplicatedemail@gmail.com"))
                .thenReturn(true);

        mockMvc.perform(post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson))
                .andExpect(status().isBadRequest());
    }
}