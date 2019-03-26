package eu.uhk.devschool.shoppinglist.support.junit;

public class Calculator {

    public long add(long first, long second) {
        return first + second;
    }

    public long subtract(long first, long second) {
        return first - second;
    }

    public long multiply(long first, long second) {
        return first * second;
    }

    public long divide(long first, long second) {
        if( second == 0 )
        {
            //nulou nelze dělit
            throw new java.lang.ArithmeticException("Nelze opravdu nelze dělit nulou!!!");
        }
        return first / second;
    }
}
