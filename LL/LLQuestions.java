/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nodeNext = node.next;
        
        node.val = nodeNext.val;
        node.next = nodeNext.next;
        nodeNext.next = null;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int length(ListNode head) {
        int count = 0;
        
        while(head != null) {
            head = head.next;
            count++;
        }
        
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = length(headA);
        int l2 = length(headB);
        
        int diff = 0;
        
        ListNode lN1 = null;
        ListNode lN2 = null;
        
        if(l1 >= l2) {
            diff = l1 - l2;
            lN1 = headA;
            lN2 = headB;
        } else {
            diff = l2 - l1;
            
            lN1 = headB;
            lN2 = headA;
        }
        
        while(diff > 0) {
            lN1 = lN1.next;
            diff--;
        }
        while(lN1 != null && lN2 != null) {
            if(lN1 == lN2) {
                return lN1;
            }
            
            lN1 = lN1.next;
            lN2 = lN2.next;
        }
        
        return null;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        ListNode rev = head;
        ListNode toDo = head.next;
        
        rev.next = null;
        
        while(toDo != null) {
            ListNode temp = toDo;
            toDo = toDo.next;
            temp.next = rev;
            
            rev = temp;
        }
        
        return rev;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = new ListNode(-1);
        curr.next = head;
        ListNode temp = curr;
        while(temp != null && temp.next != null) {
            if(temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        
        return curr.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head, ListNode tail) {
       
        //System.out.println(tail.next);
        if(head == null || head.next == null) {
            return head;
        }
        ListNode revList = head;
         //System.out.println(head);
        ListNode toDo = head.next;
        revList.next = null;
        
        while(toDo != tail) {
            ListNode temp = toDo;
            //System.out.println(toDo.val + " " + tail.val);
            toDo = toDo.next;
            
            temp.next = revList;
            revList = temp;
        }
        //System.out.println(revList.val);
        return revList;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode a = head, b = head;
        
        for(int i = 0; i < k; i++) {
            if(b == null) {
                return head;
            }
            b = b.next;
        }
        
        ListNode newHead = reverseList(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode reverseList(ListNode head, ListNode tail) {
       
        //System.out.println(tail.next);
        if(head == null || head.next == null) {
            return head;
        }
        ListNode revList = head;
         //System.out.println(head);
        ListNode toDo = head.next;
        revList.next = null;
        
        while(toDo != tail) {
            ListNode temp = toDo;
            //System.out.println(toDo.val + " " + tail.val);
            toDo = toDo.next;
            
            temp.next = revList;
            revList = temp;
        }
        //System.out.println(revList.val);
        return revList;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode a = head, b = head;
        
        for(int i = 0; i < k; i++) {
            if(b == null) {
                return head;
            }
            b = b.next;
        }
        
        ListNode newHead = reverseList(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }
    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        
        while(odd != null && odd.next != null && even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            
            even.next = even.next.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        
        return oddHead;
    }
}
