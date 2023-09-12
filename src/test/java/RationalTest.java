import org.junit.Assert;
import org.junit.Test;

public class RationalTest {

    @Test()
    public void testZeroDenominatorConstructor() {
        Assert.assertThrows(Rational.Illegal.class, () -> new Rational(1, 0));
        Assert.assertThrows(Rational.Illegal.class, () -> new Rational(2, 0));
    }

    /// Add Method
    ///

    @Test
    public void testAddPositiveRationalNumber() {
        Rational x = new Rational();
        x.numerator = 1;
        x.denominator = 2;
        Rational y = new Rational();
        y.numerator = 1;
        y.denominator = 4;
        x.add(y);
        Assert.assertEquals(3, x.numerator);
        Assert.assertEquals(4, x.denominator);
    }

    @Test
    public void testAddNegativeRationalNumber() {
        Rational x = new Rational();
        x.numerator = -3;
        x.denominator = 4;
        Rational y = new Rational();
        y.numerator = 1;
        y.denominator = 4;
        x.add(y);
        Assert.assertEquals(-1, x.numerator);
        Assert.assertEquals(2, x.denominator);
    }

    @Test
    public void testAddZeroNumerator() {
        Rational x = new Rational();
        x.numerator = 0;
        x.denominator = 4;
        Rational y = new Rational();
        y.numerator = 1;
        y.denominator = 4;
        x.add(y);
        Assert.assertEquals(1, x.numerator);
        Assert.assertEquals(4, x.denominator);
    }

    @Test
    public void testAddZeroDenominator() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Rational x = new Rational();
            x.numerator = -3;
            x.denominator = 0;
            Rational y = new Rational();
            y.numerator = 1;
            y.denominator = 4;
            x.add(y);

