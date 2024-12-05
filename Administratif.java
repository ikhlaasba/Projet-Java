public class Administratif extends Personnel{
    private String responsabilite;
    private int numero_bureau;
    public Administratif(int id,String nom,String Prenom,int Heures_travail,String responsabilite,int numero_bureau){
        super(id,nom, Prenom,Heures_travail);
        this.responsabilite=responsabilite;
        this.numero_bureau=numero_bureau;
    }
    public void setResponsabilite(String responsabilite){
        this.responsabilite=responsabilite;
    }
    public String getResponsabilite(){
        return this.responsabilite;
    }
    public void setNumero_bureau(int numero){
        this.numero_bureau=numero;
    }
    public int getNumero_bureau(){
        return this.numero_bureau;
    }
    public String toString(){
        return super.toString()+" résponsabilité: "+this.responsabilite+" numéro de bureau: "+this.numero_bureau+"\n";
    }
}