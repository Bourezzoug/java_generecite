package generecite_java;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par id");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Supprimer un produit par id");
            System.out.println("5. Quitter");

            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Liste des produits :");
                    for (Produit produit : metier.getAll()) {
                        System.out.println(produit);
                    }
                    break;

                case 2:
                    System.out.print("Entrez l'id du produit : ");
                    long idRecherche = scanner.nextLong();
                    Produit produitTrouve = metier.findById(idRecherche);
                    System.out.println(produitTrouve != null ? produitTrouve : "Produit non trouvé");
                    break;

                case 3:
                    System.out.print("Entrez l'id : ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Consommer la ligne restante
                    System.out.print("Entrez le nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consommer la ligne restante
                    System.out.print("Entrez la description : ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock : ");
                    int nombreEnStock = scanner.nextInt();
                    Produit nouveauProduit = new Produit(id, nom, marque, prix, description, nombreEnStock);
                    metier.add(nouveauProduit);
                    System.out.println("Produit ajouté avec succès.");
                    break;

                case 4:
                    System.out.print("Entrez l'id du produit à supprimer : ");
                    long idSuppression = scanner.nextLong();
                    metier.delete(idSuppression);
                    System.out.println("Produit supprimé avec succès.");
                    break;

                case 5:
                    System.out.println("Programme terminé.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Choix invalide.");
            }
        }
    }
}

