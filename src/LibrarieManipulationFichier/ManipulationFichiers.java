package LibrarieManipulationFichier;

import java.io.Console;

public class ManipulationFichiers {

    Dossier racine = new Dossier("racine/");
    IFabriqueComposante fabrique = new FabriqueComposante();

    //Rentrer chemin et nom ensemble
    public Boolean creerFichier(String chemin, int nombreOctets)
    {
        String dernierCharactere = chemin.substring(chemin.length() - 1);
        if(!dernierCharactere.equals("/") && racine.allerAuChemin(obtenirCheminParent(chemin)) != null)
        {
            String cheminParent = obtenirCheminParent(chemin);
            Dossier parent = racine.allerAuChemin(cheminParent);
            Fichier nouveauFichier = fabrique.creerFichier(chemin, nombreOctets);
            parent.ajouter(nouveauFichier);
            return true;
        }
        else
        {
            System.out.println("Fichier ou emplacement non valide (format: chemin/nomFichier)");
            return false;
        }
    }

    ///Pour le chemin, il faut indiquer le chemin complet et mettre un "/" à la fin
    public Boolean creerDossier(String chemin)
    {
        String dernierCharactere = chemin.substring(chemin.length() - 1);
        if(dernierCharactere.equals("/") && racine.allerAuChemin(obtenirCheminParent(chemin)) != null)
        {
            String cheminParent = obtenirCheminParent(chemin);
            Dossier parent = racine.allerAuChemin(cheminParent);
            Dossier nouveauDossier = fabrique.creerDossier(chemin);
            parent.ajouter(nouveauDossier);
            return true;
        }
        else
        {
            System.out.println("Dossier ou emplacement non valide (format: chemin/nomDossier/)");
            return false;
        }
    }

    public Boolean supprimerComposante(String chemin)
    {
        if(racine.allerAuChemin(obtenirCheminParent(chemin)) != null)
        {
            String parentChemin = obtenirCheminParent(chemin);
            Dossier parent = racine.allerAuChemin(parentChemin);
            try
            {
                parent.retirer(chemin);
                return true;
            }
            catch (Exception e)
            {
                System.out.println(e);
                return false;
            }
        }
        System.out.println("Chemin non valide!");
        return false;
    }

    //Regarder la stratégie
    public Boolean exporterStructureFichier()
    {
        return true;
    }

    private String obtenirCheminParent(String chemin)
    {
        return chemin.substring(0, chemin.substring(0, chemin.length() - 1).lastIndexOf("/") + 1);
    }
}
