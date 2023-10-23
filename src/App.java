import LibrarieManipulationFichier.ManipulationFichiers;

public class App {
    public static void main(String[] args) throws Exception {
        ManipulationFichiers manipFichiers = new ManipulationFichiers();
        manipFichiers.creerDossier("racine/premierDossier/");
        manipFichiers.creerFichier("racine/premierDossier/premierFichier.txt", 1000);
        //Voir avec le temps si j'implémente la création de ce dossier
        //manipFichiers.creerFichier("racine/deuxiemeDossier/deuxiemeFichier", 121212);
        //manipFichiers.creerFichier("racine/premierDossier/deuxiemeFichier/", 121212);
        manipFichiers.creerDossier("racine/deuxiemeDossier/");
        manipFichiers.creerFichier("racine/deuxiemeDossier/deuxiemeFichier", 121212);   
        manipFichiers.supprimerComposante("racine/premierDossier/premierFichier.txt"); 
    }
}