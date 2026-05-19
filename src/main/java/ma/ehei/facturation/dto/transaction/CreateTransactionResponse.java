package ma.ehei.facturation.dto.transaction;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionResponse {
    private Long id;

    @Min(value = 1 , message = "Le montant doit étre positive ")
    private Double montantAvant;
    private Double montantApres;
    private LocalDateTime date;

}
