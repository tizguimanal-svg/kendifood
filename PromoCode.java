package tp7;

public class PromoCode {
    private String code;
    private int pourcentage; // 1..50

    public PromoCode(String code, int pourcentage) {
        if (code == null || code.isEmpty())
            throw new IllegalArgumentException("Code promo vide !");
        if (pourcentage < 1 || pourcentage > 50)
            throw new IllegalArgumentException("Pourcentage promo invalide !");
        this.code = code;
        this.pourcentage = pourcentage;
    }

    public String getCode() { return code; }
    public int getPourcentage() { return pourcentage; }
}
