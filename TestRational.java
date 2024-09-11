import java.math.BigInteger;
import java.util.Scanner;

public class TestRational {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input first rational number
        System.out.print("Enter the first rational number (numerator denominator): ");
        BigInteger num1 = scanner.nextBigInteger();
        BigInteger den1 = scanner.nextBigInteger();
        Rational r1 = new Rational(num1, den1);
        
        // Input second rational number
        System.out.print("Enter the second rational number (numerator denominator): ");
        BigInteger num2 = scanner.nextBigInteger();
        BigInteger den2 = scanner.nextBigInteger();
        Rational r2 = new Rational(num2, den2);
        
        // Perform operations
        Rational sum = r1.add(r2);
        Rational difference = r1.subtract(r2);
        Rational product = r1.multiply(r2);
        Rational quotient = r1.divide(r2);
        
        // Display results
        System.out.println(r1 + " + " + r2 + " = " + sum);
        System.out.println(r1 + " - " + r2 + " = " + difference);
        System.out.println(r1 + " * " + r2 + " = " + product);
        System.out.println(r1 + " / " + r2 + " = " + quotient);
        System.out.println(r2 + " is " + r2.toDouble());
        
        scanner.close();
    }
}
