package br.livrariadigital.demo.service;
import br.livrariadigital.demo.dto.BookRequest;
import br.livrariadigital.demo.dto.BookResponse;
import br.livrariadigital.demo.exception.ResourceNotFoundException;
import br.livrariadigital.demo.model.Book;
import br.livrariadigital.demo.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookService {
    private final BookRepository repo;
    public BookService(BookRepository repo) { this.repo = repo; }
    public List<BookResponse> findAll() {
        return repo.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }
    public BookResponse findById(Long id) {
        Book b = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        return toResponse(b);
    }
    public BookResponse create(BookRequest request) {
        Book book = toEntity(request);
        Book saved = repo.save(book);
        return toResponse(saved);
    }
    public BookResponse update(Long id, BookRequest request) {
        Book existing = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        existing.setTitle(request.getTitle());
        existing.setAuthor(request.getAuthor());
        existing.setIsbn(request.getIsbn());
        existing.setPublisher(request.getPublisher());
        existing.setPublicationDate(request.getPublicationDate());
        existing.setPages(request.getPages());
        existing.setLanguage(request.getLanguage());
        existing.setCategory(request.getCategory());
        existing.setDescription(request.getDescription());
        existing.setTotalCopies(request.getTotalCopies());
        existing.setAvailableCopies(request.getAvailableCopies());
        Book updated = repo.save(existing);
        return toResponse(updated);
    }
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Book not found with id: " + id);
        repo.deleteById(id);
    }
    private BookResponse toResponse(Book b) {
        return BookResponse.builder()
                .id(b.getId()).title(b.getTitle()).author(b.getAuthor()).isbn(b.getIsbn())
                .publisher(b.getPublisher()).publicationDate(b.getPublicationDate())
                .pages(b.getPages()).language(b.getLanguage()).category(b.getCategory())
                .description(b.getDescription()).totalCopies(b.getTotalCopies())
                .availableCopies(b.getAvailableCopies()).build();
    }
    private Book toEntity(BookRequest r) {
        return Book.builder()
                .title(r.getTitle()).author(r.getAuthor()).isbn(r.getIsbn())
                .publisher(r.getPublisher()).publicationDate(r.getPublicationDate())
                .pages(r.getPages()).language(r.getLanguage()).category(r.getCategory())
                .description(r.getDescription()).totalCopies(r.getTotalCopies())
                .availableCopies(r.getAvailableCopies()).build();
    }
}