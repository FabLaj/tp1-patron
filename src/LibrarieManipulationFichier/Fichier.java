package LibrarieManipulationFichier;

class Fichier extends Composante {
    int _octets;

    Fichier(String chemin, int nombreOctets)
    {
        super(chemin);
        _octets = nombreOctets;
    }

    @Override
    public String obtenirChemin() {
        return _chemin;
    }

    @Override
    public String obtenirNom() {
        return _chemin.substring(_chemin.lastIndexOf(("/")), _chemin.length());
    }
    
    public int obtenirTaille() {
        return _octets;
    }

    public String obtenirExtension() {
        return _chemin.substring(_chemin.lastIndexOf("."), _chemin.length());
    }

    @Override
    public Boolean estVide() {
        return true;
    }
}
