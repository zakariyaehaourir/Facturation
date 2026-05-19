package ma.ehei.facturation.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTransactionRequest {
    private Long id;
    private Double montantAvant;
    private Double montantApres;
    private LocalDateTime date;
    private Long remiseId;
}
