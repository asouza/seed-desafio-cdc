package br.com.armando.decasadocodigo;

import br.com.armando.decasadocodigo.utils.DatabaseCleaner;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.BigRange;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.StringLength;
import net.jqwik.spring.JqwikSpringSupport;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@JqwikSpringSupport
@SpringBootTest
@AutoConfigureMockMvc
public class BooksControllerTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private MockMvc mockMvc;

    private Set<String> titles = new HashSet<>();
    private Set<String> isbns = new HashSet<>();

    private final String MIN_PUBLISH_DATE = LocalDate.now().toString();

    @Property(tries = 5)
    @Label("Fluxo de cadastro de um novo livro")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    void test1(
            @ForAll @AlphaChars @StringLength(min = 1, max = 60) String title,
            @ForAll @AlphaChars @StringLength(min = 1, max = 500) String summary,
            @ForAll @AlphaChars @StringLength(min = 1, max = 500) String index,
            @ForAll @BigRange(min = "20", max = "100") BigDecimal price,
            @ForAll @IntRange(min = 100, max = 600) Integer pages,
            @ForAll @AlphaChars @StringLength(min = 1, max = 60) String isbn
            ) throws Exception {
        Assumptions.assumeTrue(titles.add(title));
        Assumptions.assumeTrue(isbns.add(isbn));

        String payloadCategory = new ObjectMapper()
                .writeValueAsString(
                        Map.of("name", "Categoria")
                );
        MockHttpServletRequestBuilder content = MockMvcRequestBuilders.post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadCategory);
        mockMvc.perform(content);
        String payloadAuthor = new ObjectMapper()
                .writeValueAsString(
                        Map.of("name", "Armando", "email", "armando@email.com", "description", "descrição")
                );
        content = MockMvcRequestBuilders.post("/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadAuthor);
        mockMvc.perform(content);

        String payloadBook = new ObjectMapper()
                .writeValueAsString(
                        Map.of(
                                "title", title,
                                "summary", summary,
                                "index", index,
                                "price", price,
                                "pages", pages,
                                "isbn", isbn,
                                "publishDate", LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE),
                                "categoryId", "1",
                                "authorId", "1"
                        )
                );
        content = MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadBook);
        mockMvc.perform(content).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        mockMvc.perform(content).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    @DisplayName("Fluxo de listagem de livros")
    void test2() throws Exception {
        String payloadCategory = new ObjectMapper()
                .writeValueAsString(
                        Map.of("name", "Categoria")
                );
        MockHttpServletRequestBuilder content = MockMvcRequestBuilders.post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadCategory);
        mockMvc.perform(content);
        String payloadAuthor = new ObjectMapper()
                .writeValueAsString(
                        Map.of("name", "Armando", "email", "armando@email.com", "description", "descrição")
                );
        content = MockMvcRequestBuilders.post("/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadAuthor);
        mockMvc.perform(content);

        String payloadBook = new ObjectMapper()
                .writeValueAsString(
                        Map.of(
                                "title", "Titulo1",
                                "summary", "Resumo1",
                                "index", "indice1",
                                "price", "40",
                                "pages", "110",
                                "isbn", "ISBN1",
                                "publishDate", LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE),
                                "categoryId", "1",
                                "authorId", "1"
                        )
                );
        content = MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadBook);
        mockMvc.perform(content);
        payloadBook = new ObjectMapper()
                .writeValueAsString(
                        Map.of(
                                "title", "Titulo2",
                                "summary", "Resumo2",
                                "index", "indice2",
                                "price", "40",
                                "pages", "110",
                                "isbn", "ISBN2",
                                "publishDate", LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE),
                                "categoryId", "1",
                                "authorId", "1"
                        )
                );
        content = MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadBook);
        mockMvc.perform(content);

        content = MockMvcRequestBuilders.get("/books").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(content).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
    @Test
    @DisplayName("Deveria retornar status 400 para um livro que não existe")
    void test3() throws Exception {
        MockHttpServletRequestBuilder content = MockMvcRequestBuilders.get("/books/999").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(content).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    @DisplayName("Deve retornar 200 e o livro pesquisado")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    void test4() throws Exception {
        databaseCleaner.clearTables();

        Map<String, Object> mapCategory = Map.of("name", "Categoria");
        Map<String, Object> mapAuthor = Map.of("name", "Armando", "email", "armando@email.com", "description", "descrição");
        Map<String, Object> mapBook = Map.of(
                "title", "Titulo1",
                "summary", "Resumo1",
                "index", "indice1",
                "price", new BigDecimal(40),
                "pages", new BigDecimal(110),
                "isbn", "ISBN1",
                "publishDate", LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE),
                "categoryId", "1",
                "authorId", "1"
        );
        String expectedJson = new ObjectMapper()
                .writeValueAsString(
                        Map.of(
                                "title", "Titulo1",
                                "summary", "Resumo1",
                                "index", "indice1",
                                "price", new BigDecimal(40),
                                "pages", new BigDecimal(110),
                                "isbn", "ISBN1",
                                "publishDate", LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE),
                                "author", mapAuthor,
                                "category", mapCategory
                        )
                );

        String payloadCategory = new ObjectMapper()
                .writeValueAsString(
                        mapCategory
                );
        MockHttpServletRequestBuilder content = MockMvcRequestBuilders.post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadCategory);
        mockMvc.perform(content);
        String payloadAuthor = new ObjectMapper()
                .writeValueAsString(
                        mapAuthor
                );
        content = MockMvcRequestBuilders.post("/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadAuthor);
        mockMvc.perform(content);

        String payloadBook = new ObjectMapper()
                .writeValueAsString(
                        mapBook
                );
        content = MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadBook);
        mockMvc.perform(content);

        content = MockMvcRequestBuilders.get("/books/1").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(content).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        mockMvc.perform(content).andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

}