            Rational a = new Rational();
            a.numerator = -3;
            a.denominator = 1;
            Rational b = new Rational();
            b.numerator = 1;
            b.denominator = 0;
            a.add(b);
        });
    }

    @Test
    public void testAddWholeNumber() {
        Rational x = new Rational();
        x.numerator = 4;
        x.denominator = 4;
        Rational y = new Rational();
        y.numerator = 6;
        y.denominator = 3;
        x.add(y);
        Assert.assertEquals(3, x.numerator);
        Assert.assertEquals(1, x.denominator);
    }

    /// Subtract Method
    ///

    @Test
    public void testSubtractPositiveNumber() throws Rational.Illegal {
        Rational x = new Rational(3, 4);
        Rational y = new Rational(1, 4);
        x.subtract(y);
        Assert.assertEquals(1, x.numerator);
        Assert.assertEquals(2, x.denominator);
    }

    @Test
    public void testSubtractNegativeNumber() throws Rational.Illegal {
        Rational x = new Rational(-3, 4);
        Rational y = new Rational(1, 4);
        x.subtract(y);
        Assert.assertEquals(-1, x.numerator);
        Assert.assertEquals(1, x.denominator);
    }

    @Test
    public void testSubtractZeroNumerator() throws Rational.Illegal {
        Rational x = new Rational(0, 1);
        Rational y = new Rational(1, 4);
        x.subtract(y);
        Assert.assertEquals(-1, x.numerator);
        Assert.assertEquals(4, x.denominator);
    }

    @Test
    public void testSubtractZeroDenominator() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Rational x = new Rational();
            x.numerator = 4;
            x.denominator = 0;
            Rational y = new Rational();
            y.numerator = 6;
            y.denominator = 1;
            x.subtract(y);

            Rational a = new Rational();
            a.numerator = -3;
            a.denominator = 1;
            Rational b = new Rational();
            b.numerator = 1;
            b.denominator = 0;
            a.subtract(b);
        });
    }

    @Test
    public void testSubtractWholeNumber() throws Rational.Illegal {
        Rational x = new Rational(6, 1);
        Rational y = new Rational(3, 1);
        x.subtract(y);
        Assert.assertEquals(3, x.numerator);
        Assert.assertEquals(1, x.denominator);
    }


    /// Multiply Method
    ///

    @Test
    public void testMultiplyPositiveNumber() throws Rational.Illegal {
        Rational x = new Rational(1, 2);
        Rational y = new Rational(2, 3);
        x.multiply(y);
        Assert.assertEquals(1, x.numerator);
        Assert.assertEquals(3, x.denominator);
    }

    @Test
    public void testMultiplyNegativeNumber() throws Rational.Illegal {
        Rational x = new Rational(-1, 2);
        Rational y = new Rational(2, 3);
        x.multiply(y);
        Assert.assertEquals(-1, x.numerator);
        Assert.assertEquals(3, x.denominator);
    }

    @Test
    public void testMultiplyZeroNumerator() throws Rational.Illegal {
        Rational x = new Rational(0, 1);
        Rational y = new Rational(2, 3);
        x.multiply(y);
        Assert.assertEquals(0, x.numerator);
        Assert.assertEquals(1, x.denominator);
    }

    @Test
    public void testMultiplyZeroDenominator() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Rational x = new Rational();
            x.numerator = 1;
            x.denominator = 0;
            Rational y = new Rational();
            y.numerator = 2;
            y.denominator = 1;
            x.multiply(y);

            Rational a = new Rational();
            a.numerator = -3;
            a.denominator = 1;
            Rational b = new Rational();
            b.numerator = 1;
            b.denominator = 0;
            a.multiply(b);
        });
    }

    @Test
    public void testMultiplyWholeNumber() throws Rational.Illegal {
        Rational x = new Rational(2, 1);
        Rational y = new Rational(3, 1);
        x.multiply(y);
        Assert.assertEquals(6, x.numerator);
        Assert.assertEquals(1, x.denominator);
    }

    /// Divide Method
    ///


    @Test
    public void testDividePositiveNumber() throws Rational.Illegal {
        Rational x = new Rational(1, 2);
        Rational y = new Rational(2, 3);
        x.divide(y);
        Assert.assertEquals(3, x.numerator);
        Assert.assertEquals(4, x.denominator);
    }

    @Test
    public void testDivideNegativeNumber() throws Rational.Illegal {
        Rational x = new Rational(-1, 2);
        Rational y = new Rational(2, 3);
        x.divide(y);
        Assert.assertEquals(-3, x.numerator);
        Assert.assertEquals(4, x.denominator);
    }

    @Test
    public void testDivideZeroNumerator() throws Rational.Illegal {
        Rational x = new Rational(0, 1);
        Rational y = new Rational(2, 3);
        x.divide(y);
        Assert.assertEquals(0, x.numerator);
        Assert.assertEquals(1, x.denominator);
    }

    @Test
    public void testDivideZeroDenominator() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Rational x = new Rational();
            x.numerator = 1;
            x.denominator = 0;
            Rational y = new Rational();
            y.numerator = 2;
            y.denominator = 1;
            x.divide(y);

            Rational a = new Rational();
            a.numerator = -3;
            a.denominator = 1;
            Rational b = new Rational();
            b.numerator = 1;
            b.denominator = 0;
            a.divide(b);
        });
    }

    @Test
    public void testDivideWholeNumber() throws Rational.Illegal {
        Rational x = new Rational(4, 1);
        Rational y = new Rational(2, 1);
        x.divide(y);
        Assert.assertEquals(2, x.numerator);
        Assert.assertEquals(1, x.denominator);
    }

    /// Equals Method
    ///

    @Test
    public void testEqualsBoth() throws Rational.Illegal {
        Rational x = new Rational(1, 2);
        Rational y = new Rational(2, 4);
        Assert.assertEquals(x, y);
    }

    @Test
    public void testEqualsOtherObject() throws Rational.Illegal {
        Rational x = new Rational(1, 2);
        Assert.assertNotEquals("1/2", x);
    }

    @Test
    public void testEqualsOnlyNumerator() throws Rational.Illegal {
        Rational x = new Rational(1, 2);
        Rational y = new Rational(1, 3);
        Assert.assertNotEquals(x, y);
    }

    @Test
    public void testEqualsOnlyDenominator() throws Rational.Illegal {
        Rational x = new Rational(2, 3);
        Rational y = new Rational(3, 3);
        Assert.assertNotEquals(x, y);
    }

    @Test
    public void testEqualsZeroDenominator() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Rational x = new Rational();
            x.numerator = 1;
            x.denominator = 0;
            Rational y = new Rational();
            y.numerator = 2;
            y.denominator = 1;
            x.equals(y);

            Rational a = new Rational();
            a.numerator = -3;
            a.denominator = 1;
            Rational b = new Rational();
            b.numerator = 1;
            b.denominator = 0;
            a.equals(b);
        });
    }

    @Test
    public void testNotEquals() throws Rational.Illegal {
        Rational x = new Rational(1, 2);
        Rational y = new Rational(3, 4);
        Assert.assertNotEquals(x, y);
    }

    /// CompareTo Method
    ///

    @Test
    public void testCompareToEquals() throws Rational.Illegal {
        Rational x = new Rational(1, 2);
        Rational y = new Rational(2, 4);
        Assert.assertEquals(0, x.compareTo(y));
    }

    @Test
    public void testCompareToMoreThan() throws Rational.Illegal {
        Rational x = new Rational(3, 4);
        Rational y = new Rational(1, 2);
        Assert.assertEquals(1, x.compareTo(y));
    }

    @Test
    public void testCompareToLessThan() throws Rational.Illegal {
        Rational x = new Rational(1, 4);
        Rational y = new Rational(1, 2);
        Assert.assertEquals(-1, x.compareTo(y));
    }

    @Test
    public void testCompareToZeroDenominator() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Rational x = new Rational();
            x.numerator = 1;
            x.denominator = 0;
            Rational y = new Rational();
            y.numerator = 2;
            y.denominator = 1;
            x.compareTo(y);

            Rational a = new Rational();
            a.numerator = -3;
            a.denominator = 1;
            Rational b = new Rational();
            b.numerator = 1;
            b.denominator = 0;
            a.compareTo(b);
        });
    }

    @Test
    public void testCompareToOtherObject() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Rational x = new Rational(1, 2);
            String y = "1/2";
            x.compareTo(y);
        });
    }

    /// toString Method
    ///

    @Test
    public void testToString() throws Rational.Illegal {
        Rational x = new Rational(3, 4);
        Assert.assertEquals(x.toString(), "3/4");

        Rational y = new Rational();
        y.numerator = 1;
        y.denominator = 0;

    }

}
