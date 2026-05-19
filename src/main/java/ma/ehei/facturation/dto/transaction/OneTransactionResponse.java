package ma.ehei.facturation.dto.transaction;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class OneTransactionResponse {
    private Double montantAvant;
    private Double montantApres;
    private LocalDateTime date;
}
