package com.stage.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Documents implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idProcedure;


    @Column(name = "nomProcedure")
    private String nomProcedure;

    @Column(name = "nomDocument")
    private String nomDocument;

    @Column(name = "version")
    private String version;

    @Column(name = "refference")
    private String refference;

    @Column(name = "statut")
    private Boolean statut;

    @CreationTimestamp
    private Date dateCreationProcdure;

   @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;

}
