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
import org.springframework.web.bind.annotation.RestController;

import fr.wijin.fiche.fiche.dto.FicheDto;
import fr.wijin.fiche.fiche.service.FicheService;
import jakarta.validation.Valid;

@RestController
public class FicheRestController {

    @Autowired
    private FicheService ficheService;

    @GetMapping(value = "/fiches/{id}", produces = { "application/json" })
    public ResponseEntity<FicheDto> getFicheRest(@PathVariable("id") Integer id) {
        FicheDto ficheDto = ficheService.findById(id).orElse(null);

        if (null == ficheDto) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ficheDto);
    }

    @GetMapping(value = "/fiches", produces = { "application/json" })
    public ResponseEntity<List<FicheDto>> getFichesRest() {
        List<FicheDto> fiches = ficheService.findAll();
        if (null == fiches) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(fiches);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/fiches", produces = { "application/json" }, consumes={ "application/json" })
    public ResponseEntity<FicheDto> postFicheRest(@Valid @RequestBody FicheDto ficheDto){
        FicheDto created = ficheService.save(ficheDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping(value = "/fiches/{id}" , produces = { "application/json" })
    public ResponseEntity<Void> deleteFicheRest(@PathVariable("id") Integer id) {

        FicheDto fiche = ficheService.findById(id).orElse(null);

        if (null == fiche) {

            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } else {

            ficheService.delete(ficheService.findById(id).orElse(null));
            return ResponseEntity.noContent().build();
        }

    }
}
