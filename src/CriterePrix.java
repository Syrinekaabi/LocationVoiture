public class CriterePrix implements Critere {
    private float prix;

    public CriterePrix(float prix) {
        this.prix = prix;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        // Vérifier si le prix de la voiture est inférieur ou égal au critère de prix
        return v.getPrixLocation() <= prix;
    }
}
