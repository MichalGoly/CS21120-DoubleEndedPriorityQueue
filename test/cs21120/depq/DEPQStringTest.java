package cs21120.depq;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Some basics tests of a Double Ended Priority Queue interface DEPQ
 * You will need to change the setUp method to create an instance of your class that implements the interface.
 * Feel free to add more tests to ensure your solution is working as you expect.
 * 
 * ArrayList is only used here for testing, do not use it, or any classes from java.util, in your implementation
 * 
 * @author bpt
 */
public class DEPQStringTest {
    DEPQ depq;
    
    public static char[] letters = {'a', 'b', 'c', 'd', 'e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    @Before
    public void setUp() {
        depq = new Mwg2DEPQ(); //TODO, Replace with constructor for your implemenation
    }
    
    public String randomString(int len) {
        char[] word = new char[len];
        for (int i=0; i<len; i++) word[i] = letters[(int)(Math.random()*letters.length)];
        String str = new String(word);
        
        return str;
    }
    /**
     * Test of inspectLeast method, of class DEPQ.
     */
    @Test
    public void testInspectLeast() {
        System.out.println("inspectLeast");
        
        ArrayList<String> array = new ArrayList<String>();
        String smallest = "zzzzz";
        // First check adding random number gives correct smallest
        for (int i=0; i<100; i++) {
            
            String kstr = randomString(smallest.length());
            array.add(kstr);
            depq.add(kstr);
            if (kstr.compareTo(smallest)<0) smallest = kstr;
            
            String result = (String)depq.inspectLeast();
            assertEquals(smallest, result);
        
        }
        
        // Next randomly add or remove and check inspect least
        for (int i=0; i<99; i++) {
            boolean add = Math.random()>0.5;
            if (add) {
                String kstr = randomString(smallest.length());
            
                array.add(kstr);
                depq.add(kstr);
                if (kstr.compareTo(smallest)<0) smallest = kstr;
            } else {
                String discarded = (String)depq.getLeast();
                array.remove(discarded);
                smallest = array.get(0);
                for(int j=1; j<array.size(); j++) {
                    if (array.get(j).compareTo(smallest)<0) smallest = array.get(j);
                }
            }
            
            String result = (String)depq.inspectLeast();
            assertEquals(smallest, result);
        }
    }
    /**
     * Test of inspectMost method, of class DEPQ.
     */
    @Test
    public void testInspectMost() {
        System.out.println("inspectMost");
        
        ArrayList<String> array = new ArrayList<String>();
        String largest = "a";
        // First check adding random number gives correct largest
        for (int i=0; i<100; i++) {
            String kstr = randomString(5);
            
            array.add(kstr);
            depq.add(kstr);
            if (kstr.compareTo(largest)>0) largest = kstr;
            
            String result = (String)depq.inspectMost();
            assertEquals(largest, result);
        
        }
        
        // Next randomly add or remove and check inspect most
        for (int i=0; i<99; i++) {
            boolean add = Math.random()>0.5;
            if (add) {
                String kstr = randomString(5);
            
                array.add(kstr);
                depq.add(kstr);
                if (kstr.compareTo(largest)>0) largest = kstr;
            } else {
                String discarded = (String)depq.getMost();
                array.remove(discarded);
                largest = array.get(0);
                for(int j=1; j<array.size(); j++) {
                    if (array.get(j).compareTo(largest)>0) largest = array.get(j);
                }
            }
            
            String result = (String)depq.inspectMost();
            assertEquals(largest, result);
        }
    }

    /**
     * Test of add method, of class DEPQ.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        
        for (int i=0; i<1000; i++) {
            String kstr = randomString(5);
            
            depq.add(kstr);
            assertEquals(i+1, depq.size());
        }
        
    }

    /**
     * Test of getLeast method, of class DEPQ.
     */
    @Test
    public void testGetLeast() {
        System.out.println("getLeast");
        
        for (int i=0; i<1000; i++) {
            depq.add(randomString(5));
        }
        for (int i=0; i<1000; i++) {
            String expResult = (String)depq.inspectLeast();
            String result = (String)depq.getLeast();
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of getMost method, of class DEPQ.
     */
    @Test
    public void testGetMost() {
        System.out.println("getMost");
        
        for (int i=0; i<1000; i++) {
            depq.add(randomString(5));
        }
        for (int i=0; i<1000; i++) {
            String expResult = (String)depq.inspectMost();
            String result = (String)depq.getMost();
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
        
        for (int i=0; i<10; i++) {
            int count = (int)(Math.random()*1000);
            for (int j=0; j<count; j++) {
                depq.add(""+j);
                assertEquals(false, depq.isEmpty());
            }
            for (int j=0; j<count; j++) {
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
        
        for (int i=0; i<1000; i++) {
            int k = (int)(Math.random()*100);
            depq.add(""+k);
            assertEquals(i+1, depq.size());
        }
        
        for (int i=0; i<1000; i++) {
            boolean bigEnd = Math.random()>0.5;
            if (bigEnd) depq.getMost();
            else depq.getLeast();
            assertEquals(1000-i-1, depq.size());
        }
    }
}