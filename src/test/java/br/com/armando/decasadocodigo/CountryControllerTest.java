package br.com.armando.decasadocodigo;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.StringLength;
import net.jqwik.spring.JqwikSpringSupport;
import org.junit.jupiter.api.Assumptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@JqwikSpringSupport
@SpringBootTest
@AutoConfigureMockMvc
public class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Set<String> uniqueNames = new HashSet<>();

    @Property(tries = 5)
    @Label("Cadastro de um novo país")
    void test1(@ForAll @AlphaChars @StringLength(min = 1, max = 255) String name) throws Exception {
        Assumptions.assumeTrue(uniqueNames.add(name));

        String payload = new ObjectMapper()
                .writeValueAsString(
                        Map.of("name", name)
                );

        MockHttpServletRequestBuilder content = MockMvcRequestBuilders.post("/countries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        mockMvc.perform(content).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        mockMvc.perform(content).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

}
