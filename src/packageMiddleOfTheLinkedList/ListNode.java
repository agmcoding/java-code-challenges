package packageMiddleOfTheLinkedList;

public class ListNode {

	protected int val;
	protected ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {   // I implemented this toString method so we can print the ListNodes.
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

}
