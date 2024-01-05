import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures parking;
    private Map<Client, ListVoitures> clientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        this.parking = new ListVoitures();
        this.clientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        parking.ajoutVoiture(v);
    }

    public void suppVoiture(Voiture v) throws VoitureException {
        parking.supprimeVoiture(v);
    }

    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (!clientVoitureLoue.containsKey(cl)) {
            clientVoitureLoue.put(cl, new ListVoitures());
        }
        ListVoitures voituresLouees = clientVoitureLoue.get(cl);
        voituresLouees.ajoutVoiture(v);
    }

    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (clientVoitureLoue.containsKey(cl)) {
            ListVoitures voituresLouees = clientVoitureLoue.get(cl);
            voituresLouees.supprimeVoiture(v);
        }
    }

    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> voituresSatisfaisantes = new ArrayList<>();
        for (Voiture v : parking.getVoitures()) {
            if (c.estSatisfaitPar(v)) {
                voituresSatisfaisantes.add(v);
            }
        }
        return voituresSatisfaisantes;
    }

    public Set<Client> ensembleClientsLoueurs() {
        return clientVoitureLoue.keySet();
    }

    public Collection<ListVoitures> collectionVoituresLouees() {
        return clientVoitureLoue.values();
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        for (Map.Entry<Client, ListVoitures> entry : clientVoitureLoue.entrySet()) {
            Client client = entry.getKey();
            ListVoitures voituresLouees = entry.getValue();

            System.out.println("Client: " + client.toString());
            System.out.println("Voitures louées:");
            voituresLouees.affiche();
            System.out.println();
        }
    }

    public Map<Client, ListVoitures> triCodeCroissant() {
        Map<Client, ListVoitures> triMap = new TreeMap<>(Comparator.comparingInt(Client::getCode));
        triMap.putAll(clientVoitureLoue);
        return triMap;
    }

    public Map<Client, ListVoitures> triNomCroissant() {
        Map<Client, ListVoitures> triMap = new TreeMap<>(Comparator.comparing(Client::getNom));
        triMap.putAll(clientVoitureLoue);
        return triMap;
    }
}
