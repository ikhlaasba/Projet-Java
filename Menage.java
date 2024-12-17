public class Menage extends Personnel{
    public String tache;
    public Menage(int id,String nom,String Prenom,int Heures_travail,String tache,double salaire){
        super(id,nom,Prenom,Heures_travail,salaire);
        this.tache=tache;
    }
    public void setTache(String tache){
        this.tache=tache;
    }
    public String getTache(){
        return this.tache;
    }
    public String toString(){
        return super.toString()+" Tache: "+this.tache+" Nuléro de sécteur: "+"\n";
    }
}