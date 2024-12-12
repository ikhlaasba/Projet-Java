import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Resident {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private List<String> dossierMedical;

    // Constructeur
    public Resident(String nom, String prenom, LocalDate dateNaissance, List<String> dossierMedical) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.dossierMedical = dossierMedical;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public List<String> getDossierMedical() {
        return dossierMedical;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setDossierMedical(List<String> dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    // calculer l'age
    public int calculAge() {
        if (dateNaissance == null) {
            throw new IllegalStateException("La date de naissance n'est pas définie.");
        }
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }

    // toString
    @Override
    public String toString() {
        return "Resident{" +
               "nom='" + nom + '\'' +
               ", prenom='" + prenom + '\'' +
               ", dateNaissance=" + dateNaissance +
               ", dossierMedical=" + dossierMedical +
               '}';
    }
}
