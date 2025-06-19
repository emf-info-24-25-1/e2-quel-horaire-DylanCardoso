package models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Bloc {
    public static final int NBRE_DE_DEMIS_JOURS_SEMAINE = 10;

    //MR Les deux attributs auraient pu être final
    private String nom;
    private ModuleInfo[] modules;
    
    //MR La signature de la méthode Bloc n'est pas précisé comme ceci
    public Bloc(String nom, ModuleInfo[] modules) {
        this.nom = nom;

        modules = new ModuleInfo[NBRE_DE_DEMIS_JOURS_SEMAINE];

        for (int i = 0; i < modules.length; i++) {
            if (i < 4) 
                modules[i] = new ModuleInfo("Matu");
        }

        this.modules = modules;
    }

    //MR Ta méthode est juste, mais si il n'y a pas assez de place, il planifie tout de même les premiers modules
    public boolean planifierModule(ModuleInfo module) {
        int nbreDeDemiJourTrouvee = 0;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == null) {
                nbreDeDemiJourTrouvee++;
                if (nbreDeDemiJourTrouvee < 3)
                    modules[i] = module;
            }
        }

        return (nbreDeDemiJourTrouvee == 3) ? true : false;
    }

    public void afficherHoraire() {

        int compteur = 0;
        int jour = 0;
        while (NBRE_DE_DEMIS_JOURS_SEMAINE > compteur) {
            if (modules[compteur] != null) {
                if (jour <= 5) {
                    System.out.println(DayOfWeek.values()[jour].getDisplayName(TextStyle.FULL, Locale.FRANCE));
                    jour++;
                }
                //MR Ici le module doit afficher le toString pour afficher également le professeur
                System.out.println("    matin : " + modules[compteur].getNom());
                compteur++;
                System.out.println("    après-midi : " + modules[compteur].getNom());
                compteur++;
            }
            else 
                break;
        }
    }
    
    public boolean estTotalementPlanifier() {
        boolean estRempli = true;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == null) {
                estRempli = false;
                break;
            }
        }
        
        return estRempli;
    }

    public boolean contientModule(ModuleInfo module) {
        boolean contientModule = false;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == module) {
                contientModule = true;
            }
        }

        return contientModule;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        //MR Retourne simplement le nom du bloc
        return "Bloc []";
    }
}
