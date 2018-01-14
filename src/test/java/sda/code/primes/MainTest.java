package sda.code.primes;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class MainTest {

//    @Test
//    public void jestPierwsza() {
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

//    @Test
//    public void jestPierwsza() {
//        AtomicBoolean predicateWasRun = new AtomicBoolean(false);
//
//        Main main = Mockito.spy(new Main(
//                () -> 0,
//                new AlwaysTruePredicate(predicateWasRun, 0)
////                this::test
//        ));
//
//        main.run();
//
//        assertTrue(predicateWasRun.get());
//
//        Mockito.verify(main).success();
//        Mockito.verify(main, Mockito.never()).failure();
//    }

    static class ShallBeSuccessfulAction implements Action {
        private final AtomicBoolean actionWasRun;

        public ShallBeSuccessfulAction(AtomicBoolean actionWasRun) {
            this.actionWasRun = actionWasRun;
        }

        @Override
        public void success() {
            actionWasRun.set(true);
        }

        @Override
        public void failure() {
            fail("Wywołano nieprawidłową akcję");
        }
    }

    @Test
    public void jestPierwsza() {
        AtomicBoolean predicateWasRun = new AtomicBoolean(false);
        AtomicBoolean actionWasRun = new AtomicBoolean(false);

        Main main = new Main(
                () -> 0,
                new AlwaysTruePredicate(predicateWasRun, 0),
                new ShallBeSuccessfulAction(actionWasRun)
        );

        main.run();

        assertTrue("Predykat nie został wywołany", predicateWasRun.get());
        assertTrue("Akcja nie została wywołana", actionWasRun.get());
    }
}