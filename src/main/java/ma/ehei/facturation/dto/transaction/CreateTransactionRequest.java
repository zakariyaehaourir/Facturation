package ma.ehei.facturation.dto.transaction;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionRequest {
    @Min(value = 1 , message = "Le montant doit étre positive ")
    private Double montant;

    @NotBlank
    private UserInTransactionDto user;
}
