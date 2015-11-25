/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs21120.depq;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Michal Goly
 */
public class ProperTests {

   /**
    * Test of inspectLeast method, of class DEPQ.
    */
   @Test
   public void testInspectLeast() {
      DEPQ depq = new Mwg2DEPQ();

      ArrayList<Integer> array = new ArrayList<Integer>();
      int smallest = 10000;
      // First check adding random number gives correct smallest
      for (int i = 0; i < 100; i++) {
         int k = (int) (Math.random() * 100);
         array.add(k);
         depq.add(k);
         if (k < smallest) {
            smallest = k;
         }

         Integer result = (Integer) depq.inspectLeast();
         assertEquals(smallest, result.intValue());

      }
   }

   /**
    * Test of getLeast method, of class DEPQ.
    */
   @Test
   public void testGetLeast() {
      DEPQ depq = new Mwg2DEPQ();

      for (int i = 0; i < 1000; i++) {
         depq.add((int) (Math.random() * 100));
      }
      for (int i = 0; i < 1000; i++) {
         Integer expResult = (Integer) depq.inspectLeast();
         Integer result = (Integer) depq.getLeast();
         assertEquals(expResult, result);
      }
   }
}
