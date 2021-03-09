import java.math.BigDecimal;
import java.util.Map;
public class interfaceSavingAccount implements AccountService{
	
	SystemDB db; 

	public void populateDB(){
		db = SystemDB.getInstance();
		//create saving accounts
		SavingsAccount savingsAcc1 = new SavingsAccount(1,BigDecimal.valueOf(2000.00));
		SavingsAccount savingsAcc2 = new SavingsAccount(2,BigDecimal.valueOf(5000.00));

		//create current accounts
		CurrentAccount currentAcc1 = new CurrentAccount(3,BigDecimal.valueOf(1000),BigDecimal.valueOf(10000.00));
		CurrentAccount currentAcc2 = new CurrentAccount(4,BigDecimal.valueOf(-5000.00),BigDecimal.valueOf(20000.00));

		//populate the database with accounts
		
		db.addSavingsAcc(savingsAcc1);
		db.addSavingsAcc(savingsAcc2);

		db.addCurrentAcc(currentAcc1);
		db.addCurrentAcc(currentAcc2);

	}

	public void withdraw(Integer accountNum, BigDecimal amountToWithdraw){
		Boolean withdraw=false; // to check if the account does exist or not
		//int key=00;
		try{
			for(Map.Entry<Integer,SavingsAccount>entry : db.savingsAcc.entrySet()){
				if(entry.getKey()==accountNum){
					withdraw=true;
					try{
						if(amountToWithdraw.compareTo(entry.getValue().getBalance())==-1){
							//it is posible to withdraw
							BigDecimal temp  = entry.getValue().getBalance().subtract(amountToWithdraw);
							System.out.println("\nSuccessfuly withdrawn: R"+amountToWithdraw+" from account: "+accountNum);
							System.out.println("Remaining Balance: R"+temp);
							entry.getValue().setBalance(temp);
						}else{
							throw new Exception("Error! Withdraw amount is bigger than current balance");
						}
					}
					catch (Exception e){
						System.out.println(e);
					}
				}
			}
			for(Map.Entry<Integer,CurrentAccount>entry : db.currentAcc.entrySet()){
				if(entry.getKey()==accountNum){
					withdraw=true;
					try{
						BigDecimal over = entry.getValue().getOverdraft();
						BigDecimal b = entry.getValue().getBalance();
						BigDecimal sum = b.add(over);

						System.out.println("\nTotal amount that can be withdrawn: "+sum);
						System.out.println("Overdraft: R"+over+"\nBalance: R"+b+"\n");

						if(b.compareTo(amountToWithdraw)==1){
							System.out.println("\n********Withdrawn only from balance*********");
							BigDecimal temp = b.subtract(amountToWithdraw);
							System.out.println("Successfuly withdrawn: R"+amountToWithdraw+" from Current Account: "+accountNum);
							System.out.println("Remaining Balance: "+temp);
							entry.getValue().setBalance(temp);

						}else if(sum.compareTo(amountToWithdraw)==1){
							System.out.println("\n********Withdrawn only from balance and overdraft*********");

							BigDecimal temp = b.subtract(amountToWithdraw);
							temp = over.add(temp);

							if(b.compareTo(BigDecimal.valueOf(0.0))==1){
								b=BigDecimal.valueOf(0.0);
								entry.getValue().setBalance(b); //subtracticting from balance to make it zero
							}
							else{
								entry.getValue().setBalance(b);// balance was a negative value, keep it negative
							} 

							entry.getValue().setOverdraft(temp);
							System.out.println("Successfuly withdrawn: R"+amountToWithdraw+" from Current Account: "+accountNum);
							System.out.println("Remaining Balance: R"+b+"\nOverdraft: R"+temp);
						}
						else{
							throw new Exception("Error! Amount is greater than overdraft and balance");
						}
					}catch( Exception e){
						System.out.println(e);
					}
				}
			}
			if(!withdraw){
				throw new RuntimeException("Account does not Exist");
			}
		}catch (RuntimeException e){
			System.out.println(e);
		}
	}

}