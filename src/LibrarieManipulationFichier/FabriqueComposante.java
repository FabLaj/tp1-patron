package LibrarieManipulationFichier;

class FabriqueComposante implements IFabriqueComposante{

    @Override
    public Dossier creerDossier(String chemin) {
        return new Dossier(chemin);
    }

    @Override
    public Fichier creerFichier(String chemin, int octets) {
        return new Fichier(chemin, octets);
    }

}
