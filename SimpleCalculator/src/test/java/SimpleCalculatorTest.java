import com.company.SimpleCalculator;

import javax.swing.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Wilhelm on 28.06.2017.
 */
public class SimpleCalculatorTest {

    private SimpleCalculator simpleCalculator;

    @org.junit.Before
    public void setUp() throws Exception {
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        simpleCalculator = new SimpleCalculator();
        frame.add(simpleCalculator);
        frame.pack();
        frame.setVisible(true);
    }

    @org.junit.Test
    public void test5() throws Exception {
        simpleCalculator.setDividendField("Abc");
        simpleCalculator.setDividerField("15");
        simpleCalculator.calculate();

        assertEquals("Error. Not a number.", simpleCalculator.getResultArea());
    }

    @org.junit.Test
    public void test7() throws Exception {
        simpleCalculator.setDividendField("10");
        simpleCalculator.setDividerField("0");
        simpleCalculator.calculate();

        assertEquals("Error. Division by zero.", simpleCalculator.getResultArea());
    }

    @org.junit.Test
    public void test8() throws Exception {
        simpleCalculator.setDividendField("2");
        simpleCalculator.setDividerField("2");
        simpleCalculator.calculate();

        assertEquals("1.0", simpleCalculator.getResultArea());
    }

    @org.junit.Test
    public void test11() throws Exception {
        simpleCalculator.setDividendField("3000.2");
        simpleCalculator.setDividerField("140.1");
        simpleCalculator.calculate();

        assertEquals("21.414703783012133", simpleCalculator.getResultArea());
    }

}