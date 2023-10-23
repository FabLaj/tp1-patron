package LibrarieManipulationFichier;

public interface IFabriqueComposante {
    Dossier creerDossier(String chemin);
    Fichier creerFichier(String chemin, int octets);
}
