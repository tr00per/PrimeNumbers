package sda.code.primes;

import org.junit.Test;
import org.mockito.Mockito;

public class MainTest {

    @Test
    public void jestPiersze() {
        PrimeChecker checker = Mockito.mock(PrimeChecker.class);
        Mockito.when(checker.isPrime(Mockito.anyInt())).thenReturn(true);

        Main main = Mockito.spy(new Main(
                () -> 0,
                checker
        ));

        main.run();

        Mockito.verify(checker).isPrime(0);

        Mockito.verify(main).success();
        Mockito.verify(main, Mockito.never()).failure();
    }
}