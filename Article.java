package tp7;

public class Article {
    private String id;
    private String libelle;
    private int prixCentimes;
    private int stock;

    public Article(String id, String libelle, int prixCentimes, int stock) {
        if (id == null || id.isEmpty())
            throw new IllegalArgumentException("L'id ne peut pas être vide !");
        if (libelle == null || libelle.isEmpty())
            throw new IllegalArgumentException("Le libellé ne peut pas être vide !");
        if (prixCentimes < 0)
            throw new IllegalArgumentException("Le prix doit être positif !");
        if (stock < 0)
            throw new IllegalArgumentException("Le stock doit être positif !");
        
        this.id = id;
        this.libelle = libelle;
        this.prixCentimes = prixCentimes;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getLibelle() { return libelle; }
    public int getPrixCentimes() { return prixCentimes; }
    public int getStock() { return stock; }

    public void setStock(int stock) {
        if (stock < 0)
            throw new IllegalArgumentException("Stock invalide !");
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "l'id est :" +id+ "la libelle est :" + libelle + "le prix est : " + prixCentimes + "la quantite en stock:" + stock ;
    }
}
