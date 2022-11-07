package com.stage.service;

import com.stage.dao.DocumentsRepository;
import com.stage.entities.Categorie;
import com.stage.entities.Documents;
import com.stage.exception.RestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentsServiceImpl implements IDocumentsService {

    private final DocumentsRepository documentsRepository;

    @Override
    public Documents Ajouter(Documents documents) {
        return documentsRepository.save(documents);
    }

    @Override
    public Documents Modifier(Long id, Documents documents) {
        Documents updatingDocument = visualiser(id);
        updatingDocument.setNomProcedure(documents.getNomProcedure());
        updatingDocument.setNomDocument(documents.getNomProcedure());
        updatingDocument.setRefference(documents.getRefference());
        updatingDocument.setVersion(documents.getVersion());
        return documentsRepository.save(updatingDocument);
    }

    @Override
    public List<Documents> listeDocuments() {
        return documentsRepository.findAll();
    }

    @Override
    public Documents visualiser(Long id) {
        Documents existingDocument =  documentsRepository.findById(id)
                .orElseThrow(() -> new RestException("La procedure recherchée n'existe pas", HttpStatus.NOT_FOUND));
        return existingDocument;
    }

    @Override
    public void supprimer(Long id) {
        Documents deletingProcedure = visualiser(id);
        documentsRepository.delete(deletingProcedure);
    }

    @Override
    public void Archiver(Long id) {
        Documents archiveProcedure = visualiser(id);
        archiveProcedure.setStatut(true);
        documentsRepository.save(archiveProcedure);
    }
}
