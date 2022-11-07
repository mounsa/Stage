package com.stage.service;

import com.stage.dao.CategorieRepository;
import com.stage.entities.Categorie;
import com.stage.exception.RestException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CategorieServiceImpl implements ICategorieService{
    private final CategorieRepository categorieRepository;

    @Override
    public Categorie Ajouter(Categorie categorie) {
       Categorie existingCategorie = categorieRepository.findCategorieByName(categorie.getNomCategorie().toLowerCase());
        if(existingCategorie != null) {
            throw new RestException("Une categorie avec le meme nom existe deja!", HttpStatus.CONFLICT);
        }
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie Modifier(Long id,Categorie categorie) {
        Categorie updatingCategorie = getCategorie(id);
        updatingCategorie.setNomCategorie(categorie.getNomCategorie());
        updatingCategorie.setDateCreationCategorie(categorie.getDateCreationCategorie());
        return categorieRepository.save(updatingCategorie);
    }



    @Override
    public void supprimerParId(Long id) {
        Categorie deletingCategorie= getCategorie(id);
        categorieRepository.delete(deletingCategorie);
    }

    @Override
    public Categorie getCategorie(Long id) {
        Categorie existingCategorie =  categorieRepository.findById(id)
                .orElseThrow(() -> new RestException("La categorie recherchée n'existe pas", HttpStatus.NOT_FOUND));
        return existingCategorie;
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }
}
