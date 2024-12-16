import java.time.LocalDate;
import java.time.Period;

public class Resident {
    private int id_resident;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String dossierMedical;

    // Constructeur
    public Resident(int id_resident,String nom, String prenom, LocalDate dateNaissance, String dossierMedical) {
        this.id_resident=id_resident;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.dossierMedical = dossierMedical;
    }

    // Getters
    public int getId_resident(){
        return this.id_resident;
    }
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getDossierMedical() {
        return dossierMedical;
    }

    // Setters
    public void setId_resident(int id){
        this.id_resident=id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setDossierMedical(String dossierMedical) {
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
