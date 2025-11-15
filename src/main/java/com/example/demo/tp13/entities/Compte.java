
// Entity class for Compte (Account)
package com.example.demo.tp13.entities;

import com.example.demo.tp13.enums.TypeCompte;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

// JPA Entity
@Entity
// Lombok annotation for getters/setters
@Data
// Lombok annotation for no-args constructor
@NoArgsConstructor
// Lombok annotation for all-args constructor
@AllArgsConstructor
// JAXB annotation for XML root
@XmlRootElement
// JAXB annotation for XML accessor type
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte {
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Account balance
    private double solde;

    // Date of account creation
    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    // Type of account (enum)
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
}