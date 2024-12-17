public class Personnel{
    private int id;
    private String nom;
    private String prenom;
    private double salaire;
    private int Heures_travail;
    public Personnel(int id,String nom,String Prenom,int Heures_travail,double salaire){
        this.id=id;
        this.nom=nom;
        this.prenom=Prenom;
        this.Heures_travail=Heures_travail;
        this.salaire=salaire;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    public void setHeures_travail(int heures){
        Heures_travail=heures;
    }
    public void setSalaire(double salaire){
        this.salaire=salaire;
    }
    public int getId(){
        return this.id;
    }
    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public int getHeure_travail(){
        return this.Heures_travail;
    }
    public double getSalaire(){
        return this.salaire;
    }
    public String toString(){
        return "Nom: "+this.nom+" Prenom: "+this.prenom+" id: "+this.id+" Salaire: "+this.salaire+" Horaire de travail: "+this.Heures_travail;
    }
}