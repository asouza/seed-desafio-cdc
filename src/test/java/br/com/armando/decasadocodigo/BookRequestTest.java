package br.com.armando.decasadocodigo;

import br.com.armando.decasadocodigo.api.model.request.BookRequest;
import br.com.armando.decasadocodigo.domain.model.Author;
import br.com.armando.decasadocodigo.domain.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookRequestTest {

    private BookRequest bookRequest = new BookRequest(
            "",
            "",
            "",
            BigDecimal.TEN,
            100,
            "",
            LocalDate.now(),
            1L,
            1L
    );

    @Test
    @DisplayName("Cria um livro quando categoria e autor já estão cadastrados.")
    void test1() {
        EntityManager manager = Mockito.mock(EntityManager.class);

        Mockito.when(manager.find(Category.class, 1L)).thenReturn(new Category(""));
        Mockito.when(manager.find(Author.class, 1L)).thenReturn(new Author("", "", ""));

        Assertions.assertNotNull(bookRequest.toModel(manager));
    }

    @Test
    @DisplayName("Não cria um livro quando categoria não existe")
    void test2() {
        EntityManager manager = Mockito.mock(EntityManager.class);

        Mockito.when(manager.find(Category.class, 1L)).thenReturn(null);
        Mockito.when(manager.find(Author.class, 1L)).thenReturn(new Author("", "", ""));

        Assertions.assertThrows(IllegalStateException.class, () -> {
            bookRequest.toModel(manager);
        });
    }

    @Test
    @DisplayName("Não cria um livro quando autor não existe")
    void test3() {
        EntityManager manager = Mockito.mock(EntityManager.class);

        Mockito.when(manager.find(Category.class, 1L)).thenReturn(new Category(""));
        Mockito.when(manager.find(Author.class, 1L)).thenReturn(null);

        Assertions.assertThrows(IllegalStateException.class, () -> {
            bookRequest.toModel(manager);
        });
    }

}
