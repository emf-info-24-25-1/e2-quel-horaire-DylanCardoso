package models;

public class ModuleInfo {
    private String nom;
    private Professeur professeur;

    public ModuleInfo(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    @Override
    public String toString() {
        String returnString;
        if (professeur != null) {
            returnString = nom + " avec " + professeur.getNom();
        }
        else {
            returnString = nom;
        }

        return returnString;
    }
}
