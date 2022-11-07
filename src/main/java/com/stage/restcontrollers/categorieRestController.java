package com.stage.restcontrollers;

import com.stage.entities.Categorie;
import com.stage.service.CategorieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class categorieRestController {

    private final CategorieServiceImpl service;

    @GetMapping("/categories")
    public ResponseEntity<List<Categorie>> getAllCategories()
    {
        return ResponseEntity.ok(service.getAllCategories());
    }

    @GetMapping("/categorie/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getCategorie(id));
    }

    @PostMapping("/ajoutCategorie")
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        Categorie savedCategorie = service.Ajouter(categorie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategorie);
    }

    @PutMapping("/modiferCategorie/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable(value = "id") Long idCategorie,
                                                     @RequestBody Categorie categorie) {
        Categorie updatingCategorie = service.Modifier(idCategorie, categorie);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatingCategorie);
    }

    @DeleteMapping("/supprimerCategorie/{id}")
    public ResponseEntity<Object> deleteCategorie(@PathVariable("id") Long id)
    {
        service.supprimerParId(id);
        return ResponseEntity.noContent().build();
    }
}
