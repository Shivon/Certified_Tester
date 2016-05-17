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
        
        assertEquals("4", store.getNumberLine());
        assertEquals( "4", pUnit.getNumberLine() );
        assertEquals("(" + 2 + ")\u00B2", pUnit.getEquationLine());
    }

    @Test
    public void powIsNum()
    {
        pUnit.pow();
        assertEquals( "0.0", pUnit.getNumberLine() );
    }

     @Test
     public void equalNoOperator()
     {
	     pUnit.appendDigit( "5" );
	     pUnit.operation('&');
	     pUnit.appendDigit("3");
	     pUnit.equal();
	     assertEquals(false, pUnit.getNumberLine());
     }
     
     @Test
     public void notANumber()
     {
    	 pUnit.appendDigit("k");
    	 
    	 assertEquals("k", pUnit.getNumberLine());
     }

    @Test
    public void testAppendDigit()
    {
    	 pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
         pUnit.appendDigit( "2" );
      //   String testeingabe = pUnit.getNumberLine();
        int expected = 21;

       // pUnit.appendDigit( testeingabe );
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

        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDigit( "2" );
        pUnit.appendDot();
        assertFalse( ( "" + ( pUnit
                .getNumberLine().charAt( pUnit.getNumberLine().length() - 1 ) ) )
                        .equals( "." ) );
    }
    
    @Test
    public void divZero()
    {
    	pUnit.div(6.0, 2.0);
    	
    	assertEquals(3.0, pUnit.getNumberLine());
    }
    
    @Test
    public void negativeBasePower()
    {
    	pUnit.power(-2.0, 2);
    	
    	assertEquals("4", pUnit.getNumberLine());
    }
    
    @Test
    public void negativePow()
    {
    	pUnit.appendDigit("5");
    	pUnit.operation('-');
    	pUnit.appendDigit("7");
    	pUnit.pow();
    	
    	assertEquals("4", pUnit.getNumberLine());
    }

    @Test
    public void appendDoubleDot()
    {
        pUnit.appendDot();
        pUnit.appendDigit( "2" );
        pUnit.appendDot();

        assertEquals( "0.2" , pUnit.getNumberLine() );
    }
    
    @Test
    public void appendDotIfEmpty()
    {
    	pUnit.appendDot();
    	
    	assertEquals("0.", pUnit.getNumberLine());
    }
    
    @Test
    public void equationLine()
    {
    	pUnit.appendDigit("5");
    	pUnit.operation('-');
    	pUnit.appendDigit("5");
    	pUnit.equal();
    	
    	assertEquals("5-5", pUnit.getEquationLine());
    }
    
    @Test
    public void maxDigits()
    {
    	// ein Zeichen zu viel? oder dürfen 22?
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	assertEquals(false, pUnit.appendDigit("2"));
    	
    }
    
    @Test 
    public void clearProcessing()
    {
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.clear();
    	
    	assertEquals("0", pUnit.getNumberLine());
    }
    
    @Test
    public void backspaceToEmpty()
    {
    	pUnit.appendDigit("2");
    	pUnit.backspace();
    	
    	assertEquals("0", pUnit.getNumberLine());
    }
    
    @Test 
    public void backspaceWith2Digits()
    {
    	pUnit.appendDigit("2");
    	pUnit.appendDigit("2");
    	pUnit.backspace();
    	
    	assertEquals(1, pUnit.getNumberLine().length());
    }
    
    @Test
    public void backspaceDouble()
    {
    	pUnit.appendDigit("5");
    	pUnit.operation('-');
    	pUnit.appendDigit("2");
    	pUnit.equal();
    	pUnit.backspace();
    	
    	assertEquals("3.", pUnit.getNumberLine());
  
    }
    
    @Test 
    public void sqrtWithRadicand()
    {
    	pUnit.appendDigit("4");
    	pUnit.sqrt(2.0);
    	
    	assertEquals("2", pUnit.getNumberLine());
    	
    }
    
    @Test 
    public void sqrt()
    {
    	pUnit.appendDigit("4");
    	pUnit.sqrt();
    	
    	assertEquals("2", pUnit.getNumberLine());
    	assertEquals("\u221A(" + 2 + ")", pUnit.getEquationLine());
    }
    
    @Test 
    public void negativeSqrt()
    {
    	pUnit.appendDigit("1");
    	pUnit.operation('-');
    	pUnit.appendDigit("3");
    	
    	pUnit.sqrt();
    	
    	assertEquals(false, pUnit.getNumberLine());
    }
 
    @Test 
    public void getNumberLine()
    {
    	pUnit.appendDigit("2");
    	
    	assertEquals("2", pUnit.getNumberLine());
    }
}
