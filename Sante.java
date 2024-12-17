enum Specialite{
    generaliste,kinesitherapeute,nutritionniste,cardiologue,orthopediste;
}
public class Sante extends Personnel{
    private String specialite;
    public Sante(int id,String nom,String Prenom,int Heures_travail,String specialite,double salaire){
        super(id,nom,Prenom,Heures_travail,salaire);
        this.specialite=specialite;

    }
    public void setSpecialite(String specialite){
        this.specialite=specialite;
    }
    public String getSpecialite(){
        return this.specialite;
    }

    public String toString(){
        return super.toString()+" Spécialité: "+this.specialite+"\n";
    }
}


