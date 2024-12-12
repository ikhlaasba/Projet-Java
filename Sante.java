public class Sante extends Personnel{
    private String specialite;
    private String grade;
    public Sante(int id,String nom,String Prenom,int Heures_travail,String specialite,String grade){
        super(id,nom,Prenom,Heures_travail);
        this.specialite=specialite;
        this.grade=grade;
    }
    public void setSpecialite(String specialite){
        this.specialite=specialite;
    }
    public String getSpecialite(){
        return this.specialite;
    }
    public void setGrade(String grade){
    }
    public String getNumero_bureau(){
        return this.grade;
    }
}
