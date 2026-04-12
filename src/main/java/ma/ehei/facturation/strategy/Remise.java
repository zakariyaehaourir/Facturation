package ma.ehei.facturation.strategy;

public interface Remise {
    Double calculateRemise(Double mt);
    String getIdentifiant();

}
