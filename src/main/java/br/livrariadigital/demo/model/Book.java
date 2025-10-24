package br.livrariadigital.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @Column(unique = true)
    private String isbn;
    private String publisher;
    private LocalDate publicationDate;
    private Integer pages;
    private String language;
    private String category;
    @Column(length = 2000)
    private String description;
    @NotNull
    private Integer totalCopies = 1;
    @NotNull
    private Integer availableCopies = 1;
}