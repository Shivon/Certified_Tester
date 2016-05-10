import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logic.Processing;
import logic.Storage;

public class Processing_Test
{
    private static final double EPS = 0.000000000000000000000001;
    private Processing pUnit;
    private Storage store;

    @Before
    public void setUp() throws Exception
    {
        store = new Storage();
        pUnit = new Processing( store );
    }

    @After
    public void tearDown() throws Exception
    {
        pUnit = null;
        store = null;
    }

    @Test
    public void basicMinus()
    {
        double subtrahend = 3.0,
                minuend = 5.0,
                expected = 2.0,
                actual;
        actual = pUnit.minus( minuend, subtrahend );
        assertEquals( expected, actual, EPS );
    }

    @Test
    public void guiMinus()
    {
        String minuend = "7",
                subtrahend = "5",
                expected = "2.0",
                actual;
        char operation = '-';
        pUnit.appendDigit( minuend );
        pUnit.operation( operation );
        pUnit.appendDigit( subtrahend );
        pUnit.equal();
        actual = pUnit.getNumberLine();
        assertEquals( expected, actual );
    }

    @Test
    public void guiPlus()
    {
        String summand = "7",
                summand2 = "5",
                expected = "12.0",
                actual;
        char operation = '+';
        pUnit.appendDigit( summand );
        pUnit.operation( operation );
        pUnit.appendDigit( summand2 );
        pUnit.equal();
        actual = pUnit.getNumberLine();
        assertEquals( expected, actual );
    }

    @Test
    public void guiDivision()
    {
        String dividend = "15",
                divisor = "5",
                expected = "3.0",
                actual;
        char operation = '/';
        pUnit.appendDigit( dividend );
        pUnit.operation( operation );
        pUnit.appendDigit( divisor );
        pUnit.equal();
        actual = pUnit.getNumberLine();
        assertEquals( expected, actual );
    }

    @Test
    public void guiMulti()
    {
        String factor = "5",
                factor2 = "5",
                expected = "25.0",
                actual;
        char operation = '*';
        pUnit.appendDigit( factor );
        pUnit.operation( operation );
        pUnit.appendDigit( factor2 );
        pUnit.equal();
        actual = pUnit.getNumberLine();
        assertEquals( expected, actual );
    }

    @Test
    public void equalNoStorage()
    {
        assertFalse( pUnit.equal() );
    }

    @Test
    public void operationMultipleOperations()
    {
        pUnit.appendDigit( "5" );
        pUnit.operation( '*' );
        pUnit.appendDigit( "5" );

        // pUnit.appendDigit( "5" );
        pUnit.operation( '*' );
        pUnit.appendDigit( "5" );
        pUnit.equal();

        assertEquals( "125", pUnit.getNumberLine() );
    }

    @Test
    public void pow()
    {
        pUnit.appendDigit( "2" );
        pUnit.pow();
        assertEquals( "4", pUnit.getNumberLine() );
    }

    @Test
    public void powIsNum()
    {
        pUnit.pow();
        assertEquals( "0.0", pUnit.getNumberLine() );
    }

    // @Test
    // public void equalNoOperator()
    // {
    // pUnit.appendDigit( "5&2" );
    // assertFalse( pUnit.equal() );
    // }

    @Test
    public void testAppendDigit()
    {
        String testeingabe = "2222222222222222222222";
        int expected = 21;

        pUnit.appendDigit( testeingabe );
        assertEquals( pUnit.getNumberLine().length(), expected );
    }

    @Test
    public void numLineZero()
    {
        pUnit.appendDigit( "0" );
        assertEquals( "0", pUnit.getNumberLine() );
    }

    @Test
    public void appendDotOnMaxNumLine()
    {
        pUnit.appendDot();

        pUnit.appendDigit( "2222222222222222222222" );
        pUnit.appendDot();
        assertFalse( ( "" + ( pUnit
                .getNumberLine().charAt( pUnit.getNumberLine().length() - 1 ) ) )
                        .equals( "." ) );
    }

    @Test
    public void appendDoubleDot()
    {
        pUnit.appendDot();
        pUnit.appendDigit( "2" );
        pUnit.appendDot();

        assertEquals( "0.2" , pUnit.getNumberLine() );
    }
}
