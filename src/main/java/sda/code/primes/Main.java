package sda.code.primes;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    private final Supplier<Integer> input;
    private final Predicate<Integer> primeChecker;
    private final Action akcja;

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            new Main(
                    () -> scan.nextInt(),
//                  new PrimeChecker()
                    x -> new PrimeChecker().isPrime(x),
                    new AkcjaNaKonsolę()
            ).run();
        }
    }

//  public Main(Supplier<Integer> input, PrimeChecker primeChecker) {
//  public Main(Supplier<Integer> input, Predicate<Integer> primeChecker) {
    public Main(
            Supplier<Integer> input,
            Predicate<Integer> primeChecker,
            Action akcja
    ) {
        this.input = input;
        this.primeChecker = primeChecker;
        this.akcja = akcja;
    }

    void run() {
        Integer number = input.get();
//      boolean isPrime = primeChecker.isPrime(number);
        boolean isPrime = primeChecker.test(number);
        if (isPrime) {
            akcja.success();
        } else {
            akcja.failure();
        }
    }

}
