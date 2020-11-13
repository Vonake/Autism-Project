
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Validator{
    //this is the constructor. aka entry point
    public Validator(){
        
    }
    
//    this method vlidates all names
    public String[] nameValidator(String name, String type){
        String result = "false";
        String message = ""; 
        String array[] = new String[2];
        
        
        //check if string is empty
        if(name.isEmpty()){
            result = "false";
            message = "Provide "+type;
        } 
        
        //name should only be 3 lengths and above
        else if(name.length() < 3){
            result = "false";
            message = type+" should  have atleast 3 characters";
        }
        
        //success validation
        else {
            result = "true";
            message = "";
        }
        
        array[0] = result;
        array[1] = message;
        return array;
    }
    
    
//    this method validates age
    public String[] ageValidator(String age){
        String result = "false";
        String message = "";
        String [] array = new String[2];
        String regex = "[0-9]+";
//        System.out.println(age.matches(regex));
        //age is not empty
        if(age.isEmpty()){
            result = "false";
            message = "Provide age!";
        } 
       
        //age must be a number
        //acha ni google vile tunachekc
        
        else if(age.matches(regex) == false){
            result = "false";
            message = "Age should only be numbers! ";
        }
        //no errors
        else{
            result = "true";
            message = "";
        }
        
        array[0] = result;
        array[1] = message;
        return array;
    }
    
    public String[] passwordValidator(String password){
        String result = "false";
        String message = "";
        String[] array = new String[2];
        if(password.isEmpty()){
            result = "false";
            message = "Input Password";
           
        }
         else if(password.length() <5){
            result = "false";
            message = "Password should be more than 5 Characters!";
        }
         else{
             result = "true";
             message = "";
         }
        array[0] = result;
        array[1] = message;
        return array;
    }
    public String[] emailValidator(String email){
        String result = "false";
        String message = "";
        String[] array = new String[2];
        if(email.isEmpty()){
            result = "false";
            message = "Input Email";
           
        }
         else if(email.length() <8){
            result = "false";
            message = "Email should be more than 8 Characters!";
        }
         // testgmail.com
         else if(email.contains("@") == false){
            result = "false";
            message = "Email should contain @ !";
        }
         else if(email.contains(".") == false){
            result = "false";
            message = "Email should contain . !";
        }
         else{
             result = "true";
             message = "";
         }
        array[0] = result;
        array[1] = message;
        return array;
    }
    public void Exit(){
        Home h = new Home();
        h.setVisible(true);
        //this.dispose();
    }
    
    //method for popup coz i am lazy to type
    public void popup(Object obj){
        JOptionPane.showMessageDialog(null, obj);
    }
}