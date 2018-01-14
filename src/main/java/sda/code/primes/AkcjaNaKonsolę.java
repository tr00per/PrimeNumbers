package sda.code.primes;

public class AkcjaNaKonsolę implements Action {
    @Override
    public void success() {
        System.out.println("To jest liczba pierwsza");
    }

    @Override
    public void failure() {
        System.out.println("To NIE jest liczba pierwsza");
    }
}
