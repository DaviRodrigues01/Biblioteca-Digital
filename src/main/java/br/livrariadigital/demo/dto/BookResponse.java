package br.livrariadigital.demo.dto;
import lombok.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private LocalDate publicationDate;
    private Integer pages;
    private String language;
    private String category;
    private String description;
    private Integer totalCopies;
    private Integer availableCopies;
}