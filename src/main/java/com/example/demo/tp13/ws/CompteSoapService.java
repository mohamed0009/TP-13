
// SOAP Web Service for Compte operations
package com.example.demo.tp13.ws;

import com.example.demo.tp13.entities.Compte;
import com.example.demo.tp13.enums.TypeCompte;
import com.example.demo.tp13.repositories.CompteRepository;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component // Spring component
@WebService(serviceName = "BanqueWS") // SOAP web service
public class CompteSoapService {

    // Inject CompteRepository
    @Autowired
    private CompteRepository compteRepository;

    // Get all accounts
    @WebMethod
    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }

    // Get account by ID
    @WebMethod
    public Compte getCompteById(@WebParam(name = "id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    // Create a new account
    @WebMethod
    public Compte createCompte(@WebParam(name = "solde") double solde,
            @WebParam(name = "type") TypeCompte type) {
        Compte compte = new Compte(null, solde, new Date(), type);
        return compteRepository.save(compte);
    }

    // Delete account by ID
    @WebMethod
    public boolean deleteCompte(@WebParam(name = "id") Long id) {
        if (compteRepository.existsById(id)) {
            compteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}