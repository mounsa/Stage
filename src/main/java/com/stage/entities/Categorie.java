package com.stage.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Categorie  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCategorie;

    @Column(name = "designation")
    private String nomCategorie;

    @CreationTimestamp
    private Date dateCreationCategorie;

    @OneToMany(mappedBy = "categorie")
    private List<Documents> documents;


}
