package ma.ehei.facturation.dto.transaction;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Size;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInTransactionDto {

    @NotBlank(message = "nom est obligatoire")
    private String nom;
    @NotBlank(message = "prenom est obligatoire")

    private String prenom;
}
