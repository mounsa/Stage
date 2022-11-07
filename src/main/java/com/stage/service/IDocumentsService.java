package com.stage.service;

import com.stage.entities.Categorie;
import com.stage.entities.Documents;

import java.util.List;

public interface IDocumentsService {
    Documents Ajouter(Documents documents);
    Documents Modifier(Long id,Documents documents);
    List<Documents> listeDocuments();
    Documents visualiser(Long id);
    void supprimer(Long id);
    void Archiver(Long id);
}
