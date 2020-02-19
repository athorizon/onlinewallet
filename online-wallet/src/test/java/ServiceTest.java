
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.capgemini.onlinewallet.exception.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.capgemini.onlinewallet.dao.Connection;
import com.capgemini.onlinewallet.dao.PushingData;
import com.capgemini.onlinewallet.dao.SaveRegisterUserData;
import com.capgemini.onlinewallet.service.AddAmountValidation;
import com.capgemini.onlinewallet.service.ShowBalanceValidation;
import com.capgemini.onlinewallet.service.Transaction;
import com.capgemini.onlinewallet.service.UserDataValidation;

public class ServiceTest {
		//Test cases for RegisterUser Module
	//Test cases for Service package
	
		@Test
	public void checkIdEntryTest()
	{   new PushingData();
		assertEquals(true,new Connection().checkIDEntry(111003));
	}
	@Test
	public void checkIdEntryTest1()
	{new PushingData();
		assertEquals(false,new Connection().checkIDEntry(111005));

	}
	@Test
	public void checkLoginIdEntryTest()
	{new PushingData();
		assertEquals(false,new Connection().checkLoginEntry("walletarushi"));
	}
	@Test
	public void checkLoginIdEntryTest1()
	{new PushingData();
		assertEquals(true,new Connection().checkLoginEntry("wallet"));
	}
    @Test
    public void checkBalanceTest()
    {new PushingData();
    	assertEquals(false,new Connection().checkBalance(111003,2000.0));
    }
    @Test
    
    	public void checkNullTest()
    {new PushingData();
    		assertThrows(NullValueException.class,()->{new UserDataValidation().checkNull(null);});
    	}
    @Test
    public void checkNumberTest()
    {new PushingData();
    	assertThrows(ValidationException.class,()->{new UserDataValidation().checkNumber("12345678");});
    	
    	
    }
    @Test
    public void checkNumberTest1()
    {new PushingData();
    	assertThrows(ValidationException.class,()->{new UserDataValidation().checkNumber("123456789");});

    }
    	@Test
    	public void checkPasswordTest()
    	{new PushingData();
    		assertThrows(ValidationException.class,()->{new UserDataValidation().checkNumber("1234");});
    		
    	}
    	@Test
    	public void checkPasswordTest1()
    	{new PushingData();
    		assertThrows(ValidationException.class,()->{new UserDataValidation().checkPassword("1234");});
    	}
    	@Test
    	public void checkAmountTest()
    	{new PushingData();
    		assertEquals(true,new Transaction().checkAmount(2000.0));
    	}
    	@Test
    	public void checkAmountTest1()
    	{new PushingData();
    		assertEquals(false,new Transaction().checkAmount(0.0));
    	}
    	
    	
    
    
}
