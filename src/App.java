import models.Horaire;
import models.ModuleInfo;
import models.Professeur;
import services.ServiceFormationMaitres;

public class App {

    public static final String[] NOMS_MODULES = {"G300","187","162","123","293","117","164","216","106", "231","122","431"};

    public static void main(String[] args) {
        Horaire horaire = new Horaire();
        ModuleInfo[] module1ere = new ModuleInfo[12];
        for (int i = 0; i < NOMS_MODULES.length; i++) {
            module1ere[i] = new ModuleInfo(NOMS_MODULES[i]);
        }

        Professeur[] profs = new Professeur[] {
            new Professeur("Collella", "Dymytry"),
            new Professeur("Ramahllo", "Marh-io"),
            new Professeur("Metros", "Piè rhe-Allin"),
            new Professeur("Ba-dous", "Quentain"),
            new Professeur("Nadi-ha", "Egg-heur"),
        };
        while (!ServiceFormationMaitres.tousModulesCouverts(profs, module1ere)) {
            ServiceFormationMaitres.attribuerModules(profs, module1ere);
        }

        System.out.println("l'école a engagé les professeurs suivants; ");
        for (int i = 0; i < profs.length; i++) {
            System.out.println("- " + profs[i] + " peut enseigner les modules : ");
            for (int j = 0; j < profs[i].getModulesEnseignes().length; j++) {
                System.out.println(" " + profs[i].getModulesEnseignes()[j].getNom());
            }
            System.out.println();
        }

        System.out.println("\nil est temps de préparer l'horaire\n");
        boolean aReussiAPlanifier = horaire.planifier(module1ere, profs);
        if (aReussiAPlanifier) {
            System.out.println("Modules planifier avec succèes !");
        }
        else {
            System.out.println("Probleme de planification...");
        }

        horaire.afficherHoraire();
    }
}
