enum Specialite{
    generaliste,kinesitherapeute,nutritionniste,cardiologue,orthopediste;
}
public class Sante extends Personnel{
    private Specialite specialite;
    private String grade;
    public Sante(int id,String nom,String Prenom,int Heures_travail,Specialite specialite,String grade){
        super(id,nom,Prenom,Heures_travail);
        this.specialite=specialite;
        this.grade=grade;
    }
    public void setSpecialite(Specialite specialite){
        this.specialite=specialite;
    }
    public Specialite getSpecialite(){
        return this.specialite;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }
    public String getGrade(){
        return this.grade;
    }
    public String toString(){
        return super.toString()+" Spécialité: "+this.specialite+" Grade: "+this.grade+"\n";
    }
}