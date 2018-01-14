package sda.code.primes;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    private final Supplier<Integer> input;
    private final Predicate<Integer> primeChecker;

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            new Main(
                    () -> scan.nextInt(),
//                  new PrimeChecker()
                    x -> new PrimeChecker().isPrime(x)
            ).run();
        }
    }

//  public Main(Supplier<Integer> input, PrimeChecker primeChecker) {
    public Main(Supplier<Integer> input, Predicate<Integer> primeChecker) {
        this.input = input;
        this.primeChecker = primeChecker;
    }

    void run() {
        Integer number = input.get();
//      boolean isPrime = primeChecker.isPrime(number);
        boolean isPrime = primeChecker.test(number);
        if (isPrime) {
            success();
        } else {
            failure();
        }
    }

    void success() {
        System.out.println("To jest liczba pierwsza");
    }

    void failure() {
        System.out.println("To NIE jest liczba pierwsza");
    }

}
