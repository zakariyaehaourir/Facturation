package ma.ehei.facturation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long id;
    private Double montantAvant;
    private Double montantApres;
    private LocalDateTime date = LocalDateTime.now();
    private Long remiseId;
    private Remise remise;
}
