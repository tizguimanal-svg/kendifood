package tp7;

public class Catalogue {
    private Article[] articles;
    private int taille;  
    private int[][] statistiques; 
    
    public Catalogue(int capaciteInitiale) {
        if (capaciteInitiale <= 0)
            throw new IllegalArgumentException("Capacité invalide !");
        articles = new Article[capaciteInitiale];
        statistiques = new int[capaciteInitiale][2]; // 2 colonnes : ventes, retours
        taille = 0;
    }

    public void ajouterArticle(Article a) {
        if (taille >= articles.length) {
            System.out.println("⚠ Capacité atteinte, agrandissement du tableau...");
            agrandir();
        }
        articles[taille] = a;
        taille++;
    }

    public void afficherCatalogue() {
        System.out.println("=== CATALOGUE ACTUEL ===");
        for (int i = 0; i < taille; i++) {
            System.out.println(articles[i]);
        }
    }

    public int rechercherPosition(String idRecherche) {
        for (int i = 0; i < taille; i++) {
            if (articles[i].getId().equals(idRecherche))
                return i;
        }
        return -1;
    }

    private void agrandir() {
        int nouvelleCapacite = articles.length * 2;
        Article[] nouveauTab = new Article[nouvelleCapacite];
        int[][] nouvellesStats = new int[nouvelleCapacite][2];

        for (int i = 0; i < taille; i++) {
            nouveauTab[i] = articles[i];
            nouvellesStats[i] = statistiques[i];
        }

        articles = nouveauTab;
        statistiques = nouvellesStats;
    }

    public int getTaille() {
        return taille;
    }
    public Article[] getArticles() {
        return articles;
    }
}
