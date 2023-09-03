import static org.junit.Assert.assertEquals;
import java.beans.Transient;
import org.junit.Test; 
//testing that it initially equals 0
public class CalculatorTest {
    @Test
    public void calculatorInitialValueZero() {
        Calculator calculator = new Calculator(); 
        assertEquals(0, calculator.getValue());
    }
}


