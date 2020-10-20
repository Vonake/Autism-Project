
public class Database {

    public Database() {

    }
    
    public static void main(String [] args){
       System.out.println("My Autistic DB");
      
    } 
    public boolean Login(String Username, String Password){
        boolean result;
        if(Username.equals("kevo") && Password.equals("vonake") ){
            result = true;
        }else{
            result = false;
        }       
        return result;
    }
    
}
