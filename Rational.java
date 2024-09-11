import java.math.BigInteger;

public class Rational {
    private BigInteger numerator;
    private BigInteger denominator;
    
    // Constructor
    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        
        // Normalize the rational number
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
        
        // Handle negative denominator
        if (this.denominator.compareTo(BigInteger.ZERO) < 0) {
            this.numerator = this.numerator.negate();
            this.denominator = this.denominator.negate();
        }
    }
    
    // Add two rational numbers
    public Rational add(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator)
                .add(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }
    
    // Subtract two rational numbers
    public Rational subtract(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator)
                .subtract(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }
    
    // Multiply two rational numbers
    public Rational multiply(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.numerator);
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }
    
    // Divide two rational numbers
    public Rational divide(Rational other) {
        if (other.numerator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        BigInteger newNumerator = this.numerator.multiply(other.denominator);
        BigInteger newDenominator = this.denominator.multiply(other.numerator);
        return new Rational(newNumerator, newDenominator);
    }
    
    // Convert rational number to double
    public double toDouble() {
        return new BigDecimal(numerator).divide(new BigDecimal(denominator), 16, RoundingMode.HALF_UP).doubleValue();
    }
    
    // Override toString method
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
