package ma.ehei.facturation.repositoy;

import ma.ehei.facturation.model.Transaction;
import ma.ehei.facturation.model.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository {
    public Utilisateur save(Utilisateur t);
    Optional<Utilisateur> findByNomAndPrenom(String nom, String prenom);
}
