package com.stage.dao;

import com.stage.entities.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocumentsRepository extends JpaRepository<Documents,Long> {

    @Query("select d from Documents d where d.nomProcedure =:nomProcedure")
    Documents findProcedureByName(String nomProcedure);
}
