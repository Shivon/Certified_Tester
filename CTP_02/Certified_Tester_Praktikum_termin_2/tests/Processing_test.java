import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logic.Processing;
import logic.Storage;

public class Processing_test {
	
	Processing process;
	Storage storage;

  @Before
  public void setUp() throws Exception {
	 storage = new Storage();
	 process = new Processing(storage);
	 
  }

  @After
  public void tearDown() throws Exception {
  }
//
//  @Test
//  public void testCButton() {
//	process.appendDigit("12212"); 
//	process.clear();
//	assertTrue(process.getEquationLine().isEmpty());
//    assertEquals("0", process.getNumberLine());
//    assertTrue(Double.isNaN(storage.getNum()));
//  }
//  
//  @Test
//  public void testOneMinusOne(){
//	 storage.setNum(1.0);
//	 System.out.println(""+storage.getNum());
//	 assertTrue(storage.getNum()== 1.0 );
//  }
//  
//  @Test
//  public void testWrongInfinity(){
//	 storage.setNum(process.div(0, 2));
//	 System.out.println(""+storage.getNum());
//	  assertTrue(storage.getNum()== 0.0);
//  }
//  
//  @Test
//  public void testSquareRoot(){
//	  storage.setNum(process.sqrt(81));
//	  System.out.println(""+ storage.getNum());
//	  assertTrue(storage.getNum() == 9.0);

//  }
  
  //Aufgabe 2.3.
  @Test
  public void testAppendDigit(){
//	  process.appendDigit("2222222222222222222222");
//	  assertEquals(process.getNumberLine().length(), 21);
	 
  }
  @Test
  public void testAppendDot(){
	  process.appendDot();
	  
	  System.out.println(process.getNumberLine());
	  assertTrue((""+(process
			  .getNumberLine().charAt(process.getNumberLine().length()-1)))
			  .equals("."));
	  
	  process.appendDot();
	  assertFalse((""+(process
			  .getNumberLine().charAt(process.getNumberLine().length()-2)))
			  .equals("."));
	  
	  process.appendDigit("2222222222222222222222");
	  process.appendDot();
	  assertFalse((""+(process
			  .getNumberLine().charAt(process.getNumberLine().length()-1)))
			  .equals("."));
  }
  @Test
  public void testBackspace(){
	  process.appendDigit("22222");
	  process.backspace();
	  assertEquals(process.getNumberLine().length(), 4);
  }
  @Test
  public void testClear(){
	  storage.setNum(22.22);
	  process.clear();
	  assertEquals(storage.getNum(), 0.0, 0.001);	  
  }
  @Test
  public void testDiv(){	  
//	  assertEquals(process.div(5, 5), 1, 0.001);
	  
	  boolean error = false;
	  
	  try
	  {
		  process.div(5, 0);
	  }catch(ArithmeticException e)
	  {
		  error = true;
	  }
	  
		assertTrue(error);
	  }
 

}
