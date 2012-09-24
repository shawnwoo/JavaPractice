package dataStructure;

public class LinkedList {

	Object data;
	LinkedList next = null;

	public LinkedList(Object data) {
		this.data=data;

	}

	void append(Object data) {
		LinkedList node = new LinkedList(data);
		LinkedList n = this;

		while (n.next != null) {
			n = n.next;
		}

		n.next = node;
	}

}
