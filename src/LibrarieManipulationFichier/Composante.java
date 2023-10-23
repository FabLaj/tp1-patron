package LibrarieManipulationFichier;

abstract class Composante implements ICompositeFichier{
    String _chemin;

    Composante(String chemin)
    {
        _chemin = chemin;
    }
}
