/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs21120.depq;

/**
 *
 * @author Michal Goly
 */
public class Main {

   public static void main(String[] args) {
      Mwg2DEPQ q = new Mwg2DEPQ();
      q.add(12);
      q.add(9);
      q.add(10);
      q.add(66);
      q.add(2);
      q.add(4);
      q.add(40);
      q.add(45);
      q.add(72);

      System.out.println(q.getLeast());
      System.out.println(q.getLeast());
      System.out.println(q.getLeast());
      System.out.println(q.getLeast());

      q.add(6);
      q.add(1);
      System.out.println(q.getLeast());
      System.out.println(q.getLeast());
      System.out.println(q.getLeast());
      System.out.println(q.getLeast());
      System.out.println(q.getLeast());
      System.out.println(q.getLeast());
      System.out.println(q.getLeast());
      System.out.println(q.getLeast());
      System.out.println(q.getLeast());
      System.out.println(q.getLeast());

   }

}
