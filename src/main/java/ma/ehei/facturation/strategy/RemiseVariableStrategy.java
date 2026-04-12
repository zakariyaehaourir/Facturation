package ma.ehei.facturation.strategy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Getter
@Component

public class RemiseVariableStrategy implements Remise{

    private final String identifiant = "remise_variable";

    @Override
    public Double calculateRemise(Double mt) {
        return mt > 1000 ? mt * 0.20 : mt * 0.05;
    }
}
