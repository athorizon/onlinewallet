import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.capgemini.onlinewallet.dao.PushingData;
import com.capgemini.onlinewallet.dao.SaveRegisterUserData;
import com.capgemini.onlinewallet.service.AddAmountValidation;
import com.capgemini.onlinewallet.service.ShowBalanceValidation;

public class DaoTest {
	/*@BeforeAll
	void pushData()
	{
		new PushingData();
	}*/
	//Test cases of SaveRegisterUserData class
	ShowBalanceValidation obj=new ShowBalanceValidation();
	AddAmountValidation obj1=new AddAmountValidation();
	@Test
	public void validateLoginName()
	{   new PushingData();
		assertEquals(false,new SaveRegisterUserData().validateLoginName("walletarushi"));
		
	}
	@Test
	public void validateLoginNameTest()
	{new PushingData();
		assertEquals(true,new SaveRegisterUserData().validateLoginName("wallet"));
	}
	@Test
	public void saveUserData()
	{  new PushingData();
	   assertEquals(111004,new SaveRegisterUserData().saveUserData("Arushi", "1234", "Arushi1234", "8728925856"));
	}
	//Test cases of Connection class
	@Test
	public void showBalanceTest()
	{new PushingData();
		double d=obj.showBalance(111002);
		assertEquals(0.0,d);
	}
	/*@Test
	public void addAmountTest()
	{ new PushingData();
		double d1=obj1.addAmount(111001, 20000.0);
		assertEquals(20000.0,d1);
	}*/


}
