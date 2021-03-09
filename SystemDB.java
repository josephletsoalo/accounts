import java.util.*; 
import java.math.BigDecimal;

class SystemDB{
 
    // static variable single_instance of type Singleton 
    private static SystemDB single_instance = null; 
  
    // my data base variables
    public static Map<Integer, SavingsAccount> savingsAcc;
    public static Map<Integer, CurrentAccount> currentAcc;
    private static int id;
    // private constructor restricted to this class itself 
    private SystemDB() 
    { 
        //open the file and populate 
        savingsAcc=new HashMap<Integer,SavingsAccount>();  
        currentAcc=new HashMap<Integer,CurrentAccount>(); 
        id=101;
       

    } 
  
    // static method to create instance of Singleton class 
    public static SystemDB getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new SystemDB(); 
  
        return single_instance; 
    }
    public static void addSavingsAcc(SavingsAccount acc){
       
        savingsAcc.put(id,acc);
        id++;
    }
    public static void addCurrentAcc(CurrentAccount acc){

        currentAcc.put(id,acc);
        id++;
    }

}