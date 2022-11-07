package com.stage.service;

import com.stage.entities.Categorie;

import java.util.List;

public interface ICategorieService {
    Categorie Ajouter(Categorie categorie);
    Categorie Modifier(Long id,Categorie categorie);

    void supprimerParId(Long id);
    Categorie getCategorie(Long id);
    List<Categorie> getAllCategories();
}
