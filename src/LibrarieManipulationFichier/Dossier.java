package LibrarieManipulationFichier;

import java.util.ArrayList;
import java.util.List;

class Dossier extends Composante {
    List<ICompositeFichier> _enfants = new ArrayList<ICompositeFichier>();

    Dossier(String chemin)
    {
        super(chemin);
    }

    void ajouter(ICompositeFichier enfant)
    {
        _enfants.add(enfant);
    }

    //Retirer tout le contenu 
    void retirer(String chemin) throws Exception
    {
        for (ICompositeFichier f : _enfants) {
            if(f.obtenirChemin() == chemin)
            {
                if(f.estVide())
                {
                    _enfants.remove(f);
                }
                else
                {
                    throw new Exception("Le dossier n'est pas vide");
                }
            }
        }
    }

    
    Dossier allerAuChemin(String chemin) {
        if(chemin.equals("racine/"))
        {
            return this;
        }
        for (ICompositeFichier f : _enfants)
        {
            if(f.obtenirChemin().equals(chemin))
            {
                return (Dossier) f;
            }   
        }
        return null;
    }

    private String obtenirCheminParent(String chemin)
    {
        return chemin.substring(0, chemin.substring(0, chemin.length() - 1).lastIndexOf("/"));
    }

    @Override
    public Boolean estVide()
    {
        return _enfants.isEmpty();
    }

    @Override
    public String obtenirChemin() {
        return _chemin;
    }

    @Override
    public String obtenirNom() {
       _chemin = _chemin.substring(0, _chemin.length() - 1);
       return _chemin.substring(_chemin.lastIndexOf("/"), _chemin.length());
    }
}
