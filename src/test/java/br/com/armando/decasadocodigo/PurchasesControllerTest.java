package br.com.armando.decasadocodigo;

import br.com.armando.decasadocodigo.utils.DatabaseCleaner;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.NumericChars;
import net.jqwik.api.constraints.StringLength;
import net.jqwik.spring.JqwikSpringSupport;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JqwikSpringSupport
@SpringBootTest
@AutoConfigureMockMvc
public class PurchasesControllerTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private MockMvc mockMvc;

    @Property(tries = 5)
    @Label("Cadastro de uma nova compra")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    void test1(
            @ForAll @AlphaChars @StringLength(min = 1, max = 50) String email,
            @ForAll @AlphaChars @StringLength(min = 1, max = 60) String name,
            @ForAll @AlphaChars @StringLength(min = 1, max = 60) String lasName,
            @ForAll @AlphaChars @StringLength(min = 1, max = 255) String address,
            @ForAll @AlphaChars @StringLength(min = 1, max = 255) String complement,
            @ForAll @NumericChars @StringLength(min = 8, max = 9) String phone,
            @ForAll @AlphaChars @StringLength(min = 8, max = 8) String cep
    ) throws Exception {
        databaseCleaner.clearTables();

        // cadastro de pais e estado
        String payloadCountry = new ObjectMapper()
                .writeValueAsString(
                        Map.of("name", "Country")
                );
        MockHttpServletRequestBuilder content = MockMvcRequestBuilders.post("/countries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadCountry);
        mockMvc.perform(content);
        String payloadState = new ObjectMapper()
                .writeValueAsString(
                        Map.of("name", "estado", "countryId", 1)
                );
        content = MockMvcRequestBuilders.post("/states")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadState);
        mockMvc.perform(content);

        // cadastro de livro
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
        String payloadCategory = new ObjectMapper()
                .writeValueAsString(
                        mapCategory
                );
        content = MockMvcRequestBuilders.post("/categories")
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

        // CADASTRO DE CUPOM
        String payloadCoupon = new ObjectMapper()
                .writeValueAsString(
                        Map.of("code", "CUPOM10", "percentage", 10, "expiresAt", LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE))
                );
        content = MockMvcRequestBuilders.post("/coupons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadCoupon);
        mockMvc.perform(content);

        // ITEM DO PEDIDO
        Map<String, Object> mapOrderItem = Map.of("bookId", 1, "quantity", 5);
        // PEDIDO
        Map<String, Object> mapOrder = Map.of("total", new BigDecimal(200), "items", List.of(mapOrderItem));
        // COMPRA
        HashMap<String, Object> mapPurchase = new HashMap<>();
        mapPurchase.put("email", email+"@email.com");
        mapPurchase.put("name", name);
        mapPurchase.put("lastName", lasName);
        mapPurchase.put("document", "42201968896");
        mapPurchase.put("address", address);
        mapPurchase.put("complement", complement);
        mapPurchase.put("countryId", 1);
        mapPurchase.put("stateId", 2);
        mapPurchase.put("phone", phone);
        mapPurchase.put("cep", cep);
        mapPurchase.put("order", mapOrder);
        mapPurchase.put("couponCode", "CUPOM10");
        String payloadPurchase = new ObjectMapper()
                .writeValueAsString(
                        mapPurchase
                );
        content = MockMvcRequestBuilders.post("/purchases")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadPurchase);
        mockMvc.perform(content).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

}
