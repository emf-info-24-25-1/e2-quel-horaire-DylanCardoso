package models;

public class Professeur {
    //MR Manque les finals sur les deux premiers attributs
    private String nom;
    private String prenom;
    private ModuleInfo[] modulesEnseignes;

    public Professeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        modulesEnseignes = new ModuleInfo[0];
    }

    public boolean enseigneCeModule(String nomDuModule) {
        boolean aEnseigneeCeModule = false;
        for (int i = 0; i < modulesEnseignes.length; i++) {
            if (modulesEnseignes[i].getNom() == nomDuModule)
                aEnseigneeCeModule = true;
                //MR un petit break ici
        }
        return aEnseigneeCeModule;
    }

    public void ajouterModuleEnseigne(ModuleInfo module) {
        ModuleInfo[] nouvelleListeModuleInfo = new ModuleInfo[this.modulesEnseignes.length + 1];

        for (int i = 0; i < modulesEnseignes.length; i++) {
            nouvelleListeModuleInfo[i] = modulesEnseignes[i];
        }
        
        nouvelleListeModuleInfo[this.modulesEnseignes.length] = module;
        modulesEnseignes = nouvelleListeModuleInfo;
    }

    public void viderModules() {
        ModuleInfo[] nouvelleListeModuleInfo = new ModuleInfo[0];
        modulesEnseignes = nouvelleListeModuleInfo;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ModuleInfo[] getModulesEnseignes() {
        return modulesEnseignes;
    }

    @Override
    public String toString() {
        //MR Ne correspond pas à la consigne Doit retourner le prénom suivi d'un espace et du nom de famille en majuscules.
        return "Professeur : " + nom;
    }
}
