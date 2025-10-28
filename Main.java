package tp7;

public class Main {
    public static void main(String[] args) {
        Catalogue catalogue = new Catalogue(10);

        Article a1 = new Article("KIT_BOL1", "Bol végétarien", 5990, 12);
        Article a2 = new Article("TOMATE3", "Tomates x3", 990, 40);

        catalogue.ajouterArticle(a1);
        catalogue.ajouterArticle(a2);

        Panier panier = new Panier();
        panier.ajouterArticle(catalogue, "TOMATE3", 2);
        panier.ajouterArticle(catalogue, "KIT_BOL1", 1);

        PromoCode[] codes = {
            new PromoCode("KENDI10", 10),
            new PromoCode("RETOUR5", 5),
            new PromoCode("SUPER20", 20)
        };

        String codeSaisi = "KENDI10";
        if (panier.appliquerCode(codes, codeSaisi)) {
            System.out.println("Code '" + codeSaisi + "' appliqué !");
        } else {
            System.out.println("Code invalide !");
        }

        System.out.println("\n" + panier.genererRecu());
    }
}
