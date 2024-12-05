public class Personnel{
    private int id;
    private String nom;
    private String prenom;
    private float salaire;
    private int Heures_travail;
    public Personnel(int id,String nom,String Prenom,int Heures_travail){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.Heures_travail=Heures_travail;
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
    public void setSalaire(float salaire){
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
    public float getSalaire(){
        return this.salaire;
    }
    public String toString(){
        return "NOm: "+this.nom+"Prenom: "+this.prenom+"id: "+this.id+"salaire: "+this.salaire+"Horaire de travail: "+this.Heures_travail;
    }
}