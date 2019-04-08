package eu.uhk.devschool.shoppinglist;

import eu.uhk.devschool.shoppinglist.support.junit.Calculator;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CalculatorUnitTest {

    // TODO: napsat testy na calculator pouze pomoci jUnit

    private Calculator calculator = new Calculator();

    @Test
    public void twoAndThreeIsFive() {
        long result = calculator.add(2, 3);
        assertTrue(result == 5);
    }

    @Test
    public void twoAndZeroIsTwo() {
        final long result = calculator.add(2, 0);
        assertThat(result, is(2L));
    }

    @Test
    public void twoAndMinusTwoIsZero() {
        final long result = calculator.add(2, -2);
        assertThat(result, is(0L));
    }

    @Test
    public void threeMinusTwoIsOne() {
        final long result = calculator.subtract(3, 2);
        assertThat(result, is(1L));
    }

    @Test

    public void threeMinusThreeIsZero() {
        final long result = calculator.subtract(3, 3);
        assertThat(result, is(0L));
    }

    @Test
    public void threeMinusMinusThreeIsSix() {
        final long result = calculator.subtract(3, -3);
        assertThat(result, is(6L));
    }

    @Test
    public void threeXThreeIsNine() {
        final long result = calculator.multiply(3, 3);
        assertThat(result, is(9L));
    }

    @Test
    public void threeXZeroIsZero() {
        final long result = calculator.multiply(3, 0);
        assertThat(result, is(0L));
    }

    @Test
    public void threeXMinusThreeIsMinusNine() {
        final long result = calculator.multiply(3, -3);
        assertThat(result, is(-9L));
    }

}
