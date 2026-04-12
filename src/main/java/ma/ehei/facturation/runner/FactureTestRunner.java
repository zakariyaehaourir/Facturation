package ma.ehei.facturation.runner;

import lombok.AllArgsConstructor;
import ma.ehei.facturation.RemiseDAO;
import ma.ehei.facturation.service.impl.FactureServiceHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@AllArgsConstructor
@Component
public class FactureTestRunner implements CommandLineRunner {

    private final FactureServiceHandler factureServiceHandler;
    private final RemiseDAO dao;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Start de l'application Facturation : ");
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrée le montant a calcule la remise : ");
        Double mt =Double.parseDouble(sc.next());

        System.out.println("Entrée le type de remise \n 1-Pour fix \n 2-Pour variable \n 3-Default remise");
        int choix = sc.nextInt();
        String identifiant = (choix == 1) ? "remise_fix" :(choix == 2) ?   "variable" : "h2-database";
        Double result =this.factureServiceHandler.calculeMontant(mt,identifiant);
        System.out.println("Le résultat est : " + result);

        dao.countRemises();
    }
}
