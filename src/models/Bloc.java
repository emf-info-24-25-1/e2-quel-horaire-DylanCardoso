package models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Bloc {
    public static final int NBRE_DE_DEMIS_JOURS_SEMAINE = 10;

    private String nom;
    private ModuleInfo[] modules;
    
    public Bloc(String nom, ModuleInfo[] modules) {
        this.nom = nom;

        modules = new ModuleInfo[NBRE_DE_DEMIS_JOURS_SEMAINE];

        for (int i = 0; i < modules.length; i++) {
            if (i < 4) 
                modules[i] = new ModuleInfo("Matu");
        }

        this.modules = modules;
    }

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
        return "Bloc []";
    }
}
