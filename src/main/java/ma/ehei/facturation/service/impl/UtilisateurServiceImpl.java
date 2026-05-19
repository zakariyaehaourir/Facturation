package ma.ehei.facturation.service.impl;

import ma.ehei.facturation.dto.transaction.UserInTransactionDto;
import ma.ehei.facturation.model.Utilisateur;
import ma.ehei.facturation.repositoy.UtilisateurRepository;
import ma.ehei.facturation.repositoy.impl.UtilisateurRepositoryImpl;
import ma.ehei.facturation.service.UtilisateurService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository us){
        this.utilisateurRepository=us;
    }

    @Override
    public Utilisateur saveUser(Utilisateur t) {
        {
            return findByNomAndPrenom(t.getNom(), t.getPrenom())
                    .orElseGet(() -> saveUser(
                            Utilisateur.builder()
                                    .nom(t.getNom())
                                    .prenom(t.getPrenom())
                                    .build()
                    ));
        }
    }

    @Override
    public Optional<Utilisateur> findByNomAndPrenom(String nom, String prenom) {
        return this.utilisateurRepository.findByNomAndPrenom(nom, prenom);
    }
}
