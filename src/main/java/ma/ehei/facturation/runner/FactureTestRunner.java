package ma.ehei.facturation.runner;

import ma.ehei.facturation.repositoy.impl.RemiseDAO;
import ma.ehei.facturation.service.FactureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FactureTestRunner implements CommandLineRunner {

    private final FactureService factureServiceHandler;
    private final RemiseDAO dao;

    public FactureTestRunner(FactureService factureService , RemiseDAO dao){
        this.dao=dao;
        this.factureServiceHandler=factureService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Start de l'application Facturation : ");
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrée le montant a calcule la remise : ");
        Double mt =Double.parseDouble(sc.next());

        System.out.println("Entrée le type de remise \n 1-Pour fix \n 2-Pour variable \n 3-Default remise");
        int choix = sc.nextInt();

        String identifiant = (choix == 1) ? "remise_fix" :(choix == 2) ?   "remise_variable" : "h2-database";

        Double result =this.factureServiceHandler.calculeMontant(mt,identifiant);
        System.out.println("Le résultat est : " + result);

        dao.countRemises();
    }
}
