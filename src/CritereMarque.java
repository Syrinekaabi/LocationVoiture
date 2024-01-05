public class CritereMarque implements Critere {
    private String marque;

    public CritereMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        // Vérifier si la marque de la voiture correspond au critère
        return v.getMarque().equals(marque);
    }
}
