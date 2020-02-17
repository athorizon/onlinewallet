import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Test;

import com.capgemini.onlinewallet.service.AddAmountValidation;
import com.capgemini.onlinewallet.service.ShowBalanceValidation;
public class Test {
	@Test
	void showBalanceTest()
	{
		ShowBalanceValidation obj=new ShowBalanceValidation();
		assertEquals(0.0,obj.showBalance(111001));
	}
	@Test
	void addAmountTest()
	{
		AddAmountValidation obj1=new AddAmountValidation();
		assertEquals(0.0,obj1.addAmount(111001,0));
	}

}
