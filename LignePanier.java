package tp7;

public class LignePanier {
    private Article article;
    private int quantite;

    public LignePanier(Article article, int quantite) {
        if (article == null)
            throw new IllegalArgumentException("Article non défini !");
        if (quantite <= 0)
            throw new IllegalArgumentException("Quantité doit être > 0 !");
        this.article = article;
        this.quantite = quantite;
    }

    public Article getArticle() { return article; }
    public int getQuantite() { return quantite; }

    public void setQuantite(int q) {
        if (q <= 0)
            throw new IllegalArgumentException("Quantité doit être > 0 !");
        this.quantite = q;
    }

    public int getSousTotal() {
        return article.getPrixCentimes() * quantite;
    }

    @Override
    public String toString() {
        return String.format("%-10s x %d => %d cts", article.getId(), quantite, getSousTotal());
    }
}
