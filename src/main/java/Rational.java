class Rational {

    private static final String zeroDenominatorErrorMessage = "Denominator can't be zero";
    private static final String otherObjectErrorMessage = "This object is not Rational";

    long numerator, denominator;

    Rational() {
        numerator = 0;
        denominator = 0;
    }

    Rational(long numerator, long denominator) throws Illegal {
        if (denominator == 0) {
            throw new Illegal(Rational.zeroDenominatorErrorMessage);
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static void main(String[] args) {
        System.out.println("This is Rational class.");
    }

    // find the reduce form 
    private void simplestForm() {
        long computeGCD;
        computeGCD = GCD(Math.abs(numerator), denominator);
        numerator /= computeGCD;
        denominator /= computeGCD;
    }

    // find the greatest common denominator 
    private long GCD(long a, long b) {
        if (a % b == 0) return b;
        else return GCD(b, a % b);
    }

    /***
     * Compute an addition of the current rational number to another given rational number
     * @param x the rational number to be added to the current rational number
     */
    public void add(Rational x) {
        if (denominator == 0 || x.denominator == 0) {
            throw new IllegalArgumentException(Rational.zeroDenominatorErrorMessage);
        }

        numerator = (numerator * x.denominator) + (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    /***
     * Compute a subtraction of the current rational number to another given rational number
     * @param x the rational number to be subtracted from the current rational number
     */
    public void subtract(Rational x) {
        if (denominator == 0 || x.denominator == 0) {
            throw new IllegalArgumentException(Rational.zeroDenominatorErrorMessage);
        }

        numerator = (numerator * x.denominator) - (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    /***
     * Compute a multiplication of the current rational number to another given rational number
     * @param x the rational number to be multiplied to the current rational number
     */
    public void multiply(Rational x) {
        if (denominator == 0 || x.denominator == 0) {
            throw new IllegalArgumentException(Rational.zeroDenominatorErrorMessage);
        }

        numerator = numerator * x.numerator;
        denominator = denominator * x.denominator;
        simplestForm();
    }

    /***
     * Compute a division of the current rational number to another given rational number
     * @param x the rational number to be divided by the current rational number
     */
    public void divide(Rational x) {
        if (denominator == 0 || x.denominator == 0) {
            throw new IllegalArgumentException(Rational.zeroDenominatorErrorMessage);
        }

        numerator = numerator * x.denominator;
        denominator = denominator * x.numerator;
        simplestForm();
    }

    /***
     * Check if the given rational number equals to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return true if the given rational number equals to the current, false otherwise
     */
    public boolean equals(Object x) {
        if (!(x instanceof Rational)) {
            return false;
        }

        Rational other = (Rational) x;

        if (denominator == 0 || other.denominator == 0) {
            throw new IllegalArgumentException(Rational.zeroDenominatorErrorMessage);
        }

        other.simplestForm();

        return numerator == other.numerator && denominator == other.denominator; // TODO: This needs to be modified.
    }

    /***
     * Compare the current rational number to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return -1 if the current rational number is less than the given number, 0 if they're equal, 1 if the current
     * rational number is larger than the given number
     */
    public long compareTo(Object x) {
        if (!(x instanceof Rational)) {
            throw new IllegalArgumentException(Rational.otherObjectErrorMessage);
        }

        Rational other = (Rational) x;

        if (denominator == 0 || other.denominator == 0) {
            throw new IllegalArgumentException(Rational.zeroDenominatorErrorMessage);
        }

        long thisNumerator = numerator * other.denominator;
        long otherNumerator = other.numerator * this.denominator;

        // Compare the numerators
        return Long.compare(thisNumerator, otherNumerator);
    }

    /***
     * Give the formatted string of the rational number
     * @return the string representation of the rational number. For example, "1/2", "3/4".
     */
    public String toString() {
        if (denominator == 0) {
            throw new RuntimeException(new Rational.Illegal(Rational.zeroDenominatorErrorMessage));
        }
        return numerator + "/" + denominator;
    }

    class Illegal extends Exception {
        String reason;

        Illegal(String reason) {
            this.reason = reason;
        }
    }
}