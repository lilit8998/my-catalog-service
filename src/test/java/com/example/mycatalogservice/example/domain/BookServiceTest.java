package com.example.mycatalogservice.example.domain;

import com.example.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void whenBookToCreateAlreadyExistsThenThrows() {
        var bookIsbn = "1234561232";
        var bookToCreate = new Book(bookIsbn, "Title", "Author", 9.90);
        when(bookRepository.existsByIsbn(bookIsbn)).thenReturn(true);
        assertThatThrownBy(() -> bookService.addBookToCatalog(bookToCreate))
                .isInstanceOf(BookAlreadyExistsException.class)
                .hasMessageEndingWith("already exists"); // Adjusted assertion
    }

    @Test
    void whenBookToReadDoesNotExistThenThrows() {
        var bookIsbn = "1234561232";
        when(bookRepository.findByIsbn(anyString())).thenReturn(Optional.empty());
        assertThatThrownBy(() -> bookService.viewBookDetails(bookIsbn))
                .isInstanceOf(BookNotFoundException.class)
                .hasMessageEndingWith("was not found"); // Adjusted assertion
    }

}
