package br.livrariadigital.demo.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    private String isbn;
    private String publisher;
    private LocalDate publicationDate;
    private Integer pages;
    private String language;
    private String category;
    private String description;
    @NotNull
    private Integer totalCopies;
    @NotNull
    private Integer availableCopies;
}