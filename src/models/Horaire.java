package models;

public class Horaire {
    public static final int NBRE_DE_BLOCS = 6;
    private Bloc[] blocs;

    public Horaire() {
        this.blocs = new Bloc[NBRE_DE_BLOCS];
        int b = 1;
        int s = 1;
        for (int i = 0; i < blocs.length; i++) {
            this.blocs[i] = new Bloc("B" + b + "S" + s, null);
            b++;
            if (b % 3 == 0) 
                s++;
        }
    }

    public boolean planifier(ModuleInfo[] modules, Professeur[] profs) {
            //MR Tu aurais dû faire en deux étapes setProfesseur, puis ensuite planifierModule dans une autre (pas de boucle imbriquée)    
        boolean aReussiAPlanifier = false;
        for (int i = 0; i < modules.length; i++) {
            for (int j = 0; j < profs.length; j++) {
                if (profs[j].enseigneCeModule(modules[i].getNom())) {
                    modules[i].setProfesseur(profs[j]);
                    for (int x = 0; x < profs.length; x++) {
                        if (!blocs[x].contientModule(modules[i])){
                            blocs[x].planifierModule(modules[i]);
                            aReussiAPlanifier = true;
                        }
                    }
                }
            }
        }

        return aReussiAPlanifier;
    }
    
    public void afficherHoraire() {
        for (int i = 0; i < blocs.length; i++) {
            System.out.println("[Blocs " + (i + 1) + "]");
            blocs[i].afficherHoraire(); 
        }
    }

    public Bloc moduleDansQuelleBloc(ModuleInfo module) {
        Bloc leBlocEnQuestion = null;
        for (int i = 0; i < blocs.length; i++) {
            if (blocs[i].contientModule(module)) {
                leBlocEnQuestion = blocs[i];
                break;
            }
        }
        
        return leBlocEnQuestion;
    }
}
