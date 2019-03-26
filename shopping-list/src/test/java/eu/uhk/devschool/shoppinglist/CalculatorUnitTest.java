package eu.uhk.devschool.shoppinglist;

import org.junit.Assert;
import org.junit.Test;

import eu.uhk.devschool.shoppinglist.support.junit.Calculator;

public class CalculatorUnitTest {

    // TODO: napsat testy na Calculator pouze pomoci jUnit, hotovo

    private Calculator calculator = new Calculator();

    @Test
    public void twoAndThreeIsFive() throws Exception{
        final long result = calculator.add(10,3);
        Assert.assertEquals(result , 13);
    }

    @Test
    public void subtract() throws Exception {
        final long result = calculator.subtract(25,5);
        Assert.assertEquals(result , 20);
       // Assert.assertThat(result, is(20));  import org.hamcrest.Matchers.is;
    }

    @Test
    public void multiply() throws Exception {
        final long result = calculator.multiply(5,3);
        Assert.assertEquals(result , 15);
    }

    @Test
    public void divide() throws Exception {
        final long result = calculator.divide(100,10);
        Assert.assertEquals(result , 10);
    }

    // test na dělení nulou
    @Test(expected = ArithmeticException.class)
    public void divideByZero() throws Exception {
        final long result = calculator.divide(2,0);
        Assert.assertEquals(result , 0);
    }
}
