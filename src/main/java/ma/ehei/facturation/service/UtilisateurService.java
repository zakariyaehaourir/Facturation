package ma.ehei.facturation.service;

import ma.ehei.facturation.model.Transaction;
import ma.ehei.facturation.model.Utilisateur;

import java.util.Optional;

public interface UtilisateurService {

    Utilisateur saveUser(Utilisateur t);

    Optional<Utilisateur> findByNomAndPrenom(String nom, String prenom);


}
