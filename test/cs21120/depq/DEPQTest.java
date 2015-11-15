package cs21120.depq;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Some basics tests of a Double Ended Priority Queue interface DEPQ You will need to
 * change the setUp method to create an instance of your class that implements the
 * interface. Feel free to add more tests to ensure your solution is working as you
 * expect.
 *
 * ArrayList is only used here for testing, do not use it, or any classes from
 * java.util, in your implementation
 *
 * @author bpt
 */
public class DEPQTest {

   DEPQ depq;

   @Before
   public void setUp() {
      depq = new Mwg2DEPQ(); //TODO, Replace with constructor for your implemenation
   }


   /**
    * Test of inspectMost method, of class DEPQ.
    */
   @Test
   public void testInspectMost() {
      System.out.println("inspectMost");

      ArrayList<Integer> array = new ArrayList<Integer>();
      int largest = -10000;
      // First check adding random number gives correct largest
      for (int i = 0; i < 100; i++) {
         int k = (int) (Math.random() * 100);
         array.add(k);
         depq.add(k);
         if (k > largest) {
            largest = k;
         }

         Integer result = (Integer) depq.inspectMost();
         assertEquals(largest, result.intValue());

      }

      // Next randomly add or remove and check inspect most
      for (int i = 0; i < 99; i++) {
         boolean add = Math.random() > 0.5;
         if (add) {
            int k = (int) (Math.random() * 100);
            array.add(k);
            depq.add(k);
            if (k > largest) {
               largest = k;
            }
         } else {
            Integer discarded = (Integer) depq.getMost();
            array.remove(discarded);
            largest = array.get(0);
            for (int j = 1; j < array.size(); j++) {
               if (array.get(j) > largest) {
                  largest = array.get(j);
               }
            }
         }

         Integer result = (Integer) depq.inspectMost();
         assertEquals(largest, result.intValue());
      }
   }

   /**
    * Test of add method, of class DEPQ.
    */
   @Test
   public void testAdd() {
      System.out.println("add");

      for (int i = 0; i < 1000; i++) {
         int k = (int) (Math.random() * 100);
         depq.add(k);
         assertEquals(i + 1, depq.size());
      }

   }

   /**
    * Test of getLeast method, of class DEPQ.
    */
   @Test
   public void testGetLeast() {
      System.out.println("getLeast");

      for (int i = 0; i < 1000; i++) {
         depq.add((int) (Math.random() * 100));
      }
      for (int i = 0; i < 1000; i++) {
         Integer expResult = (Integer) depq.inspectLeast();
         Integer result = (Integer) depq.getLeast();
         assertEquals(expResult, result);
      }
   }

   /**
    * Test of getMost method, of class DEPQ.
    */
   @Test
   public void testGetMost() {
      System.out.println("getMost");

      for (int i = 0; i < 1000; i++) {
         depq.add((int) (Math.random() * 100));
      }
      for (int i = 0; i < 1000; i++) {
         Integer expResult = (Integer) depq.inspectMost();
         Integer result = (Integer) depq.getMost();
         assertEquals(expResult, result);
      }
   }

   /**
    * Test of isEmpty method, of class DEPQ.
    */
   @Test
   public void testIsEmpty() {
      System.out.println("isEmpty");

      boolean expResult = true;
      boolean result = depq.isEmpty();
      assertEquals(expResult, result);

      for (int i = 0; i < 10; i++) {
         int count = (int) (Math.random() * 1000);
         for (int j = 0; j < count; j++) {
            depq.add(j);
            assertEquals(false, depq.isEmpty());
         }
         for (int j = 0; j < count; j++) {
            assertEquals(false, depq.isEmpty());
            depq.getLeast();
         }
         assertEquals(true, depq.isEmpty());
      }
   }

   /**
    * Test of size method, of class DEPQ.
    */
   @Test
   public void testSize() {
      System.out.println("size");

      for (int i = 0; i < 1000; i++) {
         int k = (int) (Math.random() * 100);
         depq.add(k);
         assertEquals(i + 1, depq.size());
      }

      for (int i = 0; i < 1000; i++) {
         boolean bigEnd = Math.random() > 0.5;
         if (bigEnd) {
            depq.getMost();
         } else {
            depq.getLeast();
         }
         assertEquals(1000 - i - 1, depq.size());
      }
   }

   /**
    * Test of inspectLeast method, of class DEPQ.
    */
   @Test
   public void testInspectLeast() {
      System.out.println("inspectLeast");

      ArrayList<Integer> array = new ArrayList<Integer>();
      int smallest = 10000;
      // First check adding random number gives correct smallest
      for (int i = 0; i < 99; i++) {
         int k = (int) (Math.random() * 100);
         System.out.println("Loop 1: Adding " + k);
         array.add(k);
         depq.add(k);
         if (k < smallest) {
            smallest = k;
         }

         Integer result = (Integer) depq.inspectLeast();
         assertEquals(smallest, result.intValue());

      }

      // Next randomly add or remove and check inspect least
      for (int i = 0; i < 100; i++) {
         boolean add = Math.random() > 0.5;
         if (add) {
            int k = (int) (Math.random() * 100);
            System.out.println("Loop 2: Adding " + k);
            array.add(k);
            depq.add(k);
            if (k < smallest) {
               smallest = k;
            }
         } else {
            Integer discarded = (Integer) depq.getLeast();
            System.out.println("Loop 2: Discarding " + discarded);
            array.remove(discarded);
            smallest = array.get(0);
            for (int j = 1; j < array.size(); j++) {
               if (array.get(j) < smallest) {
                  smallest = array.get(j);
               }
            }
         }

         Integer result = (Integer) depq.inspectLeast();
         System.out.println("The new least is: " + result);
         assertEquals(smallest, result.intValue());
      }
   }

}
