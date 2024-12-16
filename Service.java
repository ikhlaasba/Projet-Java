enum service{alimentation,message,animation,resturation}
public class Service {
    service service;
    int dure;



public Service(service service,int dure){
    this.dure=dure;
    service= service;
}
public void setdure(int dure){
    this.dure=dure;
}
public int getdure(){
    return dure;
}
public void setservice(service s){
    this.service=s;
}
public service getservice(){
    return service;
}

}

    

