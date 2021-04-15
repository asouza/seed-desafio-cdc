package br.com.armando.decasadocodigo;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.StringLength;
import net.jqwik.spring.JqwikSpringSupport;
import org.junit.jupiter.api.Assumptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@JqwikSpringSupport
@SpringBootTest
@AutoConfigureMockMvc
public class CouponsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Set<String> codes = new HashSet<>();

    @Property(tries = 10)
    @Label("Fluxo de cadastro de um novo cupom")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    void test1(
            @ForAll @AlphaChars @StringLength(min = 1, max = 60) String code,
            @ForAll @IntRange(min = 1, max = 99) Integer percentage
    ) throws Exception {
        Assumptions.assumeTrue(codes.add(code));

        String payload = new ObjectMapper()
                .writeValueAsString(
                        Map.of("code", code, "percentage", percentage, "expiresAt", LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE))
                );

        MockHttpServletRequestBuilder content = MockMvcRequestBuilders.post("/coupons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        mockMvc.perform(content).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
        mockMvc.perform(content).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
