package cs21120.depq;

/**
 *
 * @author Michal Goly
 */
public class Mwg2DEPQ implements DEPQ {

   private Interval[] heap;
   private int size;
   private int nodes;

   public Mwg2DEPQ() {
      heap = new Interval[500];
      size = 0;
      nodes = 0;
   }

   @Override
   public Comparable inspectLeast() {
      if (size == 0) {
         return null;
      } else {
         Interval root = heap[0];
         return root.left;
      }
   }

   @Override
   public Comparable inspectMost() {
      if (size == 0) {
         return null;
      } else {
         Interval root = heap[0];
         return root.right;
      }
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

   private void expand() {
      Interval[] newHeap = new Interval[heap.length * 2];
      System.arraycopy(heap, 0, newHeap, 0, heap.length);
      heap = newHeap;
   }

   private class Interval {

      private Comparable left;
      private Comparable right;

      public Interval(Comparable left, Comparable right) {
         this.left = left;
         this.right = right;
      }

   }

}
