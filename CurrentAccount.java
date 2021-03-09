import java.math.BigDecimal;

class CurrentAccount{

	//variables
	private int accountNumber;
	private BigDecimal balance;
	private BigDecimal overdraft;

	public CurrentAccount(int accountNumber, BigDecimal balance, BigDecimal
		overdraft){
		this.accountNumber=0;
		this.balance=balance;
		this.overdraft=overdraft;
	}
	public int getAccount(){
		return accountNumber;
	}
	public BigDecimal getBalance(){
		return balance;
	}
	public BigDecimal getOverdraft(){
		return overdraft;
	}
	public void setBalance(BigDecimal balance){
		this.balance = balance;
	}
	public void setOverdraft(BigDecimal overdraft){
		this.overdraft = overdraft;
	}

}