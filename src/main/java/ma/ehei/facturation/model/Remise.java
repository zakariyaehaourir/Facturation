package ma.ehei.facturation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Remise {
    private Long id;
    private  double min;
    private double max;
    private double taux;
}
