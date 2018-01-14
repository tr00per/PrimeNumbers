package sda.code.primes;

import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    private final Supplier<Integer> input;
    private final PrimeChecker primeChecker;

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            new Main(
                    () -> scan.nextInt(),
                    new PrimeChecker()
            ).run();
        }
    }

    public Main(Supplier<Integer> input, PrimeChecker primeChecker) {
        this.input = input;
        this.primeChecker = primeChecker;
    }

    void run() {
        Integer number = input.get();
        boolean isPrime = primeChecker.isPrime(number);
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
