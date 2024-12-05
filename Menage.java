public class Menage extends Personnel{
    public String tache;
    public int num_Secteur;
    public Menage(int id,String nom,String Prenom,int Heures_travail,String tache,int num_Secteur){
        super(id,nom,Prenom,Heures_travail);
        this.tache=tache;
        this.num_Secteur=num_Secteur;
    }
    public void setTache(String tache){
        this.tache=tache;
    }
    public String getTache(){
        return this.tache;
    }
    public void setNum_secteur(int numero){
        this.num_Secteur=numero;
    }
    public int getNumero_secteur(){
        return this.num_Secteur;
    }
    public String toString(){
        return super.toString()+" Tache: "+this.tache+" Nuléro de sécteur: "+this.num_Secteur+"\n";
    }
}