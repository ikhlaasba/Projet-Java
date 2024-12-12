public class Chambre{
    private int num;
    private String type;
    private String statut;
    public Chambre( int num,String type,String statut){
        this.num=num;
        this.type=type;
        this.statut=statut;
    }
     public void setNum(int num){
        this.num=num;
    }
    public void setType(String type){
        this.type=type;
    }
    public void setStatut(String statut){
        this.statut=statut;
    }
     public int getNum(){
        return this.num;
    }
    public String getType(){
        return this.type;
    }
    public String getStatut(){
        return this.statut;
    }
    public String toString(){
        return "Num: "+this.num+"Type: "+this.type+"Statut: "+this.statut;
    }
}
//test