package services;

import models.ModuleInfo;
import models.Professeur;

public class ServiceFormationMaitres {
    public static void attribuerModules(Professeur[] professeurs, ModuleInfo[] modules) {
        for (int i = 0; i < professeurs.length; i++) {
            //MR On pourrait éviter le doublon de code en réalisant un do while
            int nbre = ( int ) (Math.random() * ((modules.length - 1) - 0 + 1)) + 0;
            boolean enseigneDejaCeModule = professeurs[i].enseigneCeModule(modules[nbre].getNom());
            while (enseigneDejaCeModule) {
                nbre = ( int ) (Math.random() * ((modules.length - 1) - 0 + 1)) + 0;
                enseigneDejaCeModule = professeurs[i].enseigneCeModule(modules[nbre].getNom());
            }
            professeurs[i].ajouterModuleEnseigne(modules[nbre]);
            modules[nbre].setProfesseur(professeurs[i]);
        }
    }

    public static boolean tousModulesCouverts(Professeur[] profs, ModuleInfo[] modules) {
        boolean sontIlTousCouvert = false;
        for (int i = 0; i < modules.length; i++) {
            //MR Ici c'est la méthode PeutEnseigneCeModule (on est pas encore dans la planification)
            if (modules[i].getProfesseur() == null) {
                sontIlTousCouvert = false;
                break;
            }
            else {
                sontIlTousCouvert = true;
            }
        }

        return sontIlTousCouvert;
    }
}
