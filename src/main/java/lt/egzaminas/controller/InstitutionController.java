package lt.egzaminas.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lt.egzaminas.model.InstitutionBook;

@RestController
public class InstitutionController {

    private final Map<String, Set<InstitutionBook>> booksByInstitution;

    public InstitutionController() {
        this.booksByInstitution = new ConcurrentHashMap<>();
    }

    @GetMapping("/api/{institution}/books")
    public List<InstitutionBook> getInstitutionBooks(@PathVariable String institutionTitle) {
        return new ArrayList<>(booksByInstitution.getOrDefault(institutionTitle, new LinkedHashSet<>()));
    }

    @PostMapping("/api/{institution}/books")
    public List<InstitutionBook> addInstitutionBook(@PathVariable String institutionTitle, @RequestBody InstitutionBook institutionBook) {
        Set<InstitutionBook> existingBooks = booksByInstitution.getOrDefault(institutionTitle, new LinkedHashSet<>());
        existingBooks.add(institutionBook);
        booksByInstitution.put(institutionTitle, existingBooks);
        return getInstitutionBooks(institutionTitle);
    }

    @DeleteMapping("/api/{institution}/books/{bookId}")
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
