package fr.wijin.fiche.fiche.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.wijin.fiche.fiche.dto.CategorieDto;
import fr.wijin.fiche.fiche.service.CategorieService;
import jakarta.validation.Valid;

public class CategorieRestController {
    

    @Autowired
    private CategorieService categorieService;

    @GetMapping(value = "/categories/{id}", produces = { "application/json" })
    public ResponseEntity<CategorieDto> getFicheRest(@PathVariable("id") Integer id) {
        CategorieDto categorieDto = categorieService.findById(id).orElse(null);

        if (null == categorieDto) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categorieDto);
    }

    @GetMapping(value = "/categories", produces = { "application/json" })
    public ResponseEntity<List<CategorieDto>> getFichesRest() {
        List<CategorieDto> categories = categorieService.findAll();
        if (null == categories) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/categories", produces = { "application/json" }, consumes = { "application/json" })
    public ResponseEntity<CategorieDto> postFicheRest(@Valid @RequestBody CategorieDto categorieDto) {
        CategorieDto created = categorieService.save(categorieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/categories/{id}", produces = { "application/json" })
    public ResponseEntity<Void> deleteFicheRest(@PathVariable("id") Integer id) {

        CategorieDto categorie = categorieService.findById(id).orElse(null);

        if (null == categorie) {

            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } else {

            categorieService.delete(categorieService.findById(id).orElse(null));
            return ResponseEntity.noContent().build();
        }

    }
}
