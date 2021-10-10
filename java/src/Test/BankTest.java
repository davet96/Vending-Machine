import com.techelevator.Bank;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;

public class BankTest {



    @Before
    public void setup(){
        System.out.println("Beginning of Bank Test");
    }

    @After
    public void teardown(){
        System.out.println("Ending of Bank Test");
    }

//    @Test
//    public void returnChange(){
//        //Arrange
//        Bank testGroup = new Bank();
//        int expectedValue = 0;
//        //Act
//        int result = testGroup.makeChange();
//        //Assert
//    }
@Test
    public void newCurrentBalance(){
        // arrange
        Bank testGroup = new Bank();
            int expectedValue = 10;
            // act
        int result = testGroup.addMoneyToCurrentBalance(10);
        //assert
        Assert.assertEquals(expectedValue, result);

    }

    @Test
    public void newBalanceFromSubtracting(){
        //Arrange
        Bank testGroup = new Bank();
        int expectedValue = -75;
        //Act
        int result = testGroup.subtractMoneyFromCurrentBalance(75);

        // Assert
        Assert.assertEquals(result,expectedValue);

    }


}
