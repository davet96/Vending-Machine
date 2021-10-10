import com.techelevator.VendingMachine;
import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {


    @Test
    public void moneyDisplay() {
        VendingMachine testGroup = new VendingMachine();
        String expectedValue = "$3.65";

        String result = testGroup.formatMoneyForInternalUse("A4");

        Assert.assertEquals(result, expectedValue);
    }

    @Test
    public void testMoneyFormat() {
        VendingMachine testGroup = new VendingMachine();
        String expectedValue = "$9.99";

        String result = testGroup.formatMoneyOutput(999);

        Assert.assertEquals(result, expectedValue);
    }

    @Test
    public void over10() {
        VendingMachine testGroup = new VendingMachine();
        String expectedValue = "$10.01";

        String result = testGroup.formatMoneyOutput(1001);

        Assert.assertEquals(result, expectedValue);
    }
    @Test
    public void lessThan1() {
        VendingMachine testGroup = new VendingMachine();
        String expectedValue = "$0.99";

        String result = testGroup.formatMoneyOutput(99);

        Assert.assertEquals(result, expectedValue);
    }
    @Test
    public void testForZero() {
        VendingMachine testGroup = new VendingMachine();
        String expectedValue = "$0.00";

        String result = testGroup.formatMoneyOutput(0);

        Assert.assertEquals(result, expectedValue);
    }

}
