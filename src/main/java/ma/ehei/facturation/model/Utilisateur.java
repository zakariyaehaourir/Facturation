package ma.ehei.facturation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Utilisateur {

    private Long id;
    private String nom;
    private String prenom;
}
