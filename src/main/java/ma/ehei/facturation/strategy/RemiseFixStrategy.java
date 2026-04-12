package ma.ehei.facturation.strategy;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class RemiseFixStrategy implements  Remise{
    private final String identifiant="remise_fix";
    private final float taux = 0.02f;

    @Override
    public Double calculateRemise(Double mt) {
        return mt * this.taux;
    }
}
