import java.util.HashSet;
import java.util.Set;


public class LList {
	Node header;
	int size;
	
	static class Node {
		int elem;
		Node next;
	}
	
	// 1.a class invariant implementation
	// return true if and only if
	// (1) this a loop-list and
	// (2) size is the number of node in this list
	public boolean repOk() {
		if ( header == null ) {
			return size == 0; // list should be empty
		}
		Set<Node> visited = new HashSet<Node>();
		Node node = header;
		while ( node.next != null ) {
			// last node points to a previously seen node
			if ( !visited.add(node.next ) && node != node.next ) return false;
			// last node points back to itself, list size should match number of visited nodes
			else if ( node == node.next ) return size == visited.size();
			// continue iterating through list
			node = node.next;
		}
		// node.next == null - last node doesn't point back to itself
		return false;
	}
	
	// 1.b addFirst method implementation
	// adds a new node with element x at the *head* of the list
	// all other list nodes remain unchanged
	public void addFirst(int x) {
		Node newHeader = new Node();
		newHeader.elem = x;
		if ( header == null ) {
			// Current list is empty so set new node to point to itself
			newHeader.next = newHeader;
		} else {
			// Current list is non empty so set new node to point to current header
			newHeader = header;
		}
		// Set new node as head of list
		header = newHeader;
		// Increment list size by one for new node
		size++;
	}
	
	// 1.c addLast method implementation
	// add a new node with element x at the *tail* of the list
	// all other list nodes remain unchanged
	public void addLast(int x) {
		Node newNode = new Node();
		newNode.elem = x;
		newNode.next = newNode; // last node needs to point to itself
		size++; // increase size for new node
		if ( header == null ) {
			header = newNode; // header is both the last and only node
			return;
		}
		Node node = header;
		while ( node.next != null && node.next != node ) {
			node = node.next; // iterate the list until the last node is found
		}
		node.next = newNode;
	}
	
	// 1.d toString method implementation
	// returns a string representation of the list of elements in this,
	// where consecutive elements are seperated by a space
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node node = header;
		while ( node != null ) {
			if ( node != header ) {
				builder.append(" "); // seperate values by ' '
			}
			builder.append(node.elem);
			if ( node.next != null && node.next != node ) {
				// go to the next node
				node = node.next;
			} else {
				// set node to null to jump out of switch
				node = null;
			}
		}
		return builder.toString();
	}
}
