package lt.egzaminas.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lt.egzaminas.model.Book;
import lt.egzaminas.model.Institution;
import lt.egzaminas.model.InstitutionBook;
import lt.egzaminas.model.NewBook;
import lt.egzaminas.model.NewInstitution;
import lt.egzaminas.repository.BookRepository;
import lt.egzaminas.repository.InstitutionRepository;

@RestController
public class InstitutionController {

    @Autowired
    private InstitutionRepository repository;
	
    private final Map<String, Set<InstitutionBook>> booksByInstitution;

    public InstitutionController() {
        this.booksByInstitution = new ConcurrentHashMap<>();
    }
    
    @GetMapping("/api/institutions")
    public List<Institution> getInstitutions() {
        return repository.getInstitutions();
    }
    @PostMapping("/api/institutions")
    public Institution createInstitution(@RequestBody NewInstitution i) {
        return repository.addInstitution(i);
    }
    @GetMapping("/api/institutions/{institution}/books")
    public List<InstitutionBook> getInstitutionBooks(@PathVariable String institutionTitle) {
        return new ArrayList<>(booksByInstitution.getOrDefault(institutionTitle, new LinkedHashSet<>()));
    }

    @PostMapping("/api/institutions/{institution}/books")
    public List<InstitutionBook> addInstitutionBook(@PathVariable String institutionTitle, @RequestBody InstitutionBook institutionBook) {
        Set<InstitutionBook> existingBooks = booksByInstitution.getOrDefault(institutionTitle, new LinkedHashSet<>());
        existingBooks.add(institutionBook);
        booksByInstitution.put(institutionTitle, existingBooks);
        return getInstitutionBooks(institutionTitle);
    }

    @DeleteMapping("/api/institutions/{institution}/books/{bookId}")
    public List<InstitutionBook> removeFromInstitution(@PathVariable String institutionTitle, @PathVariable Long productId) {
        Set<InstitutionBook> existingBooks = booksByInstitution.getOrDefault(institutionTitle, new LinkedHashSet<>());
        existingBooks = existingBooks
                .stream()
                .filter(c -> !c.id.equals(productId))
                .collect(Collectors.toSet());
        booksByInstitution.put(institutionTitle, existingBooks);
        return getInstitutionBooks(institutionTitle);
    }
}
