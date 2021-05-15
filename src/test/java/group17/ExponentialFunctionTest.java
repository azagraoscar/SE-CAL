package group17;

import static org.easymock.EasyMock.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExponentialFunctionTest {
    private ExponentialFunction expo;
    private NumberChecker mock;

    public ExponentialFunctionTest(){}

    @BeforeEach
    void setUp() {
        expo = new ExponentialFunction();
        mock = createMock(NumberChecker.class);
    }

    /**
     * JUnit Tests
     * @throws Exception
     */
    @Test
    public void ExponentialOf0() throws Exception {
        double expectedValue = 1;
        double obtainedValue = expo.compute(0);
        assertEquals(expectedValue, obtainedValue);
    }
    @Test
    public void ExponentialOf1() throws Exception {
        double expectedValue = Math.E;
        double obtainedValue = expo.compute(1);
        assertEquals(expectedValue, obtainedValue);
    }
    @Test
    public void ExponentialOf3() throws Exception {
        double expectedValue = 20.0855;
        double obtainedValue = expo.compute(3);
        assertEquals(expectedValue, obtainedValue, 0.001);
    }
    @Test
    public void ExponentialOfDouble() throws Exception {
        double expectedValue = 39.2510;
        double obtainedValue = expo.compute(3.67);
        assertEquals(expectedValue, obtainedValue, 0.001);
    }
    @Test
    public void ExponentialOfMinus2() throws Exception {
        double expectedValue = 0.1353;
        double obtainedValue = expo.compute(-2);
        assertEquals(expectedValue, obtainedValue, 0.001);
    }
    /**
     * Mock test
     */
    @Test
    public void calculateTest() throws Exception {
        System.out.println("Check if the number is greater than 1");
        double number1 = expo.compute(5);
        double number2 = expo.compute(-2);
        expect(mock.isGreaterThan1(number1)).andReturn(true);
        expect(mock.isGreaterThan1(number2)).andReturn(false);
        replay(mock);
        boolean res = expo.checkNumber(number1, mock);
        assertTrue(res);
        res = expo.checkNumber(number2, mock);
        assertFalse(res);
        verify(mock);
    }
}