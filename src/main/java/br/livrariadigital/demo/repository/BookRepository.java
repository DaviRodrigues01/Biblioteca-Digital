package br.livrariadigital.demo.repository;
import br.livrariadigital.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
}