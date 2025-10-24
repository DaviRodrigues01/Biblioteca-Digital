package br.livrariadigital.demo.config;
import br.livrariadigital.demo.model.Book;
import br.livrariadigital.demo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.List;
@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initDatabase(BookRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                List<Book> seeds = List.of(
                        Book.builder().title("O Pequeno Príncipe").author("Antoine de Saint-Exupéry").isbn("978014312").publisher("Publisher A").publicationDate(LocalDate.of(1943,4,6)).pages(96).language("Português").category("Ficção").description("Clássico").totalCopies(5).availableCopies(5).build()
                );
                repo.saveAll(seeds);
            }
        };
    }
}