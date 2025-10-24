package br.livrariadigital.demo.controller;
import br.livrariadigital.demo.dto.BookRequest;
import br.livrariadigital.demo.dto.BookResponse;
import br.livrariadigital.demo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService svc;
    public BookController(BookService svc) { this.svc = svc; }
    @GetMapping
    public List<BookResponse> getAll() { return svc.findAll(); }
    @GetMapping("/{id}")
    public BookResponse getById(@PathVariable Long id) { return svc.findById(id); }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse create(@Valid @RequestBody BookRequest request) { return svc.create(request); }
    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id, @Valid @RequestBody BookRequest request) { return svc.update(id, request); }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { svc.delete(id); }
}