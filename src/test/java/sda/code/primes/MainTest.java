package sda.code.primes;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

//    @Test
//    public void jestPiersze() {
//        PrimeChecker checker = Mockito.mock(PrimeChecker.class);
//        Mockito.when(checker.isPrime(Mockito.anyInt())).thenReturn(true);
//
//        Main main = Mockito.spy(new Main(
//                () -> 0,
//                checker
//        ));
//
//        main.run();
//
//        Mockito.verify(checker).isPrime(0);
//
//        Mockito.verify(main).success();
//        Mockito.verify(main, Mockito.never()).failure();
//    }

    static class AlwaysTruePredicate implements Predicate<Integer> {

        private final AtomicBoolean predicateWasRun;
        private final int expectedInt;

        public AlwaysTruePredicate(AtomicBoolean predicateWasRun, Integer expectedInt) {
            this.predicateWasRun = predicateWasRun;
            this.expectedInt = expectedInt;
        }

        @Override
        public boolean test(Integer x) {
            predicateWasRun.set(true);
            assertEquals(expectedInt, x.intValue());
            return true;
        }
    }
//
//    public boolean test(Integer x) {
//        return x == 0;
//    }

    @Test
    public void jestPiersze() {
        AtomicBoolean predicateWasRun = new AtomicBoolean(false);

        Main main = Mockito.spy(new Main(
                () -> 0,
                new AlwaysTruePredicate(predicateWasRun, 0)
//                this::test
        ));

        main.run();

        assertTrue(predicateWasRun.get());

        Mockito.verify(main).success();
        Mockito.verify(main, Mockito.never()).failure();
    }
}