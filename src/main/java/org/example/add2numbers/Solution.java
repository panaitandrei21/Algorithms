package org.example.add2numbers;
//public class ListNode {
//  int val;
//  ListNode next;
//  ListNode() {}
//  ListNode(int val) { this.val = val; }
//  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

// LeetCode add 2 numbers
public class Solution {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int sum = carry;

      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      // Calculăm suma și transportul
      carry = sum / 10; // Transportul (dacă suma este mai mare sau egală cu 10)
      current.next = new ListNode(sum % 10); // Adăugăm noul nod cu valoarea curentă
      current = current.next;
    }

    return dummy.next;
  }

  // Funcție pentru a afișa o listă
  private static void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println();
  }
}
