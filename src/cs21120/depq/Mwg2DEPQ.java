package cs21120.depq;

/**
 *
 * @author Michal Goly
 */
public class Mwg2DEPQ implements DEPQ {

   private Interval[] heap;
   private int size;

   public Mwg2DEPQ() {
      heap = new Interval[1000];
      size = 0;
   }

   @Override
   public Comparable inspectLeast() {
      if (size == 0) {
         return null;
      } else {
         Interval root = heap[0];
         return root.getLeft();
      }
   }

   @Override
   public Comparable inspectMost() {
      if (size == 0) {
         return null;
      } else {
         Interval root = heap[0];
         return root.getRight();
      }
   }

   @Override
   public void add(Comparable c) {
      if (size == heap.length) {
         expand();
      }

      if (size == 0) {
         heap[0] = new Interval(c, c);
         size++;
      } else if (size == 1) {
         if (c.compareTo(heap[0].getLeft()) < 0) {
            heap[0].setLeft(c);
         } else {
            heap[0].setRight(c);
         }
         size++;
      } else {
         // size >= 2
         if (size % 2 == 0) {
            int newNodeIndex = (size / 2) + (size % 2);
            int parentIndex = (newNodeIndex - 1) / 2;

            // if c < parent.left
            if (c.compareTo(heap[parentIndex].getLeft()) < 0) {
               minHeapInsert(c, newNodeIndex);

               // duplicate the item in the last Interval
               heap[newNodeIndex].setRight(heap[newNodeIndex].getLeft());
            } else {
               maxHeapInsert(c, newNodeIndex);

               // duplicate the item in the last Interval
               heap[newNodeIndex].setLeft(heap[newNodeIndex].getRight());
            }
         } else {
            int lastNodeIndex = (size / 2) + (size % 2) - 1;

            if (c.compareTo(heap[lastNodeIndex].getLeft()) < 0) {
               minHeapInsert(c, lastNodeIndex);
            } else {
               maxHeapInsert(c, lastNodeIndex);
            }
         }
      }
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

   private void minHeapInsert(Comparable c, int lastNodeIndex) {

      int index = lastNodeIndex;
      while (index != 0) {

         int parent = (index - 1) / 2;

         if (c.compareTo(heap[parent].getLeft()) < 0) {
            // move parent.left down (explicitly) and c up (implicitly)
            heap[index].setLeft(heap[parent].getLeft());
         }
         index = parent;
      }

      heap[lastNodeIndex].setLeft(c);
      size++;
   }
   // TODO index and lastNodeIndex should be changed to work properly
   // heap insert methods need re-writing due to bug 
   private void maxHeapInsert(Comparable c, int lastNodeIndex) {

      int index = lastNodeIndex;
      while (index != 0) {
         
         int parent = (index - 1) / 2;

         if (c.compareTo(heap[parent].getRight()) > 0) {
            // move parent.right down (explicitly) and c up (implicitly)
            heap[index].setRight(heap[parent].getRight());
         }
         index = parent;
      }

      heap[index].setRight(c);
      size++;
   }

   private class Interval {

      private Comparable left;
      private Comparable right;

      public Interval() {
      }

      public Interval(Comparable left, Comparable right) {
         this.left = left;
         this.right = right;
      }

      public Comparable getLeft() {
         return left;
      }

      public Comparable getRight() {
         return right;
      }

      public void setLeft(Comparable left) {
         this.left = left;
      }

      public void setRight(Comparable right) {
         this.right = right;
      }

   }

}
