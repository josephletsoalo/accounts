import java.math.BigDecimal;


class SavingsAccount{

	//variables
	private int accountNumber;
	private BigDecimal balance;

	public SavingsAccount(int accountNumber, BigDecimal balance){
	
		this.accountNumber=accountNumber;
		this.balance=balance;
	}
	public int getAccount(){
		return accountNumber;
	}
	public BigDecimal getBalance(){
		return balance;
	}
	public void setBalance(BigDecimal balance){
		this.balance = balance;
	}

}