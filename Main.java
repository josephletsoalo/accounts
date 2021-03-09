import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;

public class Main {
  

  public static void main(String[] args) {
    //create and instance and populate the data into the database
     AccountService account =  new interfaceSavingAccount();
     account.populateDB();

     //populate the data into the database
     //account.populateDB();

     System.out.println("trying to withdraw amount R500 from savings");
     account.withdraw(107,BigDecimal.valueOf(500.00));
     System.out.println("\n");

     System.out.println("Withdrawing from Savings Account");
     account.withdraw(101,BigDecimal.valueOf(50000.00));
     System.out.println("\n");
     System.out.println("\n");

      System.out.println("Withdrawing from btoh Balance and Overdraft");
     account.withdraw(103,BigDecimal.valueOf(2000.00));
     System.out.println("\n");

     System.out.println("Withdrawing from btoh Balance and Overdraft");
     account.withdraw(104,BigDecimal.valueOf(10000.00));
     System.out.println("\n");

     System.out.println("Withdrawing only from Balance");
     account.withdraw(103,BigDecimal.valueOf(200.00));
     System.out.println("\n");

  }

}
 