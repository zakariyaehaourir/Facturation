package ma.ehei.facturation.dto.Transaction;

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
    private Double montantAvant;
    private Double montantApres;
    private LocalDateTime date;
}
