package tp7;

public class Panier {
    private LignePanier[] lignes;
    private int taille;
    private PromoCode promoApplique;

    public Panier() {
        lignes = new LignePanier[5];
        taille = 0;
        promoApplique = null;
    }

    public void ajouterArticle(Catalogue catalogue, String id, int quantite) {
        if (quantite <= 0) return;

        int posCatalogue = catalogue.rechercherPosition(id);
        if (posCatalogue == -1) return;

        Article article = catalogue.getArticles()[posCatalogue];
        if (article.getStock() < quantite) return;

        article.setStock(article.getStock() - quantite);

        int posPanier = rechercherPosition(id);
        if (posPanier != -1) {
            LignePanier ligne = lignes[posPanier];
            ligne.setQuantite(ligne.getQuantite() + quantite);
        } else {
            if (taille >= lignes.length) agrandir();
            lignes[taille] = new LignePanier(article, quantite);
            taille++;
        }
    }

    public void supprimerArticle(String id) {
        int posPanier = rechercherPosition(id);
        if (posPanier == -1) return;

        LignePanier ligne = lignes[posPanier];
        ligne.getArticle().setStock(ligne.getArticle().getStock() + ligne.getQuantite());

        for (int i = posPanier; i < taille - 1; i++) {
            lignes[i] = lignes[i + 1];
        }
        lignes[taille - 1] = null;
        taille--;
    }

    private int rechercherPosition(String id) {
        for (int i = 0; i < taille; i++) {
            if (lignes[i].getArticle().getId().equals(id)) return i;
        }
        return -1;
    }

    private void agrandir() {
        LignePanier[] nouveauTab = new LignePanier[lignes.length + 5];
        for (int i = 0; i < taille; i++) {
            nouveauTab[i] = lignes[i];
        }
        lignes = nouveauTab;
    }

    public void afficherPanier() {
        System.out.println("=== PANIER ===");
        int total = 0;
        for (int i = 0; i < taille; i++) {
            System.out.println(lignes[i]);
            total += lignes[i].getSousTotal();
        }
        System.out.println("Total brut : " + total + " cts");
    }

    public boolean appliquerCode(PromoCode[] codes, String codeSaisi) {
        for (PromoCode c : codes) {
            if (c.getCode().equals(codeSaisi)) {
                promoApplique = c;
                return true;
            }
        }
        return false;
    }

    public String genererRecu() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== REÇU KendiFood =====\n");

        int totalBrut = 0;
        for (int i = 0; i < taille; i++) {
            LignePanier l = lignes[i];
            sb.append(String.format("%-10s x%d -> %d cts\n", l.getArticle().getId(), l.getQuantite(), l.getSousTotal()));
            totalBrut += l.getSousTotal();
        }

        sb.append("Total brut : " + totalBrut + " cts\n");

        int totalNet = totalBrut;
        if (promoApplique != null) {
            int reduc = promoApplique.getPourcentage();
            sb.append("Code appliqué : " + promoApplique.getCode() + " (-" + reduc + "%)\n");
            totalNet = totalBrut - (totalBrut * reduc / 100);
        }

        sb.append("Total à payer : " + totalNet + " cts");
        return sb.toString();
    }
}
