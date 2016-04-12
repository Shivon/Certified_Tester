import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logic.Storage;

public class Storage_test {

  private Storage store;
 
  @Before
  public void setUp() throws Exception {
    store = new Storage();
  }

  @After
  public void tearDown() throws Exception {
    store = null;
  }

  @Test
  public void test() {
  }

}
