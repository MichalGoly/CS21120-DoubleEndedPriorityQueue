package cs21120.depq;

/**
 *
 * @author Michal Goly
 */
public class Mwg2DEPQ implements DEPQ {
   
   private Interval[] intervalHeap;
   private int heapSize;
   private int elementsNumber;
   
   public Mwg2DEPQ() {
      intervalHeap = new Interval[500];
      heapSize = 0;
      elementsNumber = 0;
   }
   
   @Override
   public Comparable inspectLeast() {
      if (elementsNumber == 0) {
         return null;
      } else if (elementsNumber == 1) {
         Interval root = intervalHeap[0];
         
         if (root.leftNode == null) {
            return root.rightNode;
         } else {
            return root.leftNode;
         }
      } else {
         Interval root = intervalHeap[0];
         return root.leftNode;
      } 
   }

   @Override
   public Comparable inspectMost() {
      if (elementsNumber == 0) {
         return null;
      } else if (elementsNumber == 1) {
         Interval root = intervalHeap[0];
         
         if (root.leftNode == null) {
            return root.rightNode;
         } else {
            return root.leftNode;
         } 
      } else {
         Interval root = intervalHeap[0];
         return root.rightNode;
      }
   }

   @Override
   public void add(Comparable c) {
      if (heapSize == 0) {
         intervalHeap[0] = new Interval(c, c);
         heapSize++;
         elementsNumber++;
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
      return elementsNumber == 0;
   }

   @Override
   public int size() {
      return elementsNumber;
   }
   
   private class Interval {
      
      private Comparable leftNode;
      private Comparable rightNode;
      
      public Interval() {}
      
      public Interval(Comparable leftNode, Comparable rightNode) {
         this.leftNode = leftNode;
         this.rightNode = rightNode;
         
         if (leftNode == null) {
            this.leftNode = rightNode;
         }
         if (rightNode == null) {
            this.rightNode = leftNode;
         }
      }

      public void setLeftNode(Comparable leftNode) {
         this.leftNode = leftNode;
         
         if (this.rightNode == null) {
            this.rightNode = leftNode;
         }
      }

      public void setRightNode(Comparable rightNode) {
         this.rightNode = rightNode;
         
         if (this.leftNode == null) {
            this.leftNode = rightNode;
         }
      }

      public Comparable getLeftNode() {
         Comparable temp = leftNode;
         leftNode = null;
         return temp;
      }

      public Comparable getRightNode() {
         Comparable temp = rightNode;
         rightNode = null;
         return temp;
      }
      
   }

}
