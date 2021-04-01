import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class CosTest {
    @Test
    public void testMaxNumbers() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Cos.calculateCos(Double.MAX_VALUE, 0.0000000001) );
    }

    @Test
    public void testMinNumbers() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Cos.calculateCos(Double.MIN_VALUE, 0.0000000001) );
    }

    @Test
    public void testInf() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Cos.calculateCos(Double.POSITIVE_INFINITY, 0.0000000001) );
    }

    @Test
    public void testNegInf() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  Cos.calculateCos(Double.NEGATIVE_INFINITY, 0.0000000001) );
    }

    @Test
    public void testBigAccuracy() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  Cos.calculateCos(60, 1) );
    }

    @Test
    public void testZeroAccuracy() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  Cos.calculateCos(60, 0) );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testvalues.csv")
    void testTableValues(double val, double expected) {
        Assertions.assertEquals(expected, Cos.calculateCos(val, 0.0000000001), 0.0000000001);
    }
}