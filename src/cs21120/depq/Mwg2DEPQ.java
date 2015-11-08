package cs21120.depq;

/**
 *
 * @author Michal Goly
 */
public class Mwg2DEPQ implements DEPQ {
   
   private Interval[] intervalHeap;
   private int size;
   
   public Mwg2DEPQ() {
      intervalHeap = new Interval[500];
      size = 0;
   }
   
   @Override
   public Comparable inspectLeast() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

   }

   @Override
   public Comparable inspectMost() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

   }

   @Override
   public void add(Comparable c) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

   }

   @Override
   public Comparable getLeast() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public Comparable getMost() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public boolean isEmpty() {
      return size == 0;
   }

   @Override
   public int size() {
      return size;
   }
   
   private class Interval {
      
      private Comparable left;
      private Comparable right;
      
      public Interval() {
      }
      
   }

}
