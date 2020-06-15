

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.cg.onlinewallet.exception.*;
import org.junit.jupiter.api.Test;
import com.cg.onlinewallet.service.*;
public class TestCases {

	public TestCases() {
		// TODO Auto-generated constructor stub
	}
	
    @Test
    void TC_01()
    {   OnlineWalletServiceImplementation object=new OnlineWalletServiceImplementation();
        
    	assertThrows(NullException.class,()->{object.checkId(null);});
    }
    @Test
    void TC_02()
    {   OnlineWalletServiceImplementation object=new OnlineWalletServiceImplementation();
        
    	assertThrows(NullException.class,()->{object.checkId(11008);});
    }
    @Test
    void TC_04() throws NullException
    {   OnlineWalletServiceImplementation object=new OnlineWalletServiceImplementation();
    	assertTrue(object.checkId(11002));
    	
    }
    @Test
    void TC_05()
    {   OnlineWalletServiceImplementation object=new OnlineWalletServiceImplementation();
        
    	assertThrows(ValidationException.class,()->{object.checkAmount(0);});
    }
    @Test
    void TC_06()
    {   OnlineWalletServiceImplementation object=new OnlineWalletServiceImplementation();
        
    	assertThrows(NegativeBalanceException.class,()->{object.checkAmount(-1);});
    }
    @Test
    void TC_07() throws ValidationException, NegativeBalanceException
    {   OnlineWalletServiceImplementation object=new OnlineWalletServiceImplementation();
    	assertTrue(object.checkAmount(500));
    }
    @Test
    void TC_08()
    {   OnlineWalletServiceImplementation object=new OnlineWalletServiceImplementation();
        
    	assertThrows(NegativeBalanceException.class,()->{object.checkBalance(11002,6000.00);});
    }
    @Test
    void TC_09()
    {   OnlineWalletServiceImplementation object=new OnlineWalletServiceImplementation();
        
    	assertThrows(NegativeBalanceException.class,()->{object.checkBalance(11002,5000.00);});
    }
    @Test
    void TC_10() throws NegativeBalanceException
    {   OnlineWalletServiceImplementation object=new OnlineWalletServiceImplementation();
        assertTrue(object.checkBalance(11002,500.00));
    }
    @Test
    void TC_11() throws NullException, InvalidNameException, ValidationException, InvalidPhoneNumberException, InvalidPasswordException
    {   OnlineWalletServiceImplementation object=new OnlineWalletServiceImplementation();
        Integer userId=object.registerUser("kunal", "kunal@123", "1234567890", "kunal123", 5000.00);
    	assertThrows(NullException.class,()->{object.transactMoney(userId, null, 500.00);});
    }
    @Test
    void TC_12() throws NullException, InvalidNameException, ValidationException, InvalidPhoneNumberException, InvalidPasswordException, NegativeBalanceException
    {   OnlineWalletServiceImplementation object=new OnlineWalletServiceImplementation();
        Integer userId=object.registerUser("kunal", "kunal@123", "1234567890", "kunal123", 5000.00);
        assertTrue(object.transactMoney(userId, 11002, 500.00));
    	
    }
}
