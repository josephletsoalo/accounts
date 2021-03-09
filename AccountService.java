import java.math.BigDecimal;
public interface AccountService {

public void populateDB();
public void withdraw(Integer accountNum, BigDecimal amountToWithdraw);

}

