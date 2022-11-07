package com.stage.dao;

import com.stage.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface CategorieRepository extends JpaRepository<Categorie,Long> {

    @Query("select c from Categorie c where lower(c.nomCategorie) =:nomCategorie")
    Categorie findCategorieByName(String nomCategorie);

    /*@Query("select c from Produit c order by c.nomCategorie ASC")
    List<Categorie> trierProduitsNomsPrix ();*/
}
