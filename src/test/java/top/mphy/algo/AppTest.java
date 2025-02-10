package top.mphy.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    void testSum() {
        Assertions.assertEquals(3.1, App.sum(1.5, 1.6));
    }
}
