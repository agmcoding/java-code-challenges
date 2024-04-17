package packageMiddleOfTheLinkedList;

public class Main {

//	Challenge:
//	
//	Given the head of a singly linked list, return the middle node of the linked list.
//	If there are two middle nodes, return the second middle node.
//
//	Example 1:
//
//	Input: head = [1,2,3,4,5]
//	Output: [3,4,5]
//	Explanation: The middle node of the list is node 3.
//
//	Example 2:
//
//	Input: head = [1,2,3,4,5,6]
//	Output: [4,5,6]
//	Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
//				 
//
//	Constraints:
//
//	The number of nodes in the list is in the range [1, 100].
//	1 <= Node.val <= 100

	/*
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 *     
	 *     @Override
	 *	   public String toString() { // I implemented this toString method so we can print the ListNodes.
	 *	   return "ListNode [val=" + val + ", next=" + next + "]";  
	 *	   }
	 * }
	 */
	
	public static void main(String[] args) {
		
		ListNode headNextNextNextNextNext = new ListNode(6);
		ListNode headNextNextNextNext = new ListNode(5, headNextNextNextNextNext);
		ListNode headNextNextNext = new ListNode(4, headNextNextNextNext);
		ListNode headNextNext = new ListNode(3,headNextNextNext );
		ListNode headNext = new ListNode(2,headNextNext);
		ListNode head = new ListNode(1,headNext);
		
		System.out.println(middleNode(head));
		
		/* Output Result:
		 * ListNode [val=4, next=ListNode [val=5, next=ListNode [val=6, next=null]]]
		 */	
	}
	
	// When using a LinkedList, it isn't possible to use index. Instead, we need to iterate over the linked list.
	
	static ListNode middleNode(ListNode head) {
        ListNode auxiliaryVariable = head;
        int listLength = 0;
        
        while (auxiliaryVariable != null) {
            auxiliaryVariable = auxiliaryVariable.next;
            listLength++; // This is for obtaining the length of the list.
        }
        
        int halfOfTheList = listLength / 2;
        auxiliaryVariable = head;
        for (int i = 0; i < halfOfTheList ; i++) { // This is for reaching the middle of the list.
            auxiliaryVariable = auxiliaryVariable.next;
        }
        return auxiliaryVariable;
    }
	
}