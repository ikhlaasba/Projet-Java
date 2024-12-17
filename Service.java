//enum service{alimentation,massage,animation,restauration}
public class Service {
    String service;
    int dure;



public Service(String service,int dure){
    this.dure=dure;
    this.service= service;
}
public void setdure(int dure){
    this.dure=dure;
}
public int getdure(){
    return dure;
}
public void setservice(String s){
    this.service=s;
}
public String getservice(){
    return service;
}
public String toString(){
    return "Nom de service : "+this.service+" Duree de service : "+this.dure;
}

}

    

